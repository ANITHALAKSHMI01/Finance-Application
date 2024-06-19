package com.chainsys.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.AdminImplementation;
import com.chainsys.dao.BorrowerImplementation;
import com.chainsys.model.AmountDetails;
import com.chainsys.model.LoanBorrowerDetails;
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public LogoutServlet()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html"); 
		 request.getSession(false).invalidate();
		 response.sendRedirect("financeHome.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BorrowerImplementation borrower=new BorrowerImplementation();
		AdminImplementation admin=new AdminImplementation();
		String status=null;
		List<AmountDetails> list1=null;
		response.setContentType("html/text");
		String borroweId=request.getParameter("borrower");
		int id=Integer.parseInt(request.getParameter("id"));
		int loanAmount=Integer.parseInt(request.getParameter("amount"));
		int tenure=Integer.parseInt(request.getParameter("tenure"));
		LocalDate dateToday = LocalDate.now(); 
		String dateString =dateToday.toString();
		int reduce=(loanAmount*10)/100;
		int distribusalAmount=loanAmount-reduce;
		AmountDetails amount=new AmountDetails(borroweId,id,loanAmount,dateString,reduce,10,tenure,distribusalAmount);
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
				list1=borrower.viewApprovedBill(borroweId);
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			request.setAttribute("list", list1);
			request.getRequestDispatcher("billGeneration.jsp").forward(request, response);
		}
		else
		{
			try 
			{
				List<LoanBorrowerDetails> lender=admin.viewlendersDetail(); 
				request.setAttribute("list", lender);
				request.getRequestDispatcher("lenders.jsp").forward(request, response);
			}
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
