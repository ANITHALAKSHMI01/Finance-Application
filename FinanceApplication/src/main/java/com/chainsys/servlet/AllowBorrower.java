package com.chainsys.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.dao.BorrowerImplementation;
import com.chainsys.dao.BorrowerSide;
@WebServlet("/AllowBorrower")
public class AllowBorrower extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static String email,id;
	public static BorrowerImplementation borrower=new BorrowerImplementation();
    public AllowBorrower()
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
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
//			out.println("Already applied loan.");
			response.sendRedirect("alreadyApplied.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//
	}
}
