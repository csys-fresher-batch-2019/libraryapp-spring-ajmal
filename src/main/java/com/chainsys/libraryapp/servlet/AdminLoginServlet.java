package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.libraryapp.service.AdminDetailsService;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDetailsService ob=new AdminDetailsService();
		String AdminMialId = request.getParameter("mailid");
		String AdminPassword = request.getParameter("password");
		System.out.println(AdminMialId );
		System.out.println(AdminPassword);
		Boolean out=false;
		try {
			out=ob.userLogin(AdminMialId, AdminPassword);
			System.out.println(out);
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", "admin");
			response.sendRedirect("adminhome.jsp?infoMessage=LoggedIn");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("adminlogin.jsp?errorMessage="+e.getMessage());
		}
		
		
	}


}
