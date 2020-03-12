package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.BookDetailsService;
import com.chainsys.libraryapp.service.SummaryDetailsService;

/**
 * Servlet implementation class SearchByBookIdServlet
 */
@WebServlet("/SearchByBookIdServlet")
public class SearchByBookIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookDetailsService ob = new BookDetailsService();
		SummaryDetailsService obj=new SummaryDetailsService();
		String bookid = request.getParameter("bookid");
		int available;
		Book book = null;
		int bookId = Integer.parseInt(bookid);
		try {
			book = ob.displayBook(bookId);
			available=obj.noOfBooksAvailable(bookId);
			System.out.println(book);
			request.setAttribute("AvailableCopies", available);
			request.setAttribute("BOOK_LIST", book);
			request.getRequestDispatcher("detailsforbookid.jsp?infoMessage=ListBooks").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("searchbybookid.jsp?errorMessage=" + e.getMessage());
		}
	}
}
