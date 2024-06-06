package com.chainsys.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.chainsys.util.ConnectionUtil;
@WebServlet("/LenderDetailServlet")
public class LenderDetailServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static AdminImplementation admin=new AdminImplementation();
	public static List list;
    public LenderDetailServlet()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
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
//			System.out.println(list);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}