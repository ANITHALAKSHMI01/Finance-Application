<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.chainsys.model.User" %>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrower Details</title>
</head>
<style>
button
	{
		width:100px;
		padding:5px;
		position:relative;
		left:550px;
		top:30px;
		background-color:green;
		color:white;
		border-color:green;
		font-size:20px;
	}
h1 
{
	text-align:center;
	color:#AA336A;
}
th
{
	background-color:blue;
    color: white;
	opacity:0.7;
	font-size:20px;
}
td
{
	  color: grey;
	   font-size: 15px;
       font-family: Arial, Helvetica, sans-serif;
}
th, td
{
	padding: 15px;
	text-align: center;
}
table 
{
	position: relative;
	left: 130px;
	/* border-color:orange; */
}
#button
{
	padding:10px;
	background-color:red;
	border-color:red;
	width:80px;
	color:white;
	font-size:15px;
}
</style>
<body>
<h1>Registered Borrowers</h1>
 <table border="1px" cellspacing="0px">
	<thead>
		<tr>
	<th>Borrower Id</th>
	 <th>Name</th>
	 <th>Date Of Birth</th>
	 <th>Phone Number</th>
	 <th>Email Id</th>
	  <th>Location</th>
	 <th>Delete</th>
	<!--  <th>Update</th> -->
	   </tr>
	</thead>
	<tbody>
	  <%
	  List<User> list=(ArrayList<User>)request.getAttribute("list");
	  	  for(User loan: list)
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
               <form action="BorrowerUpdate" method="get">
                     <input type="hidden" name="deleteId" value="<%=loan.getId()%>">
                     <input type="submit" id="button" name="delete" value="Delete" class="button">
                </form>
          </td> 
          <%-- <td>  <input type="hidden" name="id" value="<%= loan.getId() %>">
	          <a href="updateBorrower.jsp?editId=<%=loan.getId()%>"><button class="but1">Edit</button></a>
	     </td> --%>
	  </tr>
	   <%
           }
           %>
	</tbody>
</table> 
<a href="adminAfterLogin.jsp"><button>Back</button></a>
</body>
</html>