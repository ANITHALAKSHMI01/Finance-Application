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
	<form action="BillServlet" method="post">
		<input type="hidden" name="id" value="<%=amount.getBorrowerId() %>">
		<button>Send</button>
	</form>
	<%} %>
</body>
</html>