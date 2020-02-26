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
 * Servlet implementation class SearchByBookNameStdServlet
 */
@WebServlet("/SearchByBookNameStdServlet")
public class SearchByBookNameStdServlet extends HttpServlet {
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
				response.sendRedirect("searchbybooknamestd.jsp?errorMessage=No Books Found");
			}
			else
			{
			request.setAttribute("BOOK_LIST", books);
			request.getRequestDispatcher("detailsforbooknamestd.jsp?infoMessage=ListBooks").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("searchbybooknamestd.jsp?errorMessage="+e.getMessage());
		}
		
		//response.sendRedirect("detailsforbooknamestd.jsp?infoMessage=Fine Amount");
	}

}
