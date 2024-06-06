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
<title>Lenders</title>
</head>
<body>
<table border="2px">
	<thead>
		<tr>
	<th>Application Id</th>
	<th>Borrower Id</th>
	 <th>Purpose</th>
	 <th>Salary</th>
	 <th>Account No</th>
	 <th>Pan No</th>
	  <th>City</th>
	  <th>State</th>
	  <th>Pincode</th>
	 <th>Proof</th>
	 <th>Status</th>
	   </tr>
	</thead>
	<tbody>
			<%
			List<LoanBorrowerDetails> list=(ArrayList<LoanBorrowerDetails>)request.getAttribute("list");
				  try
				  {
				  		for (LoanBorrowerDetails loan : list)
				  		{
					byte[] image = loan.getProof();
					String base64Image = Base64.getEncoder().encodeToString(image);
			%>
			<tr>
				<td><%=loan.getApplicationId()%></td>
				<td><%=loan.getBorrowerId()%></td>
				<td><%=loan.getPurposeOfLoan()%></td>
				<td><%=loan.getSalary()%></td>
				<td><%=loan.getAccountNo()%></td>
				<td><%=loan.getPanNo()%></td>
				<td><%=loan.getCity()%></td>
				<td><%=loan.getState()%></td>
				<td><%=loan.getPincode()%></td>
				<td><img src="data:image/jpeg;base64,<%=base64Image%>"
					alt="Proof" style="width:200px; height:200px;"></td>
			
				<td><%=loan.getStatus()%><br><br>
				<input type="hidden" name="id" value="<%= loan.getBorrowerId()%>">
				<a href="updateStatus.jsp?editId=<%=loan.getBorrowerId()%>"><button class="but1">Update</button></a>
				</td>
			<%
			   }
				  		
				  }
				  catch (Exception e) 
				  { 
						e.printStackTrace();
				   }
				  
			%>
		</tbody>
</table>
<a href="adminAfterLogin.jsp"><button>Back</button></a>
</body>
</html>