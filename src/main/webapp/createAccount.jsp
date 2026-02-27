<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>

<style>
    * {
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        margin: 0;
        background-color: #f4f6f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: white;
        width: 420px;
        padding: 35px;
        border-radius: 10px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.15);
    }

    h2 {
        text-align: center;
        margin-bottom: 25px;
    }

    .form-group {
        margin-bottom: 18px;
    }

    .form-group label {
        display: block;
        margin-bottom: 6px;
        font-weight: bold;
    }

    .form-group input, 
    .form-group select {
        width: 100%;
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }

    .form-group input:focus,
    .form-group select:focus {
        border-color: #1e3c72;
        outline: none;
    }

    .btn {
        width: 100%;
        padding: 12px;
        background-color: #1e3c72;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 10px;
    }

    .btn:hover {
        background-color: #16315e;
    }

    .message {
        text-align: center;
        margin-bottom: 15px;
        font-size: 14px;
    }

    .error {
        color: red;
    }

    .success {
        color: green;
    }

    .back-link {
        text-align: center;
        margin-top: 15px;
    }

    .back-link a {
        text-decoration: none;
        color: #1e3c72;
    }
</style>

</head>
<body>

<div class="container">

    <h2>Create User Account</h2>

    <% if (request.getAttribute("error") != null) { %>
        <div class="message error">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>

    <% if (request.getAttribute("success") != null) { %>
        <div class="message success">
            <%= request.getAttribute("success") %>
        </div>
    <% } %>

    <form action="createAccount" method="post">

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
            <label>Initial Deposit</label>
            <input type="number" name="balance"
                value="<%= request.getAttribute("balance") != null ? request.getAttribute("balance") : "" %>"
                required>
        </div>

        <div class="form-group">
            <label>Account Type</label>
            <select name="accountType" required>
                <option value="">Select Type</option>
                <option value="Savings">Savings</option>
                <option value="Current">Current</option>
            </select>
        </div>

        <button type="submit" class="btn">Create Account</button>

    </form>

    <div class="back-link">
        <a href="adminDashboard.jsp">Back to Dashboard</a>
    </div>
    <br>
    
     <% if (request.getAttribute("accountNumber") != null) { %>
        <div class="message success">
            <%= request.getAttribute("accountNumber") %>
        </div>
    <% } %>

</div>

</body>
</html>