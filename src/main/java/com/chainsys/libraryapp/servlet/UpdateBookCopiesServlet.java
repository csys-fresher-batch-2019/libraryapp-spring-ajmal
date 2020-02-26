package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.service.BookDetailsService;

/**
 * Servlet implementation class UpdateBookCopiesServlet
 */
@WebServlet("/UpdateBookCopiesServlet")
public class UpdateBookCopiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDetailsService ob=new BookDetailsService();
		String bookid = request.getParameter("bookid");
		int bookId = Integer.valueOf(bookid);

		String bookcopies = request.getParameter("bookcopies");
		int bookCopies = Integer.valueOf(bookcopies);
		try {
			ob.updateBookCopies(bookId, bookCopies);
			response.sendRedirect("updatebookcopies.jsp?infoMessage=Sucessfully Updated Copies");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("updatebookcopies.jsp?errorMessage="+e.getMessage());
			
		}
		
		
		
	}

}
