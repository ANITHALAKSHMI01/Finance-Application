<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application</title>
<script>
    function checkLoanEligibility()
    {
        var salary = document.getElementById("sal").value;
        var loan = document.getElementById("loan");
        var maxLoan = salary * 10;
        loan.setAttribute("max", maxLoan); 
        if (parseFloat(loan.value) > maxLoan) 
        {
            alert("You are eligible for a loan amount up to " + maxLoan + ".");
		     loan.value = maxLoan; 
        }
    }
</script>
</head>
<body>
    <h1>Application Form</h1>
    <form action="BorrowerHomePage" method="post" enctype="multipart/form-data">
        <label for="id">Borrower Id</label>
        <input id="id" type="text" name="id" placeholder="Borrower Id" pattern="^[A-Za-z0-9]*" required><br><br>
        <label for="purpose">Purpose Of Loan</label>
        <textarea rows="5" cols="" id="purpose" name="purpose"></textarea><br><br>
        <label for="sal">Salary</label>
        <input id="sal" type="number" name="salary" placeholder="Salary" required oninput="checkLoanEligibility()"><br><br>
        <label for="loan">Loan Amount</label>
        <input id="loan" type="number" name="amount" placeholder="loan" required><br><br>
        <label for="city">City</label>
        <select name="city" required>
		<option>Tenkasi</option>
		<option>Tirunelveli</option>
		<option>Madurai</option>
		<option>Trichy</option>
		<option>Coimbatore</option>
		<option>Chennai</option>
	   </select><br><br>
      <!--   <input id="city" type="text" name="city" pattern="^[A-Za-z]*" required><br><br> -->
        <label for="state">State</label>
        <input id="state" type="text" name="state" pattern="^[A-Za-z]*" required><br><br>
        <label for="pin">Pincode</label>
        <input id="pin" type="number" name="pincode" placeholder="Pincode" required><br><br>
        <label for="accNo">Account No</label>
        <input id="accNo" type="text" maxlength=15 minlength=13 name="accountNo" placeholder="Account No" pattern="[1-9][0-9]{12,14}"><br><br>
        <label for="pan">Pan No</label>
        <input id="pan" type="text" maxlength=10 name="panNo" placeholder="Pan No" pattern="[A-Z0-9]{10}"><br><br>
         <!-- <label for="pay">Pay Slip</label>
        <input id="pay" type="file" name="paySlip"><br><br> -->
        <label for="proof">Proof</label>
        <input id="proof" type="file" name="proof"><br><br>
        <button>Apply</button>
    </form>
    <a href="borrowerAfterLogin.jsp"><button>Back</button></a>
</body>
</html>
