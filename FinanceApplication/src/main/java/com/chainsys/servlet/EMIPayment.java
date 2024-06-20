package com.chainsys.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.BorrowerSide;
@WebServlet("/EMIPayment")
public class EMIPayment extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public EMIPayment() 
    {
        super();
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    	 int totalAmount=0;
    	 int borrowerAmount=0;
    	 int emi=Integer.parseInt(request.getParameter("amount"));
    	 long accountNo=Long.parseLong(request.getParameter("account"));
    	 long adminAccountNo=675432189076543l;
    	try
   		{
    		borrowerAmount=BorrowerSide.getAmount(accountNo);
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
   		int balance=totalAmount+emi;
   		int creditAmount=borrowerAmount-emi;
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
   		response.sendRedirect("afterBorrowerPayment.jsp");
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//
	}

}
