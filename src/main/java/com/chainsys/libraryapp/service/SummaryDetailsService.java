package com.chainsys.libraryapp.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.dao.StudentDetailsDAO;
import com.chainsys.libraryapp.dao.SummaryDetailsDAO;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.exception.ValidationException;
import com.chainsys.libraryapp.model.StudentFineSummaryDetails;
import com.chainsys.libraryapp.model.SummaryDetailsDueDate;
import com.chainsys.libraryapp.model.SummaryDetailsStudentDetails;
import com.chainsys.libraryapp.util.Constant;
import com.chainsys.libraryapp.validation.Validation;

public class SummaryDetailsService {

	static SummaryDetailsDAO summaryDetailsDAO = DAOFactory.getSummaryDetailDAO();
	static BookDetailsDAO bookDetailsDAO = DAOFactory.getBookDetailDAO();
	static StudentDetailsDAO studentDetailsDAO = DAOFactory.getStudentDetailDAO();

	public void addNewEntry(int studentId, int bookId) throws ServiceException {

		try {
			Validation.checkBookId(bookId);
			Validation.checkStudentId(studentId);
			Integer bookTaken = summaryDetailsDAO.bookTaken(studentId, bookId);
			if (bookTaken == null) {
				summaryDetailsDAO.addNewEntry(studentId, bookId);
			} else {
				throw new ServiceException(Constant.YOU_HAVE_ALREADY_TAKEN_THE_BOOK);
			}
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException("Unable to AddNewEntry", e);
		}

	}

	public Integer calculateFineAmount(int studentId, int bookId) throws ServiceException {
		Integer fine = 0;
		try {
			Validation.checkBookId(bookId);
			Validation.checkStudentId(studentId);
			LocalDate dueDate = summaryDetailsDAO.returnDueDate(studentId, bookId);
			if (dueDate == null) {
				throw new ServiceException("You have not taken the book");
			}
			LocalDate returnedDate = LocalDate.now();
			if (returnedDate.isAfter(dueDate)) {
				int diffInDays = (int) ChronoUnit.DAYS.between(dueDate, returnedDate);
				fine = diffInDays * 2;

			} else {
				// System.out.println("No Due Pending");
				fine = 0;
			}

		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException("Unable to Calculate Fine Amount", e);
		}

		return fine;
	}

	public void updateReturnRecord(int studentId, int bookId, Integer fineAmount) throws ServiceException {
		try {
			Validation.checkBookId(bookId);
			Validation.checkStudentId(studentId);
			summaryDetailsDAO.updateReturnRecord(studentId, bookId, fineAmount);
		} catch (DbException e) {
			throw new ServiceException("Unable to Update", e);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public ArrayList<SummaryDetailsDueDate> unReturnedBookDetails(int bookId) throws ServiceException {
		try {
			Validation.checkBookId(bookId);
			return summaryDetailsDAO.unReturnedBookDetails(bookId);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException("Unable to Return Book", e);
		}

	}

	public int totalFineAmount() throws ServiceException {
		try {
			return summaryDetailsDAO.totalFineAmount();
		} catch (DbException e) {
			throw new ServiceException("Unable to Calculate", e);
		}
	}

	public ArrayList<SummaryDetailsStudentDetails> unReturnedStudentBookDetails(int studentId) throws ServiceException {
		try {
			Validation.checkStudentId(studentId);
			return summaryDetailsDAO.unReturnedStudentBookDetails(studentId);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException("Unable to Display", e);
		}

	}

	public void bookTaken(int studentId, int bookId) throws ServiceException {
		Integer bookTaken;
		try {
			Validation.checkBookId(bookId);
			Validation.checkStudentId(studentId);
			bookTaken = summaryDetailsDAO.bookTaken(studentId, bookId);
			if (bookTaken != null) {
				throw new ServiceException("You have not taken the book");
			}
		} catch (DbException e) {
			throw new ServiceException("Unable to show", e);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		// return bookTaken != null;
	}

	public ArrayList<StudentFineSummaryDetails> totalFineAmountOfStudent(int studentId) throws ServiceException {

		LocalDate returnedDate = LocalDate.now();
		ArrayList<StudentFineSummaryDetails> out = null;
		try {
			Validation.checkStudentId(studentId);
			out = summaryDetailsDAO.totalFineAmountOfStudent(studentId);
			for (StudentFineSummaryDetails details : out) {
				if (returnedDate.isAfter(details.getDueDate())) {
					int diffInDays = (int) ChronoUnit.DAYS.between(details.getDueDate(), returnedDate);
					int fineAmount = diffInDays * 2;
					details.setFineAmount(fineAmount);

				}
			}
		} catch (DbException e) {
			throw new ServiceException("Unable to Display", e);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		// return summaryDetailsDAO.totalFineAmountOfStudent(studentId);
		return out;
	}

	public Integer noOfBooksAvailable(int bookId) throws ServiceException {
		try {
			Validation.checkBookId(bookId);
			return summaryDetailsDAO.noOfBooksAvailable(bookId);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException("Unable to Calculate", e);
		}

	}

	public void limitForStudent(int studentId) throws ServiceException {
		try {
			Validation.checkStudentId(studentId);
			int limit = summaryDetailsDAO.limitForStudent(studentId);
			if (limit > 5) {
				throw new ServiceException("You limit for talking the books has Exceeded");
			}
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException("Unable to Calculate", e);
		}

	}

}
