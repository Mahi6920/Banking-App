<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Registration</title>

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
        background: url("assets/images/Admin-Reg-img.png") no-repeat center center/cover;
        position: relative;
    }

    .register-container {
        background-color: white;
        padding: 40px 35px;
        width: 380px;
        border-radius: 10px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3);
    }

    .register-container h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #333;
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

    .register-btn {
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

    .register-btn:hover {
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
    }

    .extra-links a:hover {
        text-decoration: underline;
    }

    .error-message {
        color: red;
        text-align: center;
        margin-bottom: 10px;
    }

    .success-message {
        color: green;
        text-align: center;
        margin-bottom: 10px;
    }
</style>

</head>
<body>

<div class="register-container">
    <h2>Admin Registration</h2>

    <% if(request.getAttribute("error") != null) { %>
        <div class="error-message">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>

    <% if(request.getAttribute("success") != null) { %>
        <div class="success-message">
            <%= request.getAttribute("success") %>
        </div>
    <% } %>

    <form action="adminRegister" method="post">

        <div class="form-group">
            <label>Full Name</label>
            <input type="text" name="name" 
            value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>"
            required>
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="mail" 
            value="<%= request.getAttribute("mail") != null ? request.getAttribute("mail") : "" %>"
            required>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" required>
        </div>

        <div class="form-group">
            <label>Confirm Password</label>
            <input type="password" name="confirmPassword" required>
        </div>

        <button type="submit" class="register-btn">Register</button>

    </form>

    <div class="extra-links">
        <a href="adminLogin.jsp">Back to Login</a>
    </div>

</div>

</body>
</html>