package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.service.SummaryDetailsService;

/**
 * Servlet implementation class BookReturnFineServlet
 */
@WebServlet("/BookReturnFineServlet")
public class BookReturnFineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SummaryDetailsService ob=new SummaryDetailsService();
		String bookid = request.getParameter("bookid");
		int bookId = Integer.valueOf(bookid);

		String studentid = request.getParameter("studentid");
		int studentId = Integer.valueOf(studentid);
		
		String fineamount = request.getParameter("fineamount");
		int fineAmount = Integer.valueOf(fineamount);

		String output = request.getParameter("return");
		
		if(output.equalsIgnoreCase("Y"))
		{
			try {
				ob.updateReturnRecord(studentId, bookId,fineAmount);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("bookreturn.jsp?errorMessage="+e.getMessage());
			}
			response.sendRedirect("bookreturn.jsp?infoMessage=Successfully Returned");
			
			System.out.println("Book Returned");
		}
		else
		{
			response.sendRedirect("bookreturn.jsp?errorMessage=ThankYou...");
		}
	}

}
