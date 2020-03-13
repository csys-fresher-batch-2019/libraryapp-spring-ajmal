package com.chainsys.libraryapp.dao;

import org.jdbi.v3.core.Jdbi;

import com.chainsys.libraryapp.util.Connectionutil;

public class DAOFactory {

	public static BookDAO getBookDAO() {

		Jdbi jdbi = Connectionutil.getJdbi();
		BookDAO bookDAO = jdbi.onDemand(BookDAO.class);

		return bookDAO;
	}

	public static StudentDAO getStudentDAO() {

		Jdbi jdbi = Connectionutil.getJdbi();
		StudentDAO studentDAO = jdbi.onDemand(StudentDAO.class);

		return studentDAO;
	}

	public static SummaryDAO getSummaryDAO() {

		Jdbi jdbi = Connectionutil.getJdbi();
		SummaryDAO summaryDAO = jdbi.onDemand(SummaryDAO.class);

		return summaryDAO;
	}

	public static AdminDAO getAdminDAO() {

		Jdbi jdbi = Connectionutil.getJdbi();
		AdminDAO adminDAO = jdbi.onDemand(AdminDAO.class);

		return adminDAO;
	}

}
