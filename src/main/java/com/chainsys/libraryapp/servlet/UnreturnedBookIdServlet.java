package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.SummaryDetailsDueDate;
import com.chainsys.libraryapp.service.SummaryDetailsService;

/**
 * Servlet implementation class UnreturnedBookIdServlet
 */
@WebServlet("/UnreturnedBookIdServlet")
public class UnreturnedBookIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SummaryDetailsService ob = new SummaryDetailsService();
		ArrayList<SummaryDetailsDueDate> out = null;
		String bookid = request.getParameter("bookid");
		int bookId = Integer.valueOf(bookid);
		System.out.println(bookId);
		try {
			out = ob.unReturnedBookDetails(bookId);
			if (out==null) {
				System.out.println("No Book has been Taken");
				response.sendRedirect("unreturnedbooks.jsp?errorMessage=NoBookHasBeenTaken");
			} else {
				System.out.println(out);
				request.setAttribute("LIST", out);
				request.getRequestDispatcher("displaybookunreturnedstudent.jsp?infoMessage=ListStudent").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("unreturnedbooks.jsp?errorMessage=" + e.getMessage());

		}

		// response.sendRedirect("displaybookunreturnedstudent.jsp?infoMessage=Serached");
	}

}
