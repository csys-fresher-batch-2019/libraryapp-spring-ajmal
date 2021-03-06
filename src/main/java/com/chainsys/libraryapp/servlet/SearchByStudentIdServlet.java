package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.Student;
import com.chainsys.libraryapp.service.StudentService;

/**
 * Servlet implementation class SearchByStudentIdServlet
 */
@WebServlet("/SearchByStudentIdServlet")
public class SearchByStudentIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentService ob = new StudentService();
		String studentid = request.getParameter("studentid");
		int studentId = Integer.parseInt(studentid);
		Student obj = null;
		try {
			obj = ob.displayStudentDetail(studentId);
			request.setAttribute("student", obj);
			request.getRequestDispatcher("displaystudentforid.jsp?infoMessage=StudentDetails").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("searchbystudentid.jsp?errorMessage=" + e.getMessage());
		}
	}
}
