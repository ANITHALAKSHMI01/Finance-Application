<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
   border: 2px solid; 
   height: 75px;
   width: 100%;
   display: flex;
   box-shadow: 1px 1px 1px 1px;
   position: fixed;
   top: 0;
   z-index: 1;
  /*  background-color: #00008B; */
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
</style>
<body>
 <nav id="navbar">
		<section id="left_nav">
			<img src="" alt="image" id="image1">
		</section>
		<section id="right_nav">
			<aside>
				<a href="BorrowerHomePage" method="get">Profile</a>
			</aside>
			<aside>
				<a href="loanApplication.jsp">Apply</a>
			</aside>
			<aside>
				<a href="ApplicationServlet" method="get" >Status</a>
			</aside>
			<aside>
				<a href="BillServlet" method="get" >View Bill</a>
			</aside>
			<!-- <aside>
				<a href="" >History</a>
			</aside> -->
			<aside>
				<a href="LogoutServlet" method="get">Logout</a>
			</aside>
		</section>
	</nav>
</body>
</html>