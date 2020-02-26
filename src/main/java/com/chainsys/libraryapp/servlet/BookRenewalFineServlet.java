package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.service.SummaryDetailsService;

/**
 * Servlet implementation class BookRenewalFineServlet
 */
@WebServlet("/BookRenewalFineServlet")
public class BookRenewalFineServlet extends HttpServlet {
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
				ob.addNewEntry(studentId, bookId);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("bookrenewal.jsp?errorMessage="+e.getMessage());
			}
			response.sendRedirect("bookrenewal.jsp?infoMessage=Successfully Renewed");
			
			System.out.println("Book Renewed");
		}
		else
		{
			response.sendRedirect("bookrenewal.jsp?errorMessage=ThankYou...");
		}
	}

}
