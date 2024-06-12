package com.chainsys.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.dao.AdminImplementation;
import com.chainsys.dao.BorrowerImplementation;
import com.chainsys.model.AmountDetails;
import com.chainsys.model.LoanBorrowerDetails;
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static List list;
	public static BorrowerImplementation borrower=new BorrowerImplementation();
	public static AdminImplementation admin=new AdminImplementation();
	public static String status;
    public LogoutServlet()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html"); 
		 request.getSession(false).invalidate();
		 response.sendRedirect("financeHome.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("html/text");
		String borroweId=request.getParameter("borrower");
		int id=Integer.parseInt(request.getParameter("id"));
		int loanAmount=Integer.parseInt(request.getParameter("amount"));
		LocalDate dateToday = LocalDate.now(); 
		String dateString =dateToday.toString();
		int reduce=(loanAmount*10)/100;
		int distribusalAmount=loanAmount-reduce;
		AmountDetails amount=new AmountDetails(borroweId,id,loanAmount,dateString,reduce,10,12,distribusalAmount);
		try 
		{
			status=borrower.checkStatus(id);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		if(status.equals("Approved"))
		{
			try 
			{
				borrower.billGenerate(amount);
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				list=borrower.viewBill(borroweId);
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("billGeneration.jsp").forward(request, response);
		}
		else
		{
			try 
			{
				List<LoanBorrowerDetails> list=admin.viewlendersDetail(); 
				request.setAttribute("list", list);
				request.getRequestDispatcher("lenders.jsp").forward(request, response);
			}
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
//			RequestDispatcher dispatcher=request.getRequestDispatcher("adminLogin.jsp");
//			out.println("<font color=red>Not Approved Borrower.</font>"); 
//			dispatcher.include(request, response);
		}
//		try 
//		{
//			borrower.billGenerate(amount);
//		} 
//		catch (ClassNotFoundException | SQLException e) 
//		{
//			e.printStackTrace();
//		}
		
		
//		try 
//		{
//			list=borrower.viewBill(id);
//		} 
//		catch (ClassNotFoundException | SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		request.setAttribute("list", list);
//		request.getRequestDispatcher("billGeneration.jsp").forward(request, response);
		
//		try 
//		{
//			List<LoanBorrowerDetails> list=admin.viewlendersDetail();
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("lenders.jsp").forward(request, response);
//		}
//		catch (ClassNotFoundException | SQLException e)
//		{
//			e.printStackTrace();
//		}
	}
}
