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
import com.chainsys.model.LoanBorrowerDetails;
@MultipartConfig
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public ApplicationServlet() 
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<LoanBorrowerDetails> list=null;
		BorrowerImplementation borrower=new BorrowerImplementation();
		String email=null;
		String id=null;
		HttpSession session=request.getSession();
		email=(String) session.getAttribute("emailId");
		try 
		{
			id=borrower.checkId(email);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			list=borrower.lenderLoan(id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("appliedLoan.jsp").forward(request, response);
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=null;
		List<LoanBorrowerDetails> list;
		LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
		BorrowerImplementation borrower=new BorrowerImplementation();
		byte[] file=null;
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
		loanBorrower.setBorrowerId(request.getParameter("id"));
		loanBorrower.setSalary(Integer.parseInt(request.getParameter("salary")));
		loanBorrower.setCity(request.getParameter("city"));
		loanBorrower.setState(request.getParameter("state"));
		loanBorrower.setPincode(Integer.parseInt(request.getParameter("pincode")));
		loanBorrower.setAccountNo(Long.parseLong(request.getParameter("accountNo")));
		loanBorrower.setPan(request.getParameter("panNo"));
		loanBorrower.setProof(file);
		try 
		{
			borrower.updateAppliedLoan(loanBorrower);
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		try 
		{
			list=borrower.lenderLoan(id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("appliedLoan.jsp").forward(request, response);
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
