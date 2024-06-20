<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.model.User" %>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrower Profile</title>
</head>
<style>
*
{
    box-sizing: border-box;
    padding: 0;
    margin: 0;
}
#navbar
{
   border: 2px solid #00008B; 
   height: 75px;
   width: 100%;
   display: flex;
   box-shadow: 2px 2px 2px 2px rgba(0,0,0,0.2);
   position: fixed;
   top: 0;
   z-index: 1;
  background-color: #00008B;
} 
#left_nav
{
   width: 30%;
   height: 100%; 
}
#right_nav
{
    width: 70%;
    height: 100%;  
    display: flex;
    justify-content: flex-end; 
    align-items: center; 
    gap: 30px;
    margin-right:25px;
}
#image1
{
	border-radius:50%;
	width:55px;
	height:55px;
	position:relative;
	top:10px;
	left:10px;
}
	body
	{
		background-color:wheat;
	}
	div
	{
		border:2px solid whitesmoke;
		width:fit-content;
		height:340px;
		padding:30px;
		position:relative;
		left:450px;
		top:130px;
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
		background-color:green;
		color:white;
		border-color:green;
		font-size:20px;
	}
	.but1
	{
		position:relative;
		left:120px;
		bottom:35px;
	}
</style>
<body>
 <nav id="navbar">
		<section id="left_nav">
			<img src="ProofImages/flogo.jpg" alt="image" id="image1">
		</section>
		<section id="right_nav">
			<aside>
				<a href="BorrowerHomePage" method="get" style="color: transparent;"><p style="color:white; font-size:22px;">Profile<p></a>
			</aside>
			<aside>
				<a href="AllowBorrower" method="get"  style="color: transparent;"><p style="color:white; font-size:22px;">Apply</p></a>
			</aside>
			<aside>
				<a href="ApplicationServlet" method="get"  style="color: transparent;"><p style="color:white; font-size:22px;">Status</p></a>
			</aside>
			<aside>
				<a href="BillServlet" method="get"  style="color: transparent;"><p style="color:white; font-size:22px;">Invoice</p></a>
			</aside>
				<aside>
				<a href="borrowerEMI.jsp" style="color: transparent;"><p style="color:white; font-size:22px;">Pay EMI</p></a>
			</aside>
			<aside>
				<a href="LogoutServlet" method="get" style="color: transparent;"><p style="color:white; font-size:22px;">Logout</p></a>
			</aside>
		</section>
	</nav>
<div>
 <%
 List<User> list=(ArrayList<User>)request.getAttribute("list");
 	  for(User loan: list)
 	  {
 %>
	  <label>Borrower Id </label><p><%= loan.getId()%></p><br><br>
<label>Name     </label><p> <%= loan.getName()%></p><br><br>
<label>Date Of Birth  </label><p> <%= loan.getDateOfBirth() %></p><br><br>
<label>Phone Number</label> <p> <%= loan.getPhoneNo() %></p><br><br>
<label>Email Id  </label><p><%= loan.getEmail() %></p><br><br>
<label>Location  </label><p><%= loan.getLocation()%></p><br><br>
<form action="updateBorrower.jsp">
<input type="hidden" name="id" value="<%= loan.getId() %>">
<input type="hidden" name="name" value="<%= loan.getName() %>">
<input type="hidden" name="email" value="<%= loan.getEmail() %>">
<button>Edit</button>
</form>
<%
   }
 %>
<a href="borrowerAfterLogin.jsp"><button class="but1">Back</button></a>
</div>

</body>
</html>