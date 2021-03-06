package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.BookService;
import com.chainsys.libraryapp.service.SummaryService;

/**
 * Servlet implementation class SearchByBookIdStdServlet
 */
@WebServlet("/SearchByBookIdStdServlet")
public class SearchByBookIdStdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookService ob = new BookService();
		SummaryService obj = new SummaryService();
		String bookid = request.getParameter("bookid");
		Book book = null;
		int available;
		int bookId = Integer.parseInt(bookid);
		try {
			available = obj.noOfBooksAvailable(bookId);
			book = ob.displayBook(bookId);
			System.out.println(book);
			request.setAttribute("AvailableCopies", available);
			request.setAttribute("BOOK_LIST", book);
			request.getRequestDispatcher("detailsforbookidstd.jsp?infoMessage=ListBooks").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("searchbybookidstd.jsp?errorMessage=" + e.getMessage());
		}
	}
}
