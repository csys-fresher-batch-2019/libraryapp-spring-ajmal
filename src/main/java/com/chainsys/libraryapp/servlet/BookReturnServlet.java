package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.service.SummaryDetailsService;

/**
 * Servlet implementation class BookReturnServlet
 */
@WebServlet("/BookReturnServlet")
public class BookReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SummaryDetailsService ob = new SummaryDetailsService();

		String bookid = request.getParameter("bookid");
		int bookId = Integer.valueOf(bookid);

		String studentid = request.getParameter("studentid");
		int studentId = Integer.valueOf(studentid);
		int fineAmount;
		try {
			fineAmount = ob.calculateFineAmount(studentId, bookId);
			request.setAttribute("fineamount", fineAmount);
			request.setAttribute("bookid", bookId);
			request.setAttribute("studentid", studentId);
			RequestDispatcher rd=request.getRequestDispatcher("bookreturnfine.jsp?infoMessage=Fine Amount");
			rd.forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("bookreturn.jsp?errorMessage="+e.getMessage());
		}

	}

}
