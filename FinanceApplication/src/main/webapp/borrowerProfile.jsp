<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.model.LoanApp" %>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrower Profile</title>
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
<table border="2px">
	<thead>
		<tr>
	<th>Borrower Id</th>
	 <th>Name</th>
	 <th>Date Of Birth</th>
	 <th>Phone Number</th>
	 <th>Email Id</th>
	  <th>Location</th>
	<!--  <th>Delete</th> -->
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
	  <%--   <td>
               <form action="BorrowerUpdate" method="get">
                     <input type="hidden" name="deleteId" value="<%=loan.getId()%>">
                     <input type="submit" name="delete" value="Delete" class="button">
                </form>
          </td>  --%>
          <td>  <input type="hidden" name="id" value="<%= loan.getId() %>">
	          <a href="updateBorrower.jsp?editId=<%=loan.getId()%>"><button class="but1">Edit</button></a>
	     </td>
	  </tr>
	   <%
           }
           %>
	</tbody>
</table>
<a href="borrowerAfterLogin.jsp"><button>Back</button></a>
</body>
</html>