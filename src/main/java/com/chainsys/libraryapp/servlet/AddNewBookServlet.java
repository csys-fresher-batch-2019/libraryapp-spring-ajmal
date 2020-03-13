package com.chainsys.libraryapp.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.BookService;

/**
 * Servlet implementation class AddNewBookServlet
 */
@WebServlet("/AddNewBookServlet")
public class AddNewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookService ob = new BookService();

		String bookName = request.getParameter("bookname");
		String bookAuthor = request.getParameter("bookauthor");
		String bookCategory = request.getParameter("bookcategory");
		String bookedition = request.getParameter("bookedition");
		int bookEdition = Integer.valueOf(bookedition);
		String bookpages = request.getParameter("bookpages");
		int bookPages = Integer.valueOf(bookpages);
		String bookcopies = request.getParameter("bookcopies");
		int bookCopies = Integer.valueOf(bookcopies);
		String bookprice = request.getParameter("bookprice");
		int bookPrice = Integer.valueOf(bookprice);
		String date = request.getParameter("purchaseddate");
		LocalDate purchasedDate = LocalDate.parse(date);

		Book obj = new Book();
		obj.setName(bookName);
		obj.setCategory(bookCategory);
		obj.setAuthorName(bookAuthor);
		obj.setEdition(bookEdition);
		obj.setPages(bookPages);
		obj.setCopies(bookCopies);
		obj.setPrice(bookPrice);
		obj.setPublishedDate(purchasedDate);

		try {
			ob.addNewBook(obj);
			response.sendRedirect("addnewbook.jsp?infoMessage=Successfully Added New Book");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("addnewbook.jsp?errorMessage=" + e.getMessage());
		}

	}

}
