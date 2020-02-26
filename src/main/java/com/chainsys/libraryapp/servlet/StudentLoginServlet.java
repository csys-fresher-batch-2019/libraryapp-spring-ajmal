package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.service.StudentDetailsService;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// PrintWriter out = response.getWriter();
		// out.println(request.getContextPath());
		//
		// HttpSession session = request.getSession();
		// session.setAttribute("LOGGED_IN_USER", "Student");
		StudentDetailsService ob = new StudentDetailsService();
		String studentid = request.getParameter("studentid");
		int studentId = Integer.valueOf(studentid);
		String date = request.getParameter("dob");
		LocalDate dateOfBirth = LocalDate.parse(date);
		try {
			Boolean out = ob.studentLogin(studentId, dateOfBirth);
			System.out.println(out);
			if (out) {
				response.sendRedirect("studenthome.jsp?infoMessage=LoggedIn");
			} else {
				response.sendRedirect("studentlogin.jsp?errorMessage=Invalid MailId or DatrOfBirth");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("studentlogin.jsp?errorMessage="+e.getMessage());
		}

		
	}

}
