package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BooksTakenByAStudentServlet
 */
@WebServlet("/BooksTakenByAStudentServlet")
public class BooksTakenByAStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println(request.getContextPath());
		
		//HttpSession session = request.getSession();
		//session.setAttribute("LOGGED_IN_USER", "admin");
		
		response.sendRedirect("bookstakenbystudent.jsp?infoMessage=list Book");	}

}
