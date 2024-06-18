<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ApplicationServlet" method="post" enctype="multipart/form-data">
	 <!--    <label for="purpose">Purpose Of Loan</label>
		<textarea rows="5" cols="" id="purpose" name="purpose"></textarea><br><br> -->
		 <label for="sal">Salary</label>
        <input id="sal" type="number" name="salary" placeholder="Salary" required><br><br>
        <label for="loan">Loan Amount</label>
        <input id="loan" type="number" name="amount" placeholder="loan" required><br><br>
        <label for="repay">Tenure(In Months)</label>
        <input id="repay" type="number" name="repayment" placeholder="Repayment Period" required><br><br>
        <label for="city">City</label>
        <select name="city" id="city" required>
		<option>Tenkasi</option>
		<option>Tirunelveli</option>
		<option>Madurai</option>
		<option>Trichy</option>
		<option>Coimbatore</option>
		<option>Chennai</option>
	   </select><br><br>
        <label for="state">State</label>
        <input id="state" type="text" name="state" pattern="^[A-Za-z]*" required><br><br>
        <label for="pin">Pincode</label>
        <input id="pin" type="text" name="pincode" maxlength=6 placeholder="Pincode" pattern="^[1-9][0-9]{5}" required><br><br>
        <label for="accNo">Account No</label>
        <input id="accNo" type="text" maxlength=15 minlength=13 name="accountNo" placeholder="Account No" pattern="[1-9][0-9]{12,14}"><br><br>
        <label for="pan">PAN</label>
        <input id="pan" type="text" maxlength=10 name="pan" placeholder="PAN" pattern="[A-Z0-9]{10}"><br><br>
        <label for="pay">Pay Slip</label>
        <input id="pay" type="file" name="paySlip"><br><br> 
        <label for="proof">Proof</label>
        <input id="proof" type="file" name="proof"><br><br>
	   <input type="hidden" name="id" value="<%= request.getParameter("editId") %>">
	<input type="submit" class="button" name="update" value="Update">
</form>
<!-- <a href="borrowerAfterLogin.jsp"><button>Back</button></a> -->
</body>
</html>