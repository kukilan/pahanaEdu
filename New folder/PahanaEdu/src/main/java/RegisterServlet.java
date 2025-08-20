import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

        try {
            // 2. Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. Connect to database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/book", "root", "");

            // 4. Prepare SQL insert statement
            String sql = "INSERT INTO users (FullName, Username, Address, Telephone, Email, Password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, address);
            ps.setString(4, telephone);
            ps.setString(5, email);
            ps.setString(6, password);

            // 5. Execute insert
            int rows = ps.executeUpdate();

            // 6. Response to client
            if (rows > 0) {
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
