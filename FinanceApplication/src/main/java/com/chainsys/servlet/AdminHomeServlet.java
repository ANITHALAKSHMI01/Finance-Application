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
import com.chainsys.dao.BorrowerImplementation;
import com.chainsys.model.LoanBorrowerDetails;
import com.chainsys.model.User;
@WebServlet("/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public AdminHomeServlet() 
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BorrowerImplementation borrower=new BorrowerImplementation();
		List<User> list=null;
		try 
		{
			list=borrower.displayBorrowers();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
    	request.setAttribute("list", list);
    	request.getRequestDispatcher("borrowerDetails.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		AdminImplementation admin=new AdminImplementation();
		LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
		loanBorrower.setApplicationId(Integer.parseInt(request.getParameter("id")));
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
			List<LoanBorrowerDetails> lenders=admin.viewlendersDetail();
			request.setAttribute("list", lenders);
			request.getRequestDispatcher("lenders.jsp").forward(request, response);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
