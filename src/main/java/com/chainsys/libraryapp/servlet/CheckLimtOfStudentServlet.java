package com.chainsys.libraryapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.service.SummaryDetailsService;

/**
 * Servlet implementation class CheckLimtOfStudentServlet
 */
@WebServlet("/CheckLimtOfStudentServlet")
public class CheckLimtOfStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SummaryDetailsService ob=new SummaryDetailsService();
		String studentid=request.getParameter("studentid");
		int studentId=Integer.parseInt(studentid);
		try {
			ob.limitForStudent(studentId);
			response.sendRedirect("checkstudentlimit.jsp?infoMessage=Your limt has not exceeds");	
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("checkstudentlimit.jsp?infoMessage="+e.getMessage());
		}
		System.out.println("Your limt has not exceeds");
		
		//response.sendRedirect("checkstudentlimit.jsp?infoMessage=LimitOf Student");	}
	}
}
