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
import com.chainsys.model.AmountDetails;
import com.chainsys.model.LoanBorrowerDetails;
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public BillServlet() 
    {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 BorrowerImplementation borrower=new BorrowerImplementation();
		String email=null;
		String id=null;
		List<AmountDetails> list=null;
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
			list=borrower.viewApprovedBill(id);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("borrowerBill.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 AdminImplementation admin=new AdminImplementation();
		int payAmount=0;
		int totalAmount=0;
		String id=request.getParameter("id");
		long adminAccountNo=675432189076543l;
		long accountNo=Long.parseLong(request.getParameter("account"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		try
		{
			admin.sendBill(id);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		try
		{
			payAmount=BorrowerSide.getAmount(accountNo);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		try
		{
			totalAmount=BorrowerSide.getAmount(adminAccountNo);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		int balance=totalAmount-amount;
		int creditAmount=payAmount+amount;
		try 
		{
			BorrowerSide.updateBalance(creditAmount, accountNo);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			BorrowerSide.updateBalance(balance, adminAccountNo);
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
