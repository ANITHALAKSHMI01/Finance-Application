<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<h1>Admin Login</h1>
<form action="AdminServlet" method="post">
	<!-- <label for="adminId">Admin Id</label>
	<input id="adminId" type=""> -->
	<label for="email">Email</label>
	<input id="email" type="email" placeholder="Email Id" name="emailId" required><br><br>
	<label for="pass">Password</label>
	<input id="pass" type="password" placeholder="Password" name="password" pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@!#$%^&*]).{6}$" maxlength=6 required><br><br>
	<button>Login</button>
</form>
</body>
</html>