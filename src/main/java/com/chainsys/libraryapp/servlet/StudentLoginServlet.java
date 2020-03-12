package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.libraryapp.service.StudentDetailsService;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDetailsService ob = new StudentDetailsService();
		String studentid = request.getParameter("studentid");
		int studentId = Integer.valueOf(studentid);
		HttpSession s = request.getSession();
		s.setAttribute("studentId", studentId);
		String date = request.getParameter("dob");
		LocalDate dateOfBirth = LocalDate.parse(date);
		try {
			Boolean out = ob.studentLogin(studentId, dateOfBirth);
			System.out.println(out);
			if (out) {
				response.sendRedirect("studenthome.jsp?infoMessage=LoggedIn");
			} else {
				response.sendRedirect("studentlogin.jsp?errorMessage=Invalid StudentId or DatrOfBirth");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("studentlogin.jsp?errorMessage=" + e.getMessage());
		}
	}
}
