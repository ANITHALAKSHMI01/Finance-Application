package com.chainsys.servlet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.chainsys.dao.BorrowerImplementation;
import com.chainsys.dao.BorrowerSide;
import com.chainsys.model.LoanBorrowerDetails;
import com.chainsys.model.User;
@MultipartConfig
@WebServlet("/BorrowerHomePage")
public class BorrowerHomePage extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public BorrowerHomePage()
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<User> list=null;
		String email=null;
		BorrowerImplementation borrower=new BorrowerImplementation();
		HttpSession session=request.getSession();
		email=(String) session.getAttribute("emailId");
		try 
		{
			list=borrower.selectUser(email);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("borrowerProfile.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BorrowerImplementation borrower=new BorrowerImplementation();
		int row=0;
		LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
		
		response.setContentType("multipart/form-data");
		String borrowerId=request.getParameter("id");
		String salary=request.getParameter("salary");
		String loanAmount=request.getParameter("amount");
		String tenure=request.getParameter("repayment");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pincode=request.getParameter("pincode");
		String accountNo=request.getParameter("accountNo");
		String pan1=request.getParameter("pan");
		int amount=Integer.parseInt(loanAmount);
		int period=Integer.parseInt(tenure);
		int pincode1=Integer.parseInt(pincode);
		int salary1=Integer.parseInt(salary);
		long accountNumber1=Long.parseLong(accountNo);
		String status="Not Approved";
		
		loanBorrower.setBorrowerId(borrowerId);
		loanBorrower.setSalary(salary1);
		loanBorrower.setLoanAmount(amount);
		loanBorrower.setTenure(period);
		loanBorrower.setCity(city);
		loanBorrower.setState(state);
		loanBorrower.setPincode(pincode1);
		loanBorrower.setAccountNo(accountNumber1);
		loanBorrower.setPan(pan1);
		loanBorrower.setStatus(status);
	
		
		Part part=request.getPart("paySlip");
		String fileName=part.getSubmittedFileName();
		String path="C:/Users/Anit3573/git/finance/FinanceApplication/src/main/webapp/PaySlip/"  +fileName;
		InputStream input=part.getInputStream();
		try
		{
		    byte[] file=input.readAllBytes();
			FileOutputStream fileOut=new FileOutputStream(path);
			fileOut.write(file);
			loanBorrower.setPaySlip(file);
			fileOut.flush();
			fileOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Part part1=request.getPart("proof");
		String fileName1=part.getSubmittedFileName();
		String path1="C:/Users/Anit3573/git/finance/FinanceApplication/src/main/webapp/ProofImages/"  +fileName1;
		InputStream input1=part1.getInputStream();
		try
		{
			byte[] file1=input1.readAllBytes();
			FileOutputStream fileOut1=new FileOutputStream(path1);
			fileOut1.write(file1);
			loanBorrower.setProof(file1);
			fileOut1.flush();
			fileOut1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
			int balance=1000;
			try 
			{
				BorrowerSide.addAccount(accountNumber1,balance,borrowerId);
				row=borrower.addLender(loanBorrower);
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			if(row>0)
			{
				try 
				{
					BorrowerSide.updateActive(borrowerId);
				} 
				catch (ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				response.sendRedirect("applicationFinish.jsp");
			}
			else
			{
				response.sendRedirect("loanApplication.jsp");
			}
		}	
}
