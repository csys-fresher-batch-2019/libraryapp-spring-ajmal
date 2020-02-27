package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.service.AdminDetailsService;

/**
 * Servlet implementation class AddNewAdminServlet
 */
@WebServlet("/AddNewAdminServlet")
public class AddNewAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//AdminDetailsService ob = new AdminDetailsService();
//		String bookName = request.getParameter("adminname");
//		String bookName = request.getParameter("bookname");
//		String bookName = request.getParameter("bookname");
//		String bookName = request.getParameter("bookname");
//		String bookName = request.getParameter("bookname");
//		String bookName = request.getParameter("bookname");
		response.sendRedirect("adminhime.jsp?infoMessage=AdminHome");
		
	}

}
