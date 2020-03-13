package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.libraryapp.dto.StudentFineSummary;
import com.chainsys.libraryapp.service.SummaryService;

/**
 * Servlet implementation class TotalFineOfAStudentServlet
 */
@WebServlet("/TotalFineOfAStudentServlet")
public class TotalFineOfAStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SummaryService ob = new SummaryService();
		HttpSession ses = request.getSession();
		int studentId = (int) ses.getAttribute("studentId");
		int totalFineAmount = 0;
		String name = null;
		List<StudentFineSummary> out = null;
		try {
			out = ob.totalFineAmountOfStudent(studentId);
			for (StudentFineSummary details : out) {
				name = details.getStudentName();
				totalFineAmount = totalFineAmount + details.getFineAmount();
			}
			if (out.isEmpty()) {
				response.sendRedirect("studenthome.jsp?infoMessage=No Book Taken");
			} else {
				request.setAttribute("name", name);
				request.setAttribute("Details", out);
				request.setAttribute("TotalFine", totalFineAmount);
				request.getRequestDispatcher("totalfineofstudent.jsp?infoMessage=TotalFineDetails").forward(request,
						response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("studenthome.jsp?errorMessage=" + e.getMessage());
		}
	}

}
