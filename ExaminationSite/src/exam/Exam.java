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

@WebServlet("/start")
public class Exam extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/exam_db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Psc.2003";
    private static final int questionsToChoose = 5; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	HttpSession session = request.getSession(false);
            // Establish a database connection
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Prepare the SQL statement to fetch random questions
            String query = "SELECT * FROM questions ORDER BY RAND() LIMIT ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Set the number of questions to randomly choose as a parameter in the prepared statement
            statement.setInt(1, questionsToChoose);

            // Execute the query and retrieve the result set
            ResultSet resultSet = statement.executeQuery();

            // Store the questions and their details in a List or other suitable data structure
            List<Question> questions = new ArrayList<>();

            while (resultSet.next()) {
                int questionId = resultSet.getInt("question_id");
                String questionText = resultSet.getString("question_text");
                String optionA = resultSet.getString("option_a");
                String optionB = resultSet.getString("option_b");
                String optionC = resultSet.getString("option_c");
                String optionD = resultSet.getString("option_d");
                String correctAnswer = resultSet.getString("correct_answer");
                String selectedAnswer = resultSet.getString("selected_answer");
                String result = resultSet.getString("result");
                int scores = resultSet.getInt("scores");                

                // Create a Question object and add it to the list
                Question question = new Question(questionId, questionText, optionA, optionB, optionC, optionD, correctAnswer, selectedAnswer, result, scores);
                questions.add(question);
            }

            // Pass the questions to the JSP page as an attribute
            session.setAttribute("questions", questions);
            
            // Forward the request to exam.jsp
            request.getRequestDispatcher("exampage.jsp").forward(request, response);

            // Close the database connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle any database errors
            // Redirect to an error page or display an error message
        }
    }
}
