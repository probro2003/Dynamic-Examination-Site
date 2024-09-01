package exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reset")
public class Reset extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/exam_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Psc.2003";
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form inputs
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String newPassword = request.getParameter("newpassword");
        String confirmPassword = request.getParameter("confirmpassword");
        PrintWriter out = response.getWriter();
        Connection conn = null;

        // Perform password reset logic
        boolean resetSuccessful = false;

        // Perform validation by querying the database
        try {
        	Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement validateStatement = conn.prepareStatement("SELECT * FROM students WHERE email = ? AND dob = ?");
            PreparedStatement updateStatement = conn.prepareStatement("UPDATE students SET password = ? WHERE email = ?");
            

            // Validate the user
            validateStatement.setString(1, email);
            validateStatement.setString(2, dob);

            try (ResultSet resultSet = validateStatement.executeQuery()) {
                // Check if a matching user is found
                if (resultSet.next()) {
                    // Update the password in the database
                    if (newPassword.equals(confirmPassword)) {
                        resetSuccessful = true;
                    }
                    if(resetSuccessful) {
                        updateStatement.setString(1, newPassword);
                        updateStatement.setString(2, email);
                        out.print("success");
                    } else {
                    	out.print("fail");
                    }
                }
            }
        }
         catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}
