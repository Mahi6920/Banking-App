<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<style type="text/css">
	.login {
		margin: 10px;
		padding: 10px;
		border: 2px solid red;
		border-radius: 5px;
	}
</style>
</head>
<body>
	<form class="login" action="login" method="post">
		<p>Enter Your E-mail: </p>
		<input type="text" name="mail">
		<br>
		<p>Enter Your Password:</p>
		<input type="password" name="password">
		<br><br>
		<input type="Submit">
	</form>
</body>
</html>