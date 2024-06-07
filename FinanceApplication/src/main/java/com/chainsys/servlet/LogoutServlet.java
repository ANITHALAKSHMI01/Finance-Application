package com.chainsys.servlet;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static List list;
	public static BorrowerImplementation borrower=new BorrowerImplementation();
	public static AdminImplementation admin=new AdminImplementation();
    public LogoutServlet()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html"); 
		 request.getSession(false).invalidate();
		 response.sendRedirect("financeHome.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
}
