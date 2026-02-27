<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<style>
    * {
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        margin: 0;
        background-color: #f4f6f9;
    }

    .navbar {
        background-color: #1e3c72;
        color: white;
        padding: 15px 30px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .navbar h2 {
        margin: 0;
    }

    .logout-btn {
        background-color: #ff4d4d;
        border: none;
        padding: 8px 15px;
        color: white;
        border-radius: 4px;
        cursor: pointer;
    }

    .logout-btn:hover {
        background-color: #cc0000;
    }

    .dashboard-container {
        padding: 40px;
        display: flex;
        justify-content: center;
    }

    .card-container {
        display: grid;
        grid-template-columns: repeat(2, 220px);
        gap: 25px;
    }

    .card {
        background-color: white;
        padding: 30px;
        text-align: center;
        border-radius: 8px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        cursor: pointer;
        transition: 0.3s;
    }

    .card:hover {
        transform: translateY(-5px);
        background-color: #1e3c72;
        color: white;
    }

    .card a {
        text-decoration: none;
        color: inherit;
        font-weight: bold;
        font-size: 16px;
    }
</style>

</head>
<body>

<div class="navbar">
    <h2>Admin Dashboard</h2>
    <form action="logout" method="post">
        <button type="submit" class="logout-btn">Logout</button>
    </form>
</div>

<div class="dashboard-container">
    <div class="card-container">

        <div class="card">
            <a href="createAccount.jsp">Create Account</a>
        </div>

        <div class="card">
            <a href="deleteAccount.jsp">Delete Account</a>
        </div>

        <div class="card">
            <a href="viewUsers">View Users</a>
        </div>

        <div class="card">
            <a href="adminProfile.jsp">Admin Profile</a>
        </div>

    </div>
</div>

</body>
</html>