//package exam;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet("/result")
//public class DBresult extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    private static final String DB_URL = "jdbc:mysql://localhost/exam_db";
//    private static final String DB_USERNAME = "root";
//    private static final String DB_PASSWORD = "Psc.2003";
//
//    @SuppressWarnings("unchecked")
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//
////        int score = (int) session.getAttribute("score");
//        List<Question> lists = (List<Question>) session.getAttribute("list");
//
//        try {
//        	System.out.println("tttttttt");
//            Class.forName(JDBC_DRIVER);
//            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//
//            // Insert the result for each question into the "exam_results" table
//            for (Question question : lists) {
//                String username = (String) session.getAttribute("username"); // Assuming you have stored the username in the session
//
//                String query = "INSERT INTO results (username, question, selected_option, correct_answer, result, score) VALUES (?, ?, ?, ?, ?, ?)";
//                PreparedStatement statement = connection.prepareStatement(query);
//                statement.setString(1, username);
//                statement.setString(2, question.getQuestionText());
//                statement.setString(3, question.getSelectedAnswer());
//                statement.setString(4, question.getCorrectAnswer());
//                statement.setString(5, question.getResult());
//                statement.setInt(6, question.getScores());
//                statement.executeUpdate();
//            }
//
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Forward the request to resultpage.jsp
//        //request.getRequestDispatcher("loginpage.jsp").forward(request, response);
//    }
//}
