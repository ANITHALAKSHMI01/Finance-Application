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
<title>Insert title here</title>
</head>
<body>
<table border="2px">
	<thead>
		<tr>
		<th>Proof</th>
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
					String proof = Base64.getEncoder().encodeToString(image);
			%>
			<tr>
	               <td><img src="data:image/jpeg;base64,<%=proof%>"
					alt="Proof"></td>
					<%
			   }
				  		
				  }
				  catch (Exception e) 
				  { 
						e.printStackTrace();
				   }
				  
			%>
			 </tr>
		</tbody>
</table>
<!-- <a href="adminAfterLogin.jsp"><button>Back</button></a> -->
<a href="LenderDetailServlet" method="get"><button>Back</button></a>
</body>
</html>