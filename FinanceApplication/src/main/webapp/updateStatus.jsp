<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Loan Status</title>
</head>
<body>
<form action="LenderDetailServlet" method="post">
	<h2>Update Status</h2>
	<select name="status">
		<option>Approved</option>
		<option>On Progress</option>
		<option>Rejected</option>
		<option>Not Approved</option>
	</select>
	<input type="hidden" name="id" value="<%= request.getParameter("editId") %>">
	<input type="submit" class="button" name="update">
</form>
</body>
</html>