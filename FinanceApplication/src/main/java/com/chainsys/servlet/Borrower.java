package com.chainsys.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.BorrowerImplementation;
import com.chainsys.dao.BorrowerSide;
import com.chainsys.model.AmountDetails;
import com.chainsys.model.LoanBorrowerDetails;
@WebServlet("/Borrower")
public class Borrower extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public Borrower()
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<AmountDetails> list=null;
		try 
		{
			list=BorrowerSide.loanDetails();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("loanDetails.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BorrowerImplementation borrower=new BorrowerImplementation();
		List<LoanBorrowerDetails> list=null;
		String id=request.getParameter("search");
		try
		{
			list=borrower.searchBorrower(id);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("statusBaseBorrower.jsp").forward(request, response);
	}

}
