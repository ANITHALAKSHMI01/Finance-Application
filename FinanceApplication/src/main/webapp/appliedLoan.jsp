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
	top: 50px;
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
	 <th>Edit</th>
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
				<td><input type="hidden" name="id" value="<%= loan.getBorrowerId()%>">
				<a href="updateAppliedDetails.jsp?editId=<%=loan.getBorrowerId()%>"><button class="button">Update</button></a></td>
			
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
<a href="borrowerAfterLogin.jsp"><button>Back</button></a>
</body>
</html>