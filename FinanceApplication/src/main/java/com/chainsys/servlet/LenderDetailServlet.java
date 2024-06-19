package com.chainsys.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.AdminImplementation;
import com.chainsys.model.LoanBorrowerDetails;
@WebServlet("/LenderDetailServlet")
public class LenderDetailServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public LenderDetailServlet()
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminImplementation admin=new AdminImplementation();
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
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		AdminImplementation admin=new AdminImplementation();
		LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
		loanBorrower.setBorrowerId(request.getParameter("id"));
		loanBorrower.setStatus(request.getParameter("status"));
		try 
		{
			admin.updateStatus(loanBorrower);
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
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
