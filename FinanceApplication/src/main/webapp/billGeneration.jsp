<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.model.AmountDetails" %>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Generation</title>
</head>
<body>
	<%
	List<AmountDetails> list = (ArrayList<AmountDetails>) request.getAttribute("list");
	if (list != null && !list.isEmpty())
	  {
	for (AmountDetails amount : list) 
	{	
	%>
	Loan Id    :<%=amount.getLoanId() %><br>
	Borrower Id:<%=amount.getBorrowerId() %><br>
	Date       :<%=amount.getDate() %><br>
	Total Amount : <%=amount.getDistribusalAmount()+amount.getReduction() %><br>
	Interest:<%=amount.getInterest()%>%<br>
	 Tenure :<%=amount.getTenure() %>Months<br>
	Distribusal Amount:<%=amount.getDistribusalAmount()%>
	<form action="payBorrower.jsp">
		<input type="hidden" name="id" value="<%=amount.getBorrowerId() %>">
		<input type="hidden" name="loanId" value="<%=amount.getLoanId() %>">
		<input type="hidden" name="amount" value="<%=amount.getDistribusalAmount()%>">
		<button>Next</button>
	</form>
	<%} 
	
	 } 
		else 
				{
	        %>
	        <tr>
	            <td colspan="15">No Records found</td>
	        </tr>
	        <%
	        }
	        %>
</body>
</html>