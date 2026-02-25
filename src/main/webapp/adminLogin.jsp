<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>

<style>
    * {
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        margin: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: url("assets/images/Admin-Login-BG-img.png") no-repeat center center/cover;
        position: relative;
    }

    body::before {
        content: "";
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.55);
        z-index: 0;
    }

    .login-container {
        position: relative;
        z-index: 1;
        background-color: white;
        padding: 40px 35px;
        width: 350px;
        border-radius: 10px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3);
    }

    .login-container h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .error-message {
        color: red;
        text-align: center;
        margin-bottom: 15px;
        font-size: 14px;
    }

    .form-group {
        margin-bottom: 18px;
    }

    .form-group label {
        display: block;
        margin-bottom: 6px;
        font-weight: bold;
        color: #555;
    }

    .form-group input {
        width: 100%;
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
        font-size: 14px;
    }

    .form-group input:focus {
        border-color: #2a5298;
        outline: none;
    }

    .login-btn {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 5px;
        background-color: #2a5298;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
        margin-top: 10px;
    }

    .login-btn:hover {
        background-color: #1e3c72;
    }

    .extra-links {
        margin-top: 15px;
        text-align: center;
        font-size: 14px;
    }

    .extra-links a {
        color: #2a5298;
        text-decoration: none;
        margin: 0 8px;
        transition: 0.3s;
    }

    .extra-links a:hover {
        text-decoration: underline;
        color: #1e3c72;
    }
</style>

</head>
<body>

<div class="login-container">
    <h2>Admin Login</h2>

    <% if(request.getAttribute("error") != null) { %>
        <div class="error-message">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>

    <form action="adminLogin" method="post">

        <div class="form-group">
            <label>Email</label>
            <input type="text" name="mail" required>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" required>
        </div>

        <button type="submit" class="login-btn">Login</button>
    </form>

    <div class="extra-links">
        <a href="adminRegister.jsp">Register</a> |
        <a href="forgotPassword.jsp">Forgot Password?</a>
    </div>

</div>

</body>
</html>