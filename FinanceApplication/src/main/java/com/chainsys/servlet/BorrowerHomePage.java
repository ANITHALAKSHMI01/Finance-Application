package com.chainsys.servlet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import com.chainsys.dao.BorrowerImplementation;
import com.chainsys.dao.BorrowerSide;
import com.chainsys.model.LoanBorrowerDetails;
@MultipartConfig
@WebServlet("/BorrowerHomePage")
public class BorrowerHomePage extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static List list;
	public static BorrowerImplementation borrower=new BorrowerImplementation();
	public static LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
	public static String email,id;
	public static int row,maxLoan;
    public BorrowerHomePage()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		email=(String) session.getAttribute("emailId");
		System.out.println(email);
		try 
		{
			list=borrower.selectUser(email);
			System.out.println(list);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("borrowerProfile.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		byte[] file=null;
		byte[] paySlip=null;
		response.setContentType("multipart/form-data");
		PrintWriter out=response.getWriter();
		String borrowerId=request.getParameter("id");
		String salary=request.getParameter("salary");
		String loanAmount=request.getParameter("amount");
		String tenure=request.getParameter("repayment");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pincode=request.getParameter("pincode");
		String accountNo=request.getParameter("accountNo");
		String panNo=request.getParameter("pan");
		Part slip=request.getPart("paySlip");
		Part filePart = request.getPart("proof");
		String fileName =filePart.getSubmittedFileName();
		String uploadPath="C:/Users/Anit3573/git/finance/FinanceApplication/src/main/webapp/ProofImages" +fileName;
		try
		{
			FileOutputStream fileOut=new FileOutputStream(uploadPath);
			InputStream input=filePart.getInputStream();
			file=new byte[(input.available())];
			input.read(file);
			fileOut.write(file);
			fileOut.close();
		}
		catch(Exception e)
		{
			e.fillInStackTrace();
		}
		try
		{
			FileOutputStream fileOut=new FileOutputStream(uploadPath);
			InputStream input=slip.getInputStream();
			paySlip=new byte[(input.available())];
			input.read(paySlip);
			fileOut.write(paySlip);
			fileOut.close();
		}
		catch(Exception e)
		{
			e.fillInStackTrace();
		}
		int amount=Integer.parseInt(loanAmount);
		int period=Integer.parseInt(tenure);
		int pincode1=Integer.parseInt(pincode);
		int salary1=Integer.parseInt(salary);
		long accountNumber=Long.parseLong(accountNo);
		String status="Not Approved";
		LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails(borrowerId,salary1,amount,period,city,state,pincode1,accountNumber,panNo,paySlip,file,status);
		try 
		{
			id=borrower.checkId(email);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		if(borrowerId.equals(id))
		{
			try 
			{
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
		else
		{
			response.sendRedirect("loanApplication.jsp");
		}
	}
}
