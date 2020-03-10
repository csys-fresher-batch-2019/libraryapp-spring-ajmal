package com.chainsys.libraryapp.dao;

import org.jdbi.v3.core.Jdbi;

import com.chainsys.libraryapp.util.Connectionutil;

public class DAOFactory {

	public static BookDetailsDAO getBookDetailDAO() {

		Jdbi jdbi = Connectionutil.getJdbi();
		BookDetailsDAO bookDetailsDAO = jdbi.onDemand(BookDetailsDAO.class);

		return bookDetailsDAO;
	}

	public static StudentDetailsDAO getStudentDetailDAO() {

		Jdbi jdbi = Connectionutil.getJdbi();
		StudentDetailsDAO studentDetailsDAO = jdbi.onDemand(StudentDetailsDAO.class);

		return studentDetailsDAO;
	}

	public static SummaryDetailsDAO getSummaryDetailDAO() {

		Jdbi jdbi = Connectionutil.getJdbi();
		SummaryDetailsDAO summaryDetailsDAO = jdbi.onDemand(SummaryDetailsDAO.class);

		return summaryDetailsDAO;
	}

	public static AdminDetailsDAO getAdminDetailDAO() {

		Jdbi jdbi = Connectionutil.getJdbi();
		AdminDetailsDAO adminDetailsDAO = jdbi.onDemand(AdminDetailsDAO.class);

		return adminDetailsDAO;
	}

}
