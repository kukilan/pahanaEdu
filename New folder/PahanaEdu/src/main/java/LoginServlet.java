import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {

        	 PreparedStatement ps = con.prepareStatement(
                     "SELECT u.UserID, u.UserName, r.RoleName " +
                     "FROM Users u " +
                     "JOIN UserRole ur ON u.UserID = ur.UserID " +
                     "JOIN Roles r ON ur.RoleID = r.RoleID " +
                     "WHERE u.UserName=? AND u.Password=?"
                 );
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // ✅ Create session
                HttpSession session = request.getSession();
                session.setAttribute("username", rs.getString("UserName"));
                session.setAttribute("role", rs.getString("RoleName"));

                // ✅ Redirect based on role
                String role = rs.getString("RoleName");
                switch (role) {
                    case "Admin":
//                        response.sendRedirect("adminDashboard.jsp");
                    	response.sendRedirect("dashboard.jsp");
                        break;
                    case "Cashier":
                        response.sendRedirect("cashierDashboard.jsp");
                        break;
                    case "Customer":
                        response.sendRedirect("customerHome.jsp");
                        break;
                    default:
                        response.sendRedirect("login.jsp?error=role");
                }
            } else {
                response.sendRedirect("login.jsp?error=1");
            }


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred: " + e.getMessage());
        }
    }
}
