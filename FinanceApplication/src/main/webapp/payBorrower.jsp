<%@page import="com.chainsys.dao.BorrowerSide"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pay For Borrower</title>
</head>
<body>
	<%
		String id=request.getParameter("id");
		String loanId=request.getParameter("loanId");
		String amount=request.getParameter("amount");
		int amount1=Integer.parseInt(amount);
		/* long adminAccount=675432189076543l; */
		long accountNo=BorrowerSide.getAccountNo(id); 
		LocalDate dateToday = LocalDate.now(); 
		String dateString =dateToday.toString();
	%>
	<label>Loan Id   - </label><p class="out"><%=loanId%></p><br>
	<label>Borrower Id -</label><p class="out"><%=id%></p><br>
	<label>Date    -  </label><p class="out"><%=dateString%></p><br>
	<label>Account No -  </label><p class="out"><%=accountNo%></p><br>
	<label> Amount -</label><p class="out"><%=amount1%></p><br>
	<form action="BillServlet" method="post">
     	<input type="hidden" name="id" value="<%=id%>">
		<input type="hidden" name="account" value="<%=accountNo%>">
		<input type="hidden" name="amount" value="<%=amount%>">
		<button>Pay</button>
	</form>
</body>
</html>