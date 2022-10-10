<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>User Account</title>
<link rel="stylesheet" href="stylesheet.css">
<style>
h1{
background-color: #f3812a;
}
*{
background-color: #ffccb3;
}
body{
background-color: #ffccb3;
}
.log{
position: relative;
	padding-left:640px;
	padding-top:50px;
}

.logout{
margin:70px 880px;
}
</style>
</head>
<body>
<% HttpSession http = request.getSession(); %>
<h1>Welcome, <%= http.getAttribute("fname") %></h1>
<div class="log">
    <a href="Deposit.html"> <input type="submit" value="Deposit"></a>
    <a href="Withdraw.html"><input type="submit" value="Withdraw"></a>
    <a href="Transfer.html"><input type="submit" value="Transfer"></a>
    <a href="BillPayments.html"><input type="submit" value="Payments"></a>
    <a href="Profile.jsp"><input type="submit" value="View Profile"></a><br>
    </div>
    <form action="Logout" method="get">
    <div class="logout">
    	<button type="submit" style = "font-size:15px;border-radius:25px" class="btn btn-lg btn-primary btn-block">Logout</button> 
       <!-- <input type="submit" style = "font-size:15px;border-radius:25px" class="btn btn-lg btn-primary btn-block" value="Logout"> -->
        </div>
        </form>
    

</body>
