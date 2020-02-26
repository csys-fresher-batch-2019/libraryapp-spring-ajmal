package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;

/**
 * Servlet implementation class SearchByBookIdStdServlet
 */
@WebServlet("/SearchByBookIdStdServlet")
public class SearchByBookIdStdServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	BookDetailsService ob=new BookDetailsService();
	String bookid=request.getParameter("bookid");
	
	BookDetails book= null;
	int bookId=Integer.parseInt(bookid);
	try {
		book=ob.displayBook(bookId);
		System.out.println(book);
		request.setAttribute("BOOK_LIST", book);
		request.getRequestDispatcher("detailsforbookidstd.jsp?infoMessage=ListBooks").forward(request, response);
		
	} catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect("searchbybookidstd.jsp?errorMessage="+e.getMessage());
	}
	
	
	//response.sendRedirect("detailsforbookidstd.jsp?infoMessage=Fine Amount");
	}

}
