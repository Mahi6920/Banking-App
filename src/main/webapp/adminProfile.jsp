<%@ page import="com.bank.model.Admin" %>
<%@ page import="java.util.List" %>
<%
	List<Admin> admin =
		(List<Admin>) request.getAttribute("admin");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Profile</title>
<style>
body {
    font-family: Arial, sans-serif;
    background: #f4f6f9;
}
.profile-container {
    max-width: 450px;
    margin: 60px auto;
    background: white;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 5px 15px rgba(0,0,0,0.1);
}
h2 {
    text-align: center;
    margin-bottom: 25px;
}
.field {
    margin-bottom: 18px;
}
.label {
    font-weight: bold;
    color: #333;
}
.value {
    margin-top: 4px;
    padding: 8px;
    background: #eef2f7;
    border-radius: 4px;
    font-size: 15px;
}
</style>
</head>
<body>

<div class="profile-container">
    <h2>Admin Profile</h2>
    
<%
	if (admin != null) {
        for (Admin ad : admin) {
%>

    <div class="field">
        <div class="label">Admin ID:</div>
        <div class="value"><%= ad.getId() %></div>
    </div>

    <div class="field">
        <div class="label">Name:</div>
        <div class="value"><%= ad.getName() %></div>
    </div>

    <div class="field">
        <div class="label">Email:</div>
        <div class="value"><%= ad.getMail() %></div>
    </div>
    
<%
        }
    }
%>
    
</div>
</body>
</html>