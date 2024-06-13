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
	public static BorrowerImplementation borrower=new BorrowerImplementation();
	public static AdminImplementation admin=new AdminImplementation();
	public static User loan=new User();
    public AdminUpdate()
    {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   	{
   		List list=null;
   		String delete = request.getParameter("delete");
           if(delete != null && delete.equals("Delete"))
           {
           	String id=request.getParameter("deleteId");
           	loan.setId(id);
           	try 
           	{
   				borrower.removeUser(loan);
   			} 
           	catch (ClassNotFoundException | SQLException e) 
           	{
   				e.printStackTrace();
   			}
           	try 
       		{
           		list=admin.displayDetails();
       			System.out.println("Displayed successfully..");
       		} 
       		catch (ClassNotFoundException | SQLException e)
       		{
       			e.printStackTrace();
       		}
           	request.setAttribute("list", list);
           	request.getRequestDispatcher("adminDetails.jsp").forward(request,response);
   	  }
   	}
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
   		List list=null;
//   		String name=request.getParameter("name");
   		String phoneNo=request.getParameter("phoneNo");
   		long phoneNumber=Long.parseLong(phoneNo);
//   		String email=request.getParameter("emailId");
   		String location=request.getParameter("location");
   		String id=request.getParameter("id");
   		loan.setId(id);
//   		loan.setName(name);
//   		loan.setEmail(email);
   		loan.setPhoneNo(phoneNumber);
   		loan.setLocation(location);
   		try 
       	{
   			borrower.updateUser(loan);
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
