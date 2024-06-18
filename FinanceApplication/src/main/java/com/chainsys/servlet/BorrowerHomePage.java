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
import com.chainsys.dao.BorrowerImplementation;
import com.chainsys.dao.BorrowerSide;
import com.chainsys.dao.BorrowerValidation;
import com.chainsys.model.LoanBorrowerDetails;
@MultipartConfig
@WebServlet("/BorrowerHomePage")
public class BorrowerHomePage extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static String email,id;
	public static int row;
    public BorrowerHomePage()
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List list=null;
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
		List<Long> accountNumber=null;
		List<String> pan=null;
		byte[] file=null;
		byte[] paySlip=null;
		PrintWriter out=response.getWriter();
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
		
		Part slip=request.getPart("paySlip");
		String paySlip1 =slip.getSubmittedFileName();
		String uploadPath1="C:/Users/Anit3573/git/finance/FinanceApplication/src/main/webapp/PaySlip/" +paySlip1;
		try(FileOutputStream fileOut=new FileOutputStream(uploadPath1);
			InputStream input=slip.getInputStream())
		{
//			FileOutputStream fileOut=new FileOutputStream(uploadPath1);
//			InputStream input=slip.getInputStream();
//			paySlip=new byte[(input.available())];
			paySlip=input.readAllBytes();
//			input.read(paySlip);
			fileOut.write(paySlip);
			fileOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Part filePart = request.getPart("proof");
		String fileName =filePart.getSubmittedFileName();
		String uploadPath="C:/Users/Anit3573/git/finance/FinanceApplication/src/main/webapp/ProofImages/" +fileName;
		try(FileOutputStream fileOut=new FileOutputStream(uploadPath);
			InputStream input=filePart.getInputStream())
		{
//			FileOutputStream fileOut=new FileOutputStream(uploadPath);
//			InputStream input=filePart.getInputStream();
//			file=new byte[(input.available())];
			file=input.readAllBytes();
//			input.read(file);
			fileOut.write(file);
			fileOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		int amount=Integer.parseInt(loanAmount);
		int period=Integer.parseInt(tenure);
		int pincode1=Integer.parseInt(pincode);
		int salary1=Integer.parseInt(salary);
		long accountNumber1=Long.parseLong(accountNo);
		String status="Not Approved";
		try 
		{
			accountNumber=BorrowerValidation.checkAccountNo();
			accountNumber.add(675432189076543l);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			pan=BorrowerValidation.checkPan();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		if(amount>0 && period>0 && salary1>0)
		{
			if(accountNumber.contains(accountNumber1) || pan.contains(pan1))
			{
				response.setContentType("text/html");
				RequestDispatcher dispatcher=request.getRequestDispatcher("loanApplication.jsp");
				out.println("<font color=red>Account No Or PAN already exist.</font>"); 
				dispatcher.include(request, response);
			}
			else
			{
				int balance=1000;
				System.out.println(paySlip);
				System.out.println(file);
				LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails(borrowerId,salary1,amount,period,city,state,pincode1,accountNumber1,pan1,paySlip,file,status);
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
						BorrowerSide.addAccount(accountNumber1,balance);
					} 
					catch (ClassNotFoundException | SQLException e) 
					{
						e.printStackTrace();
					}
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
		else
		{
			response.setContentType("text/html");
			RequestDispatcher dispatcher=request.getRequestDispatcher("loanApplication.jsp");
			out.println("<font color=red>Amount Or Salary Or Tenure should be Positive.</font>"); 
			dispatcher.include(request, response);
		}
	}	
}
