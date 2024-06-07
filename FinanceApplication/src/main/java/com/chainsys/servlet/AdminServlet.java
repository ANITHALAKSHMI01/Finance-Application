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
import com.chainsys.model.LoanApp;
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
//	public static LoanApp loan=new LoanApp();
	public static List list;
	public static String password1;
	public static AdminImplementation admin=new AdminImplementation();
	public static BorrowerImplementation borrower=new BorrowerImplementation();
    public AdminServlet() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String dateOfBirth=request.getParameter("dateOfBirth");
		String phoneNo=request.getParameter("phoneNo");
		long phoneNumber=Long.parseLong(phoneNo);
		String email=request.getParameter("emailId");
		String password=request.getParameter("password");
		String location=request.getParameter("location");
		String id=name.substring(0,3)+phoneNo.substring(3,5);
		String category="Admin";
		if(password.equals("Ad101@"))
		{
			out.println("<h2>Registered Successfully...</h2>");
			 out.println("<a href='financeHome.jsp'><button>Home</button></a>");
			LoanApp loan=new LoanApp(id,name,category,dateOfBirth,phoneNumber,email,password,location);
			try 
			{
				admin.addUser(loan);
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
//			response.sendRedirect("adminLogin.jsp");
		}
		else
		{
			response.sendRedirect("adminRegistration.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		try 
		{
			password1=admin.checkAdmin(emailId);
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		if(password.equals(password1))
		{
			session.setAttribute("emailId", emailId);
			response.sendRedirect("adminAfterLogin.jsp");
		}
		else
		{  
			RequestDispatcher dispatcher=request.getRequestDispatcher("adminLogin.jsp");
			out.println("<font color=red>Invalid User.</font>"); 
			dispatcher.include(request, response);
		}
	}
}
