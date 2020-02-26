package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.StudentFineSummaryDetails;
import com.chainsys.libraryapp.service.SummaryDetailsService;

/**
 * Servlet implementation class TotalFineOfAStudentServlet
 */
@WebServlet("/TotalFineOfAStudentServlet")
public class TotalFineOfAStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SummaryDetailsService ob = new SummaryDetailsService();
		String studentid = request.getParameter("studentid");
		int studentId = Integer.parseInt(studentid);
		int totalFineAmount = 0;
		String name = null;
		ArrayList<StudentFineSummaryDetails> out = null;
		try {
			out = ob.totalFineAmountOfStudent(studentId);
			for (StudentFineSummaryDetails details : out) {
				name = details.getStudentName();
				totalFineAmount = totalFineAmount + details.getFineAmount();
			}
			if (out.isEmpty()) {
				request.setAttribute("OUT", out);
				request.getRequestDispatcher("displayallbooksadmin.jsp?infoMessage=ListBooks").forward(request,
						response);
			}else
			{
				response.sendRedirect("studenthome.jsp?infoMessage=No Book Taken");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("studenthome.jsp?errorMessage="+e.getMessage());	
		}

		System.out.println("StudentName : " + name);
		System.out.println("Total Fine Amount : " + totalFineAmount);
		// for(StudentFineSummaryDetails details:out)
		// {
		// System.out.println(details);
		// }

		// PrintWriter out = response.getWriter();
		// out.println(request.getContextPath());

		// HttpSession session = request.getSession();
		// session.setAttribute("LOGGED_IN_USER", "admin");

		//response.sendRedirect("totalfineofstudent.jsp?infoMessage=Fine Calculated");
	}

}
