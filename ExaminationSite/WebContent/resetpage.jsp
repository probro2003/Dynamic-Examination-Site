<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Reset</title>
<style>
body {
	background-color: black;
	margin-top: 200px;
}

div {
	color: white;
}

input[type="submit"] {
	background-color: green;
	color: white;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
}

.popup {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.5);
}

.popup-content {
	background-color: black;
	margin: 20% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 300px;
	text-align: center;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/reset.js"></script>
</head>
<body>
	<div align="center">
		<h2>Reset your Password</h2>
		<form action="reset" method="post">
			<table>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" id="email" placeholder="Enter your email" required></td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><input type="text" name="dob" id="dob" placeholder="Enter you DoB" required></td>
				</tr>
				<tr>
					<td>New Password:</td>
					<td><input type="password" name="newpassword" id="newpassword" placeholder="Enter password" required></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input type="password" name="confirmpassword" id="confirmpassword" placeholder="Re-enter your " required></td>
				</tr>
			</table>

			<br> <input type="submit" value="Done"> <br> 
			<a href="loginpage.jsp" style="color: white;">Login</a>
		</form>
	</div>
	<div class="popup">
		<div class="popup-content">
			<h2>Password successfully changed !!!</h2>
			<a href="loginpage.jsp"><button onclick="$('.popup').hide()">OK</button></a>
		</div>
	</div>
</body>
</html>