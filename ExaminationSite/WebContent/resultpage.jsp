<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<style>
body {
	background-image:
		url('https://media-whichmedia.s3.ap-southeast-1.amazonaws.com/media/large/e/b/eb0428d34412.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}

h1 {
	text-align: center;
	color: black;
}
p {
	text-align: right;
	color: white;
	font-size:50px;
}
table {
	margin: 100px auto;
	border-collapse: collapse;
	background-color: powderblue;
	color: black;
}

table th, table td {
	padding: 10px;
	border: 1px solid black;
}
input[type="button"]{
            background-color: green;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
}
</style>
</head>
<body text="white">
	<h1>RESULT</h1>
	<form action="result" method="post">
		<table>
			<tr>
				<th>Question</th>
				<th>Selected Options</th>
				<th>Correct Answer</th>
				<th>Result</th>
				<th>Score</th>
			</tr>
			<c:forEach var="question" items="${list}">
				<tr>
					<td>${question.questionText}</td>
					<td>${question.selectedAnswer}</td>
					<td>${question.correctAnswer}</td>
					<td>${question.result}</td>
					<td>${question.scores}</td>
				</tr>
			</c:forEach>
			<tr>
				<td> </td>
				<td> </td>
				<td> </td>
				<th>Total SCORE :</th>
				<td>${score}</td>
			</tr>
		</table>
		<div align="center">
			<a href="loginpage.jsp"><input type="button" value="Done" ></a>
		</div>
		<p>Thank you !!!!</p>
	</form>
</body>
</html>
