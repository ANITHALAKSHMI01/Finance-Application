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
import com.chainsys.model.User;
@WebServlet("/BorrowerUpdate")
public class BorrowerUpdate extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public static BorrowerImplementation borrower=new BorrowerImplementation();
	public static User user=new User();
    public BorrowerUpdate()
    {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List list=null;
		String delete = request.getParameter("delete");
        if(delete != null && delete.equals("Delete"))
        {
        	String id=request.getParameter("deleteId");
        	user.setId(id);
        	try 
        	{
				borrower.removeUser(user);
			} 
        	catch (ClassNotFoundException | SQLException e) 
        	{
				e.printStackTrace();
			}
        	try 
    		{
    			list=borrower.displayBorrowers();
    		} 
    		catch (ClassNotFoundException | SQLException e)
    		{
    			e.printStackTrace();
    		}
        	request.setAttribute("list", list);
        	request.getRequestDispatcher("borrowerDetails.jsp").forward(request,response);
	  }
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List list=null;
		String phoneNo=request.getParameter("phoneNo");
		long phoneNumber=Long.parseLong(phoneNo);
     	String email=request.getParameter("emailId");
		String location=request.getParameter("location");
		String id=request.getParameter("id");
		user.setId(id);
		user.setPhoneNo(phoneNumber);
		user.setLocation(location);
		try 
    	{
			borrower.updateUser(user);
		} 
    	catch (ClassNotFoundException | SQLException e) 
    	{
			e.printStackTrace();
		}
    	try 
		{
    		list=borrower.selectUser(email);
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
    	request.setAttribute("list", list);
    	request.getRequestDispatcher("borrowerProfile.jsp").forward(request,response);
	}
}
