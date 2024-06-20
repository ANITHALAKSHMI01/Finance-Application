<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.chainsys.model.AmountDetails" %>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Details</title>
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
	padding: 5px;
	text-align: center;
}
 table 
{
	position: relative;
	top: 150px;
	left:90px;
} 
</style>
<body>
<nav id="navbar">
		<section id="left_nav">
			<img src="ProofImages/flogo.jpg" alt="image" id="image1">
		</section>
		<section id="right_nav">
			<aside>
				<a href="AdminLenders" method="get"style="color: transparent;"><p style="color:white; font-size:22px;">Profile<p></a>
			</aside>
			<aside>
				<a href="AdminHomeServlet" method="get"style="color: transparent;"><p style="color:white; font-size:22px;">Registered Borrowers</p></a>
			</aside>
			<aside>
				<a href="LenderDetailServlet" method="get"style="color: transparent;"><p style="color:white; font-size:22px;">Lenders</p></a>
			</aside>
			<aside>
				<a href="Borrower" method="get"style="color: transparent;"><p style="color:white; font-size:22px;">Loan Details</p></a>
			</aside>
			<aside>
				<a href="LogoutServlet" method="get"style="color: transparent;"><p style="color:white; font-size:22px;">Logout</p></a>
			</aside>
		</section>
	</nav>
<table border="1px" cellspacing="0px">
	<thead>
		<tr>
	<th>Loan Id</th>
	<th>Borrower Id</th>
	<th>Loan Issued</th>
	<th>Interest(%)</th>
	<th>Tenure(In Months)</th>
	<th>Total Amount</th>
	<th>Distribusal Amount</th>
	<th>Interest Amount</th>
	 </tr>
	</thead>
	<tbody>
	<%
		List<AmountDetails> list=(ArrayList<AmountDetails>)request.getAttribute("list");
		if (list != null && !list.isEmpty())
		{
			 try
			 {
				 for (AmountDetails amount : list)
				 {		
			%>
	<tr>
		<td><%=amount.getLoanId() %></td>
		<td><%=amount.getBorrowerId() %></td>
		<td><%=amount.getDate() %></td>
		<td><%=amount.getInterest()%></td>
		<td><%=amount.getTenure()%></td>
		<td><%=amount.getDistribusalAmount()+amount.getReduction()%></td>
		<td><%=amount.getDistribusalAmount()%></td>
		<td><%=amount.getReduction() %></td>
	<%
			   }
				  		
				  }
				  catch (Exception e) 
				  { 
						e.printStackTrace();
				  }
			  } 
				else 
				{
	        %>
	        </tr>
	        <tr>
	            <td colspan="15">No Records found</td>
	        </tr>
	        <%
	        }
	        %>
	</tbody>
</table>
</body>
</html>