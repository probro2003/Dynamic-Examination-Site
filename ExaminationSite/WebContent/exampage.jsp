<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Examination</title>
<style>
body {
	background-image: url('https://images.unsplash.com/photo-1585862705417-671ae64f0eb7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8ZGFyayUyMGxpYnJhcnl8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&w=600&q=60');
	background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
	color: white;
}

h1 {
	text-align: center;
}

input[type="submit"] {
	margin-right: 200px;
	float: right;
	background-color: green;
	color: white;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
}
p[id="timer"]{
	text-align: right; 
	font-size: 20px; 
	font-weight: bold; 
	margin-top: 20px; 
	margin-right: 200px;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/exam.js"></script>
</head>
<body>
	<h1>EXAMINATION</h1>
	<form id="examForm" action="exam" method="post">
	<p id="timer">01:00</p>
		<div style="margin-left: 200px">
			<div style="margin-top: 100px">
				<ol class="quiz">
					   <c:forEach var="question" items="${questions}">
                        <li>
                            <h4>${question.questionText}</h4>
                            <ul class="choices">
                                <li><label><input type="radio" name="answer${question.questionId}" value="A" />${question.optionA}</label></li>
                                <li><label><input type="radio" name="answer${question.questionId}" value="B" />${question.optionB}</label></li>
                                <li><label><input type="radio" name="answer${question.questionId}" value="C" />${question.optionC}</label></li>
                                <li><label><input type="radio" name="answer${question.questionId}" value="D" />${question.optionD}</label></li>
                            </ul>
                        </li>
                      </c:forEach>
				</ol>
				<input type="submit" value="SUBMIT">
			</div>
		</div>
	</form>

</body>
</html>
