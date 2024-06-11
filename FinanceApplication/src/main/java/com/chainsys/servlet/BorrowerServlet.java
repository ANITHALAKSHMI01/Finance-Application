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
import com.chainsys.dao.BorrowerValidation;
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
		List emailId=null;
		List phoneNo1=null;
		List password1=null;
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
		try 
		{
			emailId=BorrowerValidation.checkEmail();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			phoneNo1=BorrowerValidation.checkPhoneNo();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		try
		{
			password1=BorrowerValidation.checkPassword();
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		if(emailId.contains(email) || phoneNo1.contains(phoneNumber) || password1.contains(password) )
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("adminRegistration.jsp");
			out.println("<font color=red>Email or Password or Phone No already exist.</font>"); 
			dispatcher.include(request, response);
		}
		else
		{
//			out.println("<h2>Registered Successfully...</h2>");
//			out.println("<a href='financeHome.jsp'><button>Home</button></a>");
			try 
			{
				admin.addUser(loan);
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			response.sendRedirect("afterRegistration.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
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
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("borrowerLogin.jsp");
			out.println("<center><font color=red>Invalid User.</font></center>"); 
			dispatcher.include(request, response);
		}
	}
}
