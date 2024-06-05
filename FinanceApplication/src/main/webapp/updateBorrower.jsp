<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Borrower Details</title>
</head>
<body>
<form action="BorrowerUpdate" method="post">
   <label for="name">Name</label>
   <input id="name" type="text" name="name" placeholder="Name" pattern="^[A-Za-z]*" required><br><br>
   <label for="phone">Phone Number</label>
	<input id="phone" type="tel" name="phoneNo" placeholder="Phone Number" maxlength=10 pattern="[6789][0-9]{9}" required><br><br>
    <label for="email">Email</label>
	<input id="email" type="email" placeholder="Email Id" name="emailId" required><br><br>
	<label for="loc">Location</label>
	<label for="loc">Location</label>
	<select name="location" required>
		<option>Tenkasi</option>
		<option>Tirunelveli</option>
		<option>Madurai</option>
		<option>Trichy</option>
		<option>Madurai</option>
		<option>Coimbatore</option>
		<option>Chennai</option>
	</select><br><br> 
	<input type="hidden" name="id" value="<%= request.getParameter("editId") %>">
	<input type="submit" class="button" name="update">
</form>
</body>
</html>