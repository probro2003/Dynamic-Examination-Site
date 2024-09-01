package exam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/exam")
public class Result extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/exam_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Psc.2003";

 
    @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	
        String username = (String) session.getAttribute("username");

        int score = 0;
        Connection connection = null;

//        // Retrieve answers from the request parameters
//        String answer1 = request.getParameter("answer1");
//        String answer2 = request.getParameter("answer2");
//        String answer3 = request.getParameter("answer3");
//        String answer4 = request.getParameter("answer4");
//        String answer5 = request.getParameter("answer5");
//        String answer6 = request.getParameter("answer6");
//        String answer7 = request.getParameter("answer7");
//        String answer8 = request.getParameter("answer8");
//        String answer9 = request.getParameter("answer9");
//        String answer10 = request.getParameter("answer10");

//
//        // Compare answers with correct ones and calculate score
//        if ("B".equals(answer1)) {
//            score++;
//        }
//        if ("C".equals(answer2)) {
//            score++;
//        }
//        if ("C".equals(answer3)) {
//            score++;
//        }
//        if ("B".equals(answer4)) {
//            score++;
//        }
//        if ("D".equals(answer5)) {
//            score++;
//        }
//        if ("D".equals(answer6)) {
//            score++;
//        }
//        if ("B".equals(answer7)) {
//            score++;
//        }
//        if ("C".equals(answer8)) {
//            score++;
//        }
//        if ("A".equals(answer9)) {
//            score++;
//        }
//        if ("C".equals(answer10)) {
//            score++;
//        }
        

        try {
        	Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            String queryUpdate = "UPDATE questions SET selected_answer = ?, result = ?, scores = ? WHERE question_id = ?";
            PreparedStatement statementUpdate = connection.prepareStatement(queryUpdate);
            
            List<Question> list = new ArrayList<Question>();
            list = (List<Question>)session.getAttribute("questions");

            for (Question q : list) {
                String qid = "answer"+q.getQuestionId();
                String selectedAnswer = request.getParameter(qid);

                String queryfetch = "SELECT correct_options FROM questions WHERE question_id = ?";
                PreparedStatement stmtfetch = connection.prepareStatement(queryfetch);
                stmtfetch.setInt(1, q.getQuestionId());
                ResultSet resultset = stmtfetch.executeQuery();

                String correctAnswer = "";
                if (resultset.next()) {
                    correctAnswer = resultset.getString("correct_options");
                }

                int scores = selectedAnswer == null ? 0 :selectedAnswer.equals(correctAnswer) ? 1 : 0;
                String result = scores == 1 ? "CORRECT" : (selectedAnswer == null ? "UNFILLED" : "INCORRECT");
                score = scores == 1 ? score+1 : score ; 
                
                q.setSelectedAnswer(selectedAnswer);
                q.setResult(result);
                q.setScores(scores);
                
                statementUpdate.setString(1, selectedAnswer);
                statementUpdate.setString(2, result);
                statementUpdate.setInt(3,scores);
                statementUpdate.setInt(4, q.getQuestionId());
                statementUpdate.executeUpdate();
            }
            
            for (Question q : list) {
                String query = "INSERT INTO results (username, question, selected_option, correct_answer, result, score) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, q.getQuestionText());
                statement.setString(3, q.getSelectedAnswer());
                statement.setString(4, q.getCorrectAnswer());
                statement.setString(5, q.getResult());
                statement.setInt(6, q.getScores());
                statement.executeUpdate();
            }
            
            session.setAttribute("list", list);
            
//            insertResult(connection, username, score);
            
            session.setAttribute("score", score);  

            request.getRequestDispatcher("resultpage.jsp").forward(request, response);

        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

    
//    private void insertResult(Connection connection, String username, int score) throws SQLException {
//        String query = "INSERT INTO results (username, score) VALUES (?, ?)"+ "ON DUPLICATE KEY UPDATE score = VALUES(score)";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setString(1, username);
//        statement.setInt(2, score);
//        statement.executeUpdate();
//    }

}

            