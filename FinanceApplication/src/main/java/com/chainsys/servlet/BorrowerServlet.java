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
@WebServlet("/BorrowerServlet")
public class BorrowerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static AdminImplementation admin=new AdminImplementation();
	public static BorrowerImplementation borrower=new BorrowerImplementation();
	public static LoanApp loan=new LoanApp();
	public static String password1;
    public BorrowerServlet() 
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
		String id=name.substring(1,4)+phoneNo.substring(3,5);
		String category="Borrower";
		LoanApp loan=new LoanApp(id,name,category,dateOfBirth,phoneNumber,email,password,location);
		out.println("<h2>Registered Successfully...</h2>");
		 out.println("<a href='financeHome.jsp'><button>Home</button></a>");
		try 
		{
			admin.addUser(loan);
//			response.sendRedirect("borrowerLogin.jsp");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List list=null;
		PrintWriter out=response.getWriter();
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		try 
		{
			password1=borrower.checkBorrower(emailId);
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		if(password.equals(password1))
		{
			session.setAttribute("emailId", emailId);
			response.sendRedirect("borrowerAfterLogin.jsp");
//			response.sendRedirect("welcome.jsp?email=" + emailId); 
//			try 
//    		{
//    			list=borrower.displayBorrowers();
//    			System.out.println("Displayed successfully..");
//    		} 
//    		catch (ClassNotFoundException | SQLException e)
//    		{
//    			e.printStackTrace();
//    		}
//        	request.setAttribute("list", list);
//        	request.getRequestDispatcher("borrowerDetails.jsp").forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("borrowerLogin.jsp");
			out.println("<font color=red>Invalid User.</font>"); 
			dispatcher.include(request, response);
		}
	}
}
