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
<title>Lender Loan Profile</title>
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
button
	{
		width:100px;
		padding:5px;
		position:relative;
		left:560px;
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
	padding: 10px;
	text-align: center;
}
 table 
{
	position: relative;
	top: 150px;
	left:5px; 
} 
.button
{
	width:100px;
		padding:5px;
		position:relative;
		left:1px; 
		top:10px;
		background-color:green;
		color:white;
		border-color:green;
		font-size:20px;
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
	<table border="2px" cellspacing="0px">
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
	 <th>status</th>
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
					</td>
				<td><img src="data:image/jpeg;base64,<%=proof%>"
					alt="Proof" style="width:200px; height:200px;"><br><br>
					</td>
					<td><%=loan.getStatus() %></td>
				<%-- <td><input type="hidden" name="id" value="<%= loan.getBorrowerId()%>">
				<a href="updateAppliedDetails.jsp?editId=<%=loan.getBorrowerId()%>"><button class="button">Update</button></a></td> --%>
			
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
            <td colspan="14">No Records found</td>
        </tr>
        <%
        }
        %>
				 
		</tbody>
</table>
</body>
</html>