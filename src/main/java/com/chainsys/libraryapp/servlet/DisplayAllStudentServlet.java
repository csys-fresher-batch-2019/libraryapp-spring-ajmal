package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.Student;
import com.chainsys.libraryapp.service.StudentService;

/**
 * Servlet implementation class DisplayAllStudentServlet
 */
@WebServlet("/DisplayAllStudentServlet")
public class DisplayAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentService ob = new StudentService();
		List<Student> student = null;
		try {
			student = ob.displayAllStudents();
			System.out.println(student);
			request.setAttribute("STUDENT_LIST", student);
			request.getRequestDispatcher("displayallstudent.jsp?infoMessage=ListStudent").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("adminhome.jsp?errorMessage=" + e.getMessage());
		}
	}
}
