package com.chainsys.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import com.chainsys.model.LoanBorrowerDetails;
@WebServlet("/AdminLenders")
public class AdminLenders extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static List list;
	public static BorrowerImplementation borrower=new BorrowerImplementation();
	public static AdminImplementation admin=new AdminImplementation();
    public AdminLenders() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("emailId");
		System.out.println(email);
		try 
		{
			list=admin.selectAdmin(email);
			System.out.println(list);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("adminDetails.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id=null;
		String view = request.getParameter("view");
		if(view != null && view.equals("View"))
		{
			id=request.getParameter("viewId");

			try 
			{
				List<LoanBorrowerDetails> list=admin.viewProof(id);
				request.setAttribute("list", list);
				request.getRequestDispatcher("viewProof.jsp").forward(request, response);
			}
			catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
