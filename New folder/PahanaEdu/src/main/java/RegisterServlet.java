import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Read form parameters
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Optional: roles can come from form (checkboxes or dropdown)
        // Example: request.getParameterValues("roles")
        //String[] roles = request.getParameterValues("roles"); 
        String[] roles = null;
        if (roles == null) {
            // Default role = Customer if none selected
            roles = new String[]{"Customer"};
        }

        try {
            // 2. Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. Connect to database
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/book", "root", "");
            Connection con = DBConnection.getConnection();

            // 4. Insert new user
            String sql = "INSERT INTO users (FullName, Username, Address, Telephone, Email, Password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, address);
            ps.setString(4, telephone);
            ps.setString(5, email);
            ps.setString(6, password);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                // 5. Get generated UserID
                ResultSet rs = ps.getGeneratedKeys();
                int userId = 0;
                if (rs.next()) {
                    userId = rs.getInt(1);
                }

                // 6. Insert roles into UserRole
                for (String roleName : roles) {
                    // Find RoleID from Roles table
                    PreparedStatement psRole = con.prepareStatement(
                        "SELECT RoleID FROM Roles WHERE RoleName=?"
                    );
                    psRole.setString(1, roleName);
                    ResultSet rsRole = psRole.executeQuery();
                    if (rsRole.next()) {
                        int roleId = rsRole.getInt("RoleID");

                        PreparedStatement psUserRole = con.prepareStatement(
                            "INSERT INTO UserRole (UserID, RoleID) VALUES (?, ?)"
                        );
                        psUserRole.setInt(1, userId);
                        psUserRole.setInt(2, roleId);
                        psUserRole.executeUpdate();
                        psUserRole.close();
                    }
                    rsRole.close();
                    psRole.close();
                }

                // 7. Redirect success
                response.sendRedirect("login.jsp?msg=Registered+Successfully");
            } else {
                response.getWriter().println("Registration failed.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred: " + e.getMessage());
        }
    }
}