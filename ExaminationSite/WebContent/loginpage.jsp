<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>

        body {
            background-image: url('https://media.istockphoto.com/id/1460738579/photo/businessman-tick-mark-an-assessment-questionnaire-evaluation-online-survey-online-exam.webp?b=1&s=170667a&w=0&k=20&c=YEV4feDCfVRM94oJScgBJyJYfcfECh73uXqUTQPzw9c=');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: 100% 100%;
            color: white;
            margin: 200px;
            text-align: center;
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
    <script src="js/login.js"></script>

</head>
<body>
    <h1>EXAM LOGIN</h1>
    <form>
        <div align="center">
            <table>
                <tr>
                    <td>Username :</td>
                    <td><input type="text" id="username" placeholder="Enter your username" required></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><input type="password" id="password" placeholder="Enter your password" required></td>
                </tr>
            </table>
            <br>
            <div>
                <input type="submit" value="Login">
            </div>
            <br>
            <a href="resetpage.jsp" style="color: white;">forgot password?</a>
        </div>
    </form>
    
    <div class="popup">
        <div class="popup-content">
            <h2>Invalid Username or Password</h2>
            <p>Please check your login credentials and try again.</p>
            <button onclick="$('.popup').hide()">Close</button>
        </div>
    </div>
</body>
</html>

