package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.service.SummaryDetailsService;

/**
 * Servlet implementation class BookEntryServlet
 */
@WebServlet("/BookEntryServlet")
public class BookEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SummaryDetailsService ob=new SummaryDetailsService();
		
		String bookid=request.getParameter("bookid");
		int bookId=Integer.valueOf(bookid);

		String studentid=request.getParameter("studentid");
		int studentId=Integer.valueOf(studentid);
		
		try {
			ob.addNewEntry(studentId, bookId);
			response.sendRedirect("bookentry.jsp?infoMessage=EntrySucessful");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("bookentry.jsp?errorMessage=" + e.getMessage());
		}
		
		
		//HttpSession session = request.getSession();
		//session.setAttribute("LOGGED_IN_USER", "admin");
		
			}

}
