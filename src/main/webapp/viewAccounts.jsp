<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bank.model.Account" %>

<%
    List<Account> accounts =
        (List<Account>) request.getAttribute("accounts");
%>

<!DOCTYPE html>
<html>
<head>
<title>View Accounts</title>

<style>
table {
    width: 90%;
    margin: 40px auto;
    border-collapse: collapse;
}
th, td {
    padding: 17px;
    border: 2px solid #ccc;
    text-align: center;
}
th {
    background-color: #1e3c72;
    color: white;
}

/* Even rows */
tr:nth-child(even) {
    background-color: #f2f2f2;
}

/* Odd rows */
tr:nth-child(odd) {
    background-color: #ffffff;
}

/* Hover effect */
tr:hover {
    background-color: #d6e4ff;
}
</style>

</head>
<body>

<h2 style="text-align:center;">All Accounts</h2>

<table>
<tr>
	<th>ID</th>
    <th>Account No</th>
    <th>Name</th>
    <th>Email</th>
    <th>Balance</th>
</tr>

<%
    if (accounts != null) {
        for (Account acc : accounts) {
%>
<tr>
    <td><%= acc.getId() %></td>
    <td><%= acc.getAccountNumber() %></td>
    <td><%= acc.getName() %></td>
    <td><%= acc.getMail() %></td>
    <td><%= acc.getBalance() %></td>
</tr>
<%
        }
    }
%>

</table>

</body>
</html>