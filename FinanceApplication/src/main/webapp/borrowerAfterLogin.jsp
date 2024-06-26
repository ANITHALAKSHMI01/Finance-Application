<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.SQLException" %>
        <%@ page import="com.chainsys.dao.BorrowerSide" %>
        <%@ page import="com.chainsys.dao.BorrowerImplementation" %>
        <%@ page import=" javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Borrower Home Page</title>
</head>
<style>
*
{
    box-sizing: border-box;
    padding: 0;
    margin: 0;
}
 body
{
overflow-x:hidden;
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
}
#image
{
position:relative;
	left:180px;
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
#detail
{
	position:relative;
	top:150px;
	left:250px;
}
h1
{
	font-size:40px;
	color:orangered;
}
.para
{
	font-size:25px;
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
	<div id="detail">
	<h1>Get Amount Online with Royal Finance</h1><br>
	<p class="para">Register and submit documents online. Interest rates 10%. Quick Registration.</p>
	<p class="para">
Avail amount ranging from Rs.10,000, not on a long term or short term but <br> on your own terms. 
Experience a completely online and paperless process.</p>
<img src="ProofImages/lending.jpg" alt="image" id="image" style="width:430px;height:330px;">	
	</div>
	
</body>
</html>