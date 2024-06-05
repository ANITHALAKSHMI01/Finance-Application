<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Admin Details</title>
</head>
<body>
<form action="AdminUpdate" method="post">
   <label for="name">Name</label>
   <input id="name" type="text" name="name" placeholder="Name" pattern="^[A-Za-z]*" required><br><br>
   <label for="phone">Phone Number</label>
	<input id="phone" type="tel" name="phoneNo" placeholder="Phone Number" maxlength=10 pattern="[6789][0-9]{9}" required><br><br>
    <label for="email">Email</label>
	<input id="email" type="email" placeholder="Email Id" name="emailId" required><br><br>
	<label for="loc">Location</label>
	<input id="loc" type="text" placeholder="Location" name="location" pattern="^[A-Za-z]*" required><br><br>
	<input type="hidden" name="id" value="<%= request.getParameter("editId") %>">
	<input type="submit" class="button" name="update">
</form>
</body>
</html>