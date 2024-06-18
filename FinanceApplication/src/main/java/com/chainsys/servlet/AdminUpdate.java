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
import com.chainsys.model.User;
@WebServlet("/AdminUpdate")
public class AdminUpdate extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public AdminUpdate()
    {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   	{
    	AdminImplementation admin=new AdminImplementation();
    	BorrowerImplementation borrower=new BorrowerImplementation();
    	User user=new User();
   		List<User> list=null;
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
           		list=admin.displayDetails();
       		} 
       		catch (ClassNotFoundException | SQLException e)
       		{
       			e.printStackTrace();
       		}
           	request.setAttribute("list", list);
           	request.getRequestDispatcher("adminDetails.jsp").forward(request,response);
   	  }
   	}
   	@Override
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
   		AdminImplementation admin=new AdminImplementation();
   		BorrowerImplementation borrower=new BorrowerImplementation();
   		User user=new User();
   		List<User> list=null;
   		String phoneNo=request.getParameter("phoneNo");
   		long phoneNumber=Long.parseLong(phoneNo);
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
       		list=admin.displayDetails();
   		} 
   		catch (ClassNotFoundException | SQLException e)
   		{
   			e.printStackTrace();
   		}
       	request.setAttribute("list", list);
       	request.getRequestDispatcher("adminDetails.jsp").forward(request,response);
   	}
}
