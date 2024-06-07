<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrower Register Form</title>
</head>
<body>
<h1>Borrower Registration</h1>
<form action="BorrowerServlet" method="get">
	<label for="name">Name</label>
	<input id="name" type="text" name="name" placeholder="Name" pattern="^[A-Za-z]*" required><br><br>
	<label for="dob">D.O.B</label>
	<input id="dob" type="date" name="dateOfBirth" max="2003-01-01" min="1967-01-01"><br><br>
	<label for="phone">Phone Number</label>
	<input id="phone" type="tel" name="phoneNo" placeholder="Phone Number" maxlength=10 pattern="[6789][0-9]{9}" required><br><br>
	<label for="email">Email</label>
	<input id="email" type="email" placeholder="Email Id" name="emailId" required><br><br>
	<label for="pass">Password</label>
	<input id="pass" type="password" placeholder="Password" name="password" pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@!#$%^&*]).{6}$" maxlength=6 required><br><br>
	<label for="loc">Location</label>
	<select name="location" required>
		<option>Tenkasi</option>
		<option>Tirunelveli</option>
		<option>Madurai</option>
		<option>Trichy</option>
		<option>Coimbatore</option>
		<option>Chennai</option>
	</select><br><br> 
	<!-- <input id="loc" type="text" placeholder="Location" name="location" pattern="^[A-Za-z]*" required><br><br> -->
	<button>Register</button>
</form>
</body>
</html>