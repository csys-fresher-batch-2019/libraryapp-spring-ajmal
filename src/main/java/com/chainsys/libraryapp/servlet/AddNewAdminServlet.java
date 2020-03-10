package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.model.AdminDetails;
import com.chainsys.libraryapp.service.AdminDetailsService;

/**
 * Servlet implementation class AddNewAdminServlet
 */
@WebServlet("/AddNewAdminServlet")
public class AddNewAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDetailsService ob = new AdminDetailsService();
		String adminName = request.getParameter("adminname");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("mobilenumber");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		AdminDetails obj = new AdminDetails();
		obj.setAdminName(adminName);
		obj.setAdminDOB(LocalDate.parse(dob));
		obj.setAdminMailId(email);
		obj.setAdminMobileNo(Long.valueOf(mobileNumber));
		obj.setAdminPassword(password);
		obj.setAdminGender(gender);
		try {
			ob.addNewAdmin(obj);
			response.sendRedirect("adminhome.jsp?infoMessage=NewAdminAdded");
		} catch (ServiceException e) {
			response.sendRedirect("addnewadmin.jsp?errorMessage=" + e.getMessage());
		}

	}

}
