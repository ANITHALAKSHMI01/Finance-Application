<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.model.LoanApp" %>
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
		height:fit-content;
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
</style>
<body>
<%-- <table border="2px">
	<thead>
		<tr>
	<th>Admin Id</th>
	 <th>Name</th>
	 <th>Date Of Birth</th>
	 <th>Phone Number</th>
	 <th>Email Id</th>
	  <th>Location</th>
	 <!-- <th>Delete</th> -->
	 <th>Update</th>
	   </tr>
	</thead>
	<tbody>
	  <%List<LoanApp> list=(ArrayList<LoanApp>)request.getAttribute("list");
	  for(LoanApp loan: list)
	  {
	  %>
	  <tr>
	  <td> <%=loan.getId()%></td>
	   <td><%=loan.getName()%></td>
	   <td><%=loan.getDateOfBirth() %></td>
	   <td><%=loan.getPhoneNo() %></td>
	   <td><%=loan.getEmail() %></td>
	   <td><%=loan.getLocation()%></td>
	    <td>
               <form action="AdminUpdate" method="get">
                     <input type="hidden" name="deleteId" value="<%=loan.getId()%>">
                     <input type="submit" name="delete" value="Delete" class="button">
                </form>
          </td> 
          <td>  <input type="hidden" name="id" value="<%= loan.getId() %>">
	          <a href="updateAdmin.jsp?editId=<%=loan.getId()%>"><button class="but1">Update</button></a>
	     </td>
	  </tr>
	   <%
           }
           %>
	</tbody>
</table> --%>
<div>
 <%List<LoanApp> list=(ArrayList<LoanApp>)request.getAttribute("list");
	  for(LoanApp loan: list)
	  {
	  %>
	  <label>Admin Id </label><p><%= loan.getId()%></p><br><br>
<label>Name     </label><p> <%= loan.getName()%></p><br><br>
<label>Date Of Birth  </label><p> <%= loan.getDateOfBirth() %></p><br><br>
<label>Phone Number</label> <p> <%= loan.getPhoneNo() %></p><br><br>
<label>Email Id  </label><p><%= loan.getEmail() %></p><br><br>
<label>Location  </label><p><%= loan.getLocation()%></p><br><br>
<input type="hidden" name="id" value="<%= loan.getId() %>">
	          <a href="updateAdmin.jsp?editId=<%=loan.getId()%>"><button>Update</button></a>
<%
           }
           %>
<a href="adminAfterLogin.jsp"><button>Back</button></a>
</div>
</body>
</html>