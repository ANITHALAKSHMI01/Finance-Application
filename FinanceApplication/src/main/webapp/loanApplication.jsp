<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.dao.BorrowerImplementation" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application</title>
<style>
	.button
	{
		position:relative;
		left:190px;
		bottom:38px;
		background-color:gray;
		border-color:gray;
	}
    body
    {
  		background-color:skyblue;
    }
	h1
	{
		text-align:center;
		position:relative;
		top:50px;
	}
	div
	{
		border:2px solid white;
		box-shadow:1px 1px 1px 1px;
		background-color:white;
		width:fit-content;
		height:600px;
		padding:40px;
		position:relative;
		left:400px;
		top:50px;
		border-radius:10px;
	}
	label
	{
		font-size:20px;
	}
	#id
	{
		position:relative;
		left:39px;
	}
	#purpose
	{
		width:210px;
	}
/* 	#sal
	{
		position:relative;
		left:85px;
	} */
	#loan
	{
		position:relative;
		left:25px;
	}
	#city
	{
		width:215px;
		padding:8px;
		position:relative;
		left:100px;
	}
	input
	{
		height:20px;
		width:200px;
		padding:5px;
	}
	button
	{
		position:relative;
		left:60px;
		padding:6px;
		width:100px;
		font-size:18px;
		background-color:green;
		color:white;
		border-radius:10px;
		border-color:green;
	}
	#state
	{
		position:relative;
		left:95px;
	}
	#pin
	{
		position:relative;
		left:72px;
	}
	#accNo
	{
		position:relative;
		left:40px;
	}
	#pan
	{
		position:relative;
		left:100px;
	}
	#pay
	{
		position:relative;
		left:70px;
	}
	#proof
	{
		position:relative;
		left:90px;
		padding:5px;
	}
</style>
</head>
<body>
	 <%
	String email=null;
	String id=null;
	BorrowerImplementation borrower=new BorrowerImplementation();
	email=(String) session.getAttribute("emailId");
	try 
	{
		id=borrower.checkId(email);
	} catch (ClassNotFoundException | SQLException e) 
	{
		e.printStackTrace();
	}
	%> 
    <h1>Application Form</h1>
    <div>
    	<form action="BorrowerHomePage" method="post" enctype="multipart/form-data">
        <label for="id">Borrower Id</label>
        <input id="id" type="text" name="id" value="<%=id!=null ? id:"" %>" readonly><br><br> 
        <label for="sal">Salary(In Months)</label>
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
        <input id="accNo" type="text" maxlength=15 name="accountNo" placeholder="Account No" pattern="[1-9][0-9]{12,14}"><br><br>
        <label for="pan">PAN</label>
        <input id="pan" type="text" maxlength=10 name="pan" placeholder="PAN" pattern="[A-Z0-9]{10}"><br><br>
        <label for="pay">Pay Slip</label>
        <input id="pay" type="file" name="paySlip"><br><br>  
        <label for="proof">Proof</label>
        <input id="proof" type="file" name="proof"><br><br>
        <button>Apply</button>
    </form>
    <a href="borrowerAfterLogin.jsp"><button class="button">Back</button></a>
    </div>
</body>
</html>
