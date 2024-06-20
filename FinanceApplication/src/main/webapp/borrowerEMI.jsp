<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.chainsys.dao.BorrowerSide"%>
     <%@ page import="com.chainsys.dao.BorrowerImplementation" %>
     <%@ page import="com.chainsys.model.AmountDetails" %>
    <%@ page import="java.util.List" %>
     <%@ page import="java.util.ArrayList" %>
     <%@ page import="java.time.LocalDate" %>
      <%@ page import="java.text.SimpleDateFormat" %>
       <%@ page import="java.util.Date" %>
        <%@ page import="java.util.Calendar" %>
     <%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMI Payment</title>
</head>
<style>
	p
	{
		display:inline;
	}
</style>
<body>
<%
	List<AmountDetails> list=null;
    	 int loanAmount=0;
    	 int emi=0;
    	String id=null;
    	String date=null;
    	int tenure=0;
    	BorrowerImplementation borrower=new BorrowerImplementation();
		String email=(String) session.getAttribute("emailId");
		try 
		{
			id=borrower.checkId(email);
			list=borrower.viewApprovedBill(id);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		 if (list != null && !list.isEmpty())
		 {
			 for (AmountDetails amount : list)
			 {	
				 loanAmount=amount.getDistribusalAmount()+amount.getReduction();
				 tenure=amount.getTenure();
				 date=amount.getDate();
			 }
			 
			 Calendar calendar = Calendar.getInstance();  
			 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			 Date dueDate = formatter.parse(date);
			 calendar.get(Calendar.DAY_OF_MONTH);
			 
			long accountNo=BorrowerSide.getAccountNo(id); 
			LocalDate dateToday = LocalDate.now(); 
			try
			{
				 emi= loanAmount/tenure;
			}
		   	catch(ArithmeticException a1)
			{
		   		a1.printStackTrace();
			}
	 %>
	 <label for="id">Borrower Id : </label>
	<p class="out"><%=id%></p><br>
	 <label>Date    :  </label><p class="out"><%=dateToday%></p><br>
	 <label>Account No :  </label><p class="out"><%=accountNo%></p><br>
	 <label>Receiver Account No : </label><p class="out">675432189076543</p><br>
	 <label>Amount : </label><p class="out"><%=emi%></p><br>
	 <form action="EMIPayment" method="get">
	     	<input type="hidden" name="id" value="<%=id%>">
			<input type="hidden" name="account" value="<%=accountNo%>">
			<input type="hidden" name="amount" value="<%=emi%>">
			<button>Pay</button>
		</form>
		<%
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