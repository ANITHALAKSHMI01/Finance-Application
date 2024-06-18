package com.chainsys.servlet;
import java.io.IOException;
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
import com.chainsys.dao.BorrowerSide;
import com.chainsys.model.LoanBorrowerDetails;
@WebServlet("/AllowBorrower")
public class AllowBorrower extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static BorrowerImplementation borrower=new BorrowerImplementation();
    public AllowBorrower()
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email=null;
		String id=null;
		response.setContentType("html/text");
		int status=0;
		int active=0;
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
			status=BorrowerSide.checkLender(id);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			active=BorrowerSide.checkActive(id);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		if(status==1 || active==0)
		{
			response.sendRedirect("loanApplication.jsp");
		}
		else
		{
			response.sendRedirect("alreadyApplied.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=null;
		AdminImplementation admin=new AdminImplementation();
		String view = request.getParameter("view");
		if(view != null && view.equals("View"))
		{
			id=request.getParameter("viewId");

			try 
			{
				List<LoanBorrowerDetails> list=admin.viewPaySlip(id);
				request.setAttribute("list", list);
				request.getRequestDispatcher("viewPaySlip.jsp").forward(request, response);
			}
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
