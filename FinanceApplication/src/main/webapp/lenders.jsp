<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.model.LoanBorrowerDetails" %>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Lenders</title>
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
button
	{
		width:100px;
		padding:5px;
		position:relative;
		left:750px;
		top:70px;
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
	padding: 5px;
	text-align: center;
}
 table 
{
	position: relative;
	top: 150px;
} 
.button
{
	padding:8px;
	background-color:green;
	border-color:green;
	width:90px;
	color:white;
	font-size:15px;
}
#search
{
	position:relative;
	left:550px;
	top:120px; 
	padding:5px;
}
#approve
{
	padding:3px;
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
			<form action="SearchServlet" method="get">
	  			<select name="filter" id="approve">
				    	<option>Status</option> 
				      	<option>Approved</option>
				      	<option>On Progress</option>
		                <option>Rejected</option>
	                	<option>Not Approved</option>
	                 <input type="submit" name="filter" value="Filter" class="button1">
				      </select>
	 		</form>
	 		</aside>
			<aside>
				<a href="LogoutServlet" method="get"style="color: transparent;"><p style="color:white; font-size:22px;">Logout</p></a>
			</aside>
		</section>
	</nav>
	<form action="Borrower" method="post">
		<input type="text" placeholder="Search" id="search" name="search" maxlength=5 pattern="[a-z0-9]{5}">
	</form>
<table border="1px" cellspacing="0px">
	<thead>
		<tr>
	<th>Application Id</th>
	<th>Borrower Id</th>
	 <th>Salary</th>
	 <th>Loan Amount</th>
	 <th>Tenure</th>
	 <th>Account No</th>
	 <th>PAN</th>
	  <th>City</th>
	  <th>State</th>
	  <th>Pincode</th>
	  <th>Pay Slip</th>
	 <th>Proof</th>
	 <th>Status</th>
	  <form action="SearchServlet" method="get">
	  <select name="filter" id="approve">
				    	<option>Status</option> 
				      	<option>Approved</option>
				      	<option>On Progress</option>
		                <option>Rejected</option>
	                	<option>Not Approved</option>
				      </select>
	 <input type="submit" name="filter" value="Filter" class="button"">
</form>
	 </th> -->
	<th>Approval</th>
	<th>Generate Bill</th>
	   </tr>
	</thead>
	<tbody>
			<%
			List<LoanBorrowerDetails> list=(ArrayList<LoanBorrowerDetails>)request.getAttribute("list");
			 if (list != null && !list.isEmpty())
			  {
				  try
				  {
				  		for (LoanBorrowerDetails loan : list)
				  		{
					byte[] image = loan.getProof();
					String proof = Base64.getEncoder().encodeToString(image);
					byte[] image1=loan.getPaySlip();
					String paySlip = Base64.getEncoder().encodeToString(image1);
			%>
			<tr>
				<td><%=loan.getApplicationId()%></td>
				<td><%=loan.getBorrowerId()%></td>
				<td><%=loan.getSalary()%></td>
				<td><%=loan.getLoanAmount()%></td>
				<td><%=loan.getTenure() %></td>
				<td><%=loan.getAccountNo()%></td>
				<td><%=loan.getPan()%></td>
				<td><%=loan.getCity()%></td>
				<td><%=loan.getState()%></td>
				<td><%=loan.getPincode()%></td>
				<td><img src="data:image/jpeg;base64,<%=paySlip%>"
					alt="Pay Slip" style="width:200px; height:200px;"><br><br>
					<form action="AllowBorrower" method="post">
						<input type="hidden" name="viewId" value="<%= loan.getBorrowerId()%>">
				        <input type="submit" name="view" value="View" class="button">
					</form>
					</td>
				<td><img src="data:image/jpeg;base64,<%=proof%>"
					alt="Pay Slip" style="width:200px; height:200px;"><br><br>
					<form action="AdminLenders" method="post">
						<input type="hidden" name="viewId" value="<%= loan.getBorrowerId()%>">
				        <input type="submit" name="view" value="View" class="button">
					</form>
					</td>
					<td><%=loan.getStatus() %></td>
				<td>
					<form action="AdminHomeServlet" method="post">
						<input type="hidden" name="id" value="<%= loan.getApplicationId()%>">
				      	<select name="approval" id="approve">
				    	<option>Select</option> 
				      	<option>Approved</option>
				      	<option>On Progress</option>
		                <option>Rejected</option>
	                	<option>Not Approved</option>
				      </select>
				      <input type="submit" name="approve" value="Update" class="button" style="position:relative;top:20px;">
					</form>
				</td>
				<td>
					<form action="LogoutServlet"method="post">
					   	<input type="hidden" name="borrower" value="<%= loan.getBorrowerId()%>">
						<input type="hidden" name="id" value="<%= loan.getApplicationId()%>">
						<input type="hidden" name="amount" value="<%=loan.getLoanAmount()%>">
						<input type="hidden" name="tenure" value="<%=loan.getTenure()%>">
						<input type="submit" name="pay" value="Pay Now" class="button">
					</form>
				</td> 
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