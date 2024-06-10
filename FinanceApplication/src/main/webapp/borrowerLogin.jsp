<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrower Login</title>
</head>
<style>
    body
    {
  		background-color:skyblue;
  		overflow:hidden;
    }
	h1
	{
		text-align:center;
		position:relative;
		top:100px;
		left:20px;
	}
	div
	{
		border:2px solid white;
		box-shadow:1px 1px 1px 1px;
		background-color:white;
		width:fit-content;
		height:fit-content;
		padding:30px;
		position:relative;
		left:450px;
		top:120px;
		border-radius:10px;
	}
	label
	{
		font-size:25px;
	}
	#email
	{
		position:relative;
		left:40px;
	}
	#pass
	{
		position:relative;
		left:7px;
	}
	input
	{
		height:20px;
		width:200px;
		padding:5px;
	}
	button
	{
		position:relative;
		left:120px;
		padding:6px;
		width:100px;
		font-size:18px;
		background-color:green;
		color:white;
		border-radius:10px;
		border-color:green;
	}
</style>
<body>
<h1>Borrower Login</h1>
<div>
	<form action="BorrowerServlet" method="post">
	<label for="email">Email</label>
	<input id="email" type="email" placeholder="Email Id" name="emailId" required><br><br>
	<label for="pass">Password</label>
	<input id="pass" type="password" placeholder="Password" name="password" pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@!#$%^&*]).{6}$" maxlength=6 required><br><br>
	<!-- <a href="">Forget Password?</a><br><br> -->
	<button>Login</button>
</form>
</div>
</body>
</html>