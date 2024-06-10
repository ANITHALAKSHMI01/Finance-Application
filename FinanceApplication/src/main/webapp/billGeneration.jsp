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
<style>
	h4
	{
		color:green;
	}
</style>
<body>
	<h4>Amount will be credited within 2 days</h4>
	<%
	List<AmountDetails> list = (ArrayList<AmountDetails>) request.getAttribute("list");
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
	<%} %>
</body>
</html>