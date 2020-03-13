package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.BookService;

/**
 * Servlet implementation class DisplayAllBooksServlet
 */
@WebServlet("/DisplayAllBooksServlet")
public class DisplayAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookService ob = new BookService();
		List<Book> books = null;
		try {
			books = ob.displayAllBooks();
			//System.out.println(books);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		request.setAttribute("BOOK_LIST", books);
		request.getRequestDispatcher("displayallbooks.jsp?infoMessage=ListBooks").forward(request, response);
	}
}
