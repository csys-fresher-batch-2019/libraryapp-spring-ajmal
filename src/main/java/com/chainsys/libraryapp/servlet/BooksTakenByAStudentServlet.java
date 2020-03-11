package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.libraryapp.model.SummaryDetailsStudentDetails;
import com.chainsys.libraryapp.service.SummaryDetailsService;

/**
 * Servlet implementation class BooksTakenByAStudentServlet
 */
@WebServlet("/BooksTakenByAStudentServlet")
public class BooksTakenByAStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SummaryDetailsService ob = new SummaryDetailsService();
		HttpSession session = request.getSession();
		int studentId = (int) session.getAttribute("studentId");
		System.out.println(studentId);
		List<SummaryDetailsStudentDetails> out = null;
		try {
			out = ob.unReturnedStudentBookDetails(studentId);
			System.out.println(out);
			if (out != null) {
				request.setAttribute("BOOK_LIST", out);
				request.getRequestDispatcher("bookstakenbystudent.jsp?infoMessage=ListBooks").forward(request,
						response);
			} else {
				System.out.println("This Student has not taken any book");
				response.sendRedirect("studenthome.jsp?infoMessage=You have not taken any book");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("studenthome.jsp?errorMessage=" + e.getMessage());
		}

		// response.sendRedirect("bookstakenbystudent.jsp?infoMessage=list Book");
	}

}
