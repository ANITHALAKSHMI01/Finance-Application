<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.model.User" %>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Details</title>
</head>
<style>
body
	{
		background-color:wheat;
	}
	div
	{
		border:2px solid whitesmoke;
		width:fit-content;
		height:290px;
		padding:30px;
		position:relative;
		left:450px;
		top:120px;
		background-color:whitesmoke;
		box-shadow:1px 1px 1px 1px rgba(0,0,0,0.2);
	}
	label
	{
		font-size:20px;
		color:grey;
	}
	p
	{
		display:inline;
		font-size:20px;
		color:blue;
		position:relative;
		left:20px;
	}
	button
	{
		width:100px;
		padding:5px;
		position:relative;
		left:20px;
		background-color:green;
		color:white;
		border-color:green;
		font-size:20px;
	}
	.but1
	{
		position:relative;
		left:140px;
		bottom:38px;
	}
</style>
<body>
<div>
 <%
 List<User> list=(ArrayList<User>)request.getAttribute("list");
 	  for(User loan: list)
 	  {
 %>
	  <label>Admin Id </label><p><%= loan.getId()%></p><br><br>
<label>Name     </label><p> <%= loan.getName()%></p><br><br>
<label>Date Of Birth  </label><p> <%= loan.getDateOfBirth() %></p><br><br>
<label>Phone Number</label> <p> <%= loan.getPhoneNo() %></p><br><br>
<label>Email Id  </label><p><%= loan.getEmail() %></p><br><br>
<label>Location  </label><p><%= loan.getLocation()%></p><br><br>
<form action="updateAdmin.jsp">
<input type="hidden" name="id" value="<%= loan.getId() %>">
<input type="hidden" name="name" value="<%= loan.getName() %>">
<input type="hidden" name="email" value="<%= loan.getEmail() %>">
<button>Edit</button>
</form>
<%-- <input type="hidden" name="id" value="<%= loan.getId() %>">
	          <a href="updateAdmin.jsp?editId=<%=loan.getId()%>"><button>Update</button></a> --%>
<%
           }
           %>
<a href="adminAfterLogin.jsp"><button class="but1">Back</button></a>
</div>
</body>
</html>