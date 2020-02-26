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
 * Servlet implementation class SearchByBookNameServlet
 */
@WebServlet("/SearchByBookNameServlet")
public class SearchByBookNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDetailsService ob=new BookDetailsService();
		String bookName=request.getParameter("bookname");
		ArrayList<BookDetails> books=null;
		try {
			books=ob.searchByName(bookName);
			System.out.println(books);
			if(books==null || books.isEmpty())
			{
				response.sendRedirect("searchbybookname.jsp?errorMessage=No Books Found");
			}
			else
			{
			request.setAttribute("BOOK_LIST", books);
			request.getRequestDispatcher("displayforbookname.jsp?infoMessage=ListBooks").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("searchbybookname.jsp?errorMessage="+e.getMessage());
		}
		
		
	}

}
