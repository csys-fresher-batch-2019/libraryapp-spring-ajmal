package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.Student;
import com.chainsys.libraryapp.service.StudentDetailsService;

/**
 * Servlet implementation class AddNewStudentServlet
 */
@WebServlet("/AddNewStudentServlet")
public class AddNewStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDetailsService ob = new StudentDetailsService();
		String studentName = request.getParameter("studentname");
		String studentDepartment = request.getParameter("department");
		String date = request.getParameter("dob");
		Date dob = Date.valueOf(date);
		String studentMailId = request.getParameter("mailid");
		String mobilenumber = request.getParameter("mobilenumber");
		long mobileNumber = Long.valueOf(mobilenumber);
		String yearOfJoin = request.getParameter("yearofjoin");
		int yOfJoin = Integer.valueOf(yearOfJoin);

		Student obj = new Student();
		obj.setName(studentName);
		obj.setDept(studentDepartment);
		obj.setDob(dob.toLocalDate());
		obj.setMailId(studentMailId);
		obj.setMobileNumber(mobileNumber);
		obj.setYearOfJoin(yOfJoin);

		try {
			ob.addStudentDetails(obj);
			response.sendRedirect("addnewstudent.jsp?infoMessage=Successfully Added New Student");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("addnewstudent.jsp?erroeMessage=" + e.getMessage());
		}
	}

}
