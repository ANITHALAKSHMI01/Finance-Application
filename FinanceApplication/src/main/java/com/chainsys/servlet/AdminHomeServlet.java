package com.chainsys.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.AdminImplementation;
import com.chainsys.dao.BorrowerImplementation;
import com.chainsys.model.LoanBorrowerDetails;
@WebServlet("/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static List list;
	public static BorrowerImplementation borrower=new BorrowerImplementation();
	public static AdminImplementation admin=new AdminImplementation();
    public AdminHomeServlet() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			list=borrower.displayBorrowers();
			System.out.println("Displayed successfully..");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
    	request.setAttribute("list", list);
    	request.getRequestDispatcher("borrowerDetails.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
		loanBorrower.setBorrowerId(request.getParameter("id"));
		loanBorrower.setStatus(request.getParameter("approval"));
		try 
		{
			admin.approveBorrower(loanBorrower);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			List<LoanBorrowerDetails> list=admin.viewlendersDetail();
			request.setAttribute("list", list);
			request.getRequestDispatcher("lenders.jsp").forward(request, response);
//			System.out.println(list);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
