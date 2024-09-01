<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <style>
       body {
             background-image: url('https://c0.wallpaperflare.com/preview/700/360/51/bible-wallpaper-devotional-bible-study.jpg');
             background-attachment: fixed;  
             background-size:100% 100%;
             margin-top: 200px;
             color:white
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
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/register.js"></script>
</head>
<body>
<div align="center">
    <h2>REGISTER</h2>
    <form action="register" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" id="username" placeholder="Enter a username" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" id="email" placeholder="Enter your email" required></td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><input type="text" name="dob" id="dob" placeholder="Enter your DoB" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" id="password" placeholder="Enter a password" required></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><input type="password" name="conpass" id="conpass" placeholder="Re-enter your password" required></td>
            </tr>
        </table>
        
        <br>
        
        <input type="submit" value="Register">
        
        <br>
        
        <a href="loginpage.jsp" style="color:white">Login instead</a>
    </form>
    
    <div class="popup">
        <div class="popup-content">
            <h2>Successfully registered !!!</h2>
            <a href="loginpage.jsp"><button onclick="$('.popup').hide()">OK</button></a>
        </div>
    </div>
   
    </div>
</body>
</html>

