<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if(session.getAttribute("admin") == null){
    response.sendRedirect("adminLogin.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Account</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#f4f6f9;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
    margin:0;
}

.container{
    width:350px;
    background:white;
    padding:30px;
    border-radius:8px;
    box-shadow:0 5px 15px rgba(0,0,0,0.2);
}

h2{
    text-align:center;
    margin-bottom:20px;
}

.form-group{
    margin-bottom:15px;
}

.form-group label{
    font-weight:bold;
}

.form-group input{
    width:100%;
    padding:8px;
    margin-top:5px;
    border:1px solid #ccc;
    border-radius:4px;
}

.btn{
    width:100%;
    padding:10px;
    background:#c0392b;
    border:none;
    color:white;
    font-size:15px;
    border-radius:5px;
    cursor:pointer;
}

.btn:hover{
    background:#e74c3c;
}

.message{
    text-align:center;
    margin-bottom:10px;
}

.error{
    color:red;
}

.success{
    color:green;
}

.back{
    margin-top:15px;
    text-align:center;
}

.back a{
    text-decoration:none;
    color:#2a5298;
}

</style>

</head>
<body>

<div class="container">

<h2>Delete Account</h2>

<% if(request.getAttribute("error") != null){ %>
<div class="message error">
<%= request.getAttribute("error") %>
</div>
<% } %>

<% if(request.getAttribute("success") != null){ %>
<div class="message success">
<%= request.getAttribute("success") %>
</div>
<% } %>

<form action="deleteAccount" method="post">

<div class="form-group">
<label>Enter Account Number</label>
<input type="number" name="accountNumber" required>
</div>

<button class="btn" type="submit">Delete Account</button>

</form>

<div class="back">
<a href="adminDashboard.jsp">Back to Dashboard</a>
</div>

</div>

</body>
</html>