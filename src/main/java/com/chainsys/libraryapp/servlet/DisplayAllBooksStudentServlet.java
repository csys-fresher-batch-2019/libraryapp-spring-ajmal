package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;

/**
 * Servlet implementation class DisplayAllBooksStudentServlet
 */
@WebServlet("/DisplayAllBooksStudentServlet")
public class DisplayAllBooksStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDetailsService ob=new BookDetailsService();
		ArrayList<BookDetails> books= null;
		try {
			books=ob.displayAllBooks();
			System.out.println(books);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		request.setAttribute("BOOK_LIST", books);
		request.getRequestDispatcher("displayallbooksstudent.jsp?infoMessage=ListBooks").forward(request, response);
		
		}

}
