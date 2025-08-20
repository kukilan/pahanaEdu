import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet; //your class extends this to handle HTTP requests.
import jakarta.servlet.http.HttpServletRequest;//used to read data sent by the client (like form inputs).
import jakarta.servlet.http.HttpServletResponse;//used to send response data (HTML, redirect, etc.) back to the browser.
import jakarta.servlet.http.HttpSession;//used to store user data during the session (like login info).

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/book", "root", "");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE Username=? AND Password=?");
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user);
                response.sendRedirect("welcome.jsp"); // redirect to a welcome page
            } else {
                response.getWriter().println("Invalid credentials.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred: " + e.getMessage());
        }
    }
}
