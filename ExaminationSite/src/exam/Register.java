package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/exam_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Psc.2003";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String password = request.getParameter("password");
        String conpass = request.getParameter("conpass");
        PrintWriter out=response.getWriter();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            boolean Successful = false;
            if (password.equals(conpass)){
            	Successful = true;
            }
            if (Successful) {
            	String query = "INSERT INTO students (username, email, password, DoB) VALUES (?, ?, ?, ?)";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.setString(4, dob);
                stmt.executeUpdate();
            	out.print("success");
            } else {
                out.print("FAIL");
            }
            
            } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("registrationpage.jsp").forward(request, response);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

