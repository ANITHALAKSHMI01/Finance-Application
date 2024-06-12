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
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static AdminImplementation admin=new AdminImplementation();
    public SearchServlet() 
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<LoanBorrowerDetails> list=null;
		String status=request.getParameter("search");
		try
		{
			list=admin.searchStatus(status);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("statusBaseBorrower.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
   // TODO document why this method is empty
    }
}
