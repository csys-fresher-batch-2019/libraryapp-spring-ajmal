package com.chainsys.libraryapp.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.chainsys.libraryapp.dao.BookDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.dao.StudentDAO;
import com.chainsys.libraryapp.dao.SummaryDAO;
import com.chainsys.libraryapp.dto.StudentFineSummaryDTO;
import com.chainsys.libraryapp.dto.SummaryDueDateDTO;
import com.chainsys.libraryapp.dto.SummaryStudentDetailsDTO;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.exception.ValidationException;
import com.chainsys.libraryapp.util.Constant;
import com.chainsys.libraryapp.validation.Validation;

public class SummaryService {

	static SummaryDAO summaryDetailsDAO = DAOFactory.getSummaryDAO();
	static BookDAO bookDetailsDAO = DAOFactory.getBookDAO();
	static StudentDAO studentDetailsDAO = DAOFactory.getStudentDAO();

	public void addNewEntry(int studentId, int bookId) throws ServiceException {

		try {
			Validation.checkBookId(bookId);
			Validation.checkStudentId(studentId);
			Integer bookTaken = summaryDetailsDAO.bookTaken(studentId, bookId);
			if (bookTaken == null) {
				summaryDetailsDAO.save(studentId, bookId);
			} else {
				throw new ServiceException(Constant.YOU_HAVE_ALREADY_TAKEN_THE_BOOK);
			}
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_ADD_NEW_ENTRY, e);
		}

	}

	public Integer calculateFineAmount(int studentId, int bookId) throws ServiceException {
		Integer fine = 0;
		try {
			Validation.checkBookId(bookId);
			Validation.checkStudentId(studentId);
			LocalDate dueDate = summaryDetailsDAO.returnDueDate(studentId, bookId);
			if (dueDate == null) {
				throw new ServiceException(Constant.YOU_HAVE_NOT_TAKEN_THE_BOOK);
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
			throw new ServiceException(Constant.UNABLE_TO_CALCULATE_FINE_AMOUNT, e);
		}

		return fine;
	}

	public void updateReturnRecord(int studentId, int bookId, Integer fineAmount) throws ServiceException {
		try {
			Validation.checkBookId(bookId);
			Validation.checkStudentId(studentId);
			summaryDetailsDAO.updateReturnRecord(studentId, bookId, fineAmount);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_UPDATE, e);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<SummaryDueDateDTO> unReturnedBookDetails(int bookId) throws ServiceException {
		try {
			Validation.checkBookId(bookId);
			return summaryDetailsDAO.unReturnedBookDetails(bookId);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_RETURN_BOOK, e);
		}

	}

	public int totalFineAmount() throws ServiceException {
		try {
			return summaryDetailsDAO.totalFineAmount();
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_CALCULATE, e);
		}
	}

	public List<SummaryStudentDetailsDTO> unReturnedStudentBookDetails(int studentId) throws ServiceException {
		try {
			Validation.checkStudentId(studentId);
			return summaryDetailsDAO.unReturnedStudentBookDetails(studentId);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_DISPLAY, e);
		}

	}

	public void bookTaken(int studentId, int bookId) throws ServiceException {
		Integer bookTaken;
		try {
			Validation.checkBookId(bookId);
			Validation.checkStudentId(studentId);
			bookTaken = summaryDetailsDAO.bookTaken(studentId, bookId);
			if (bookTaken != null) {
				throw new ServiceException(Constant.YOU_HAVE_NOT_TAKEN_THE_BOOK);
			}
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_SHOW, e);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		// return bookTaken != null;
	}

	public List<StudentFineSummaryDTO> totalFineAmountOfStudent(int studentId) throws ServiceException {

		LocalDate returnedDate = LocalDate.now();
		List<StudentFineSummaryDTO> out = null;
		try {
			Validation.checkStudentId(studentId);
			out = summaryDetailsDAO.totalFineAmountOfStudent(studentId);
			for (StudentFineSummaryDTO details : out) {
				if (returnedDate.isAfter(details.getDueDate())) {
					int diffInDays = (int) ChronoUnit.DAYS.between(details.getDueDate(), returnedDate);
					int fineAmount = diffInDays * 2;
					details.setFineAmount(fineAmount);

				}
			}
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_DISPLAY, e);
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
			throw new ServiceException(Constant.UNABLE_TO_CALCULATE, e);
		}

	}

	public void limitForStudent(int studentId) throws ServiceException {
		try {
			Validation.checkStudentId(studentId);
			int limit = summaryDetailsDAO.limitForStudent(studentId);
			if (limit > 5) {
				throw new ServiceException(Constant.YOU_LIMIT_FOR_TALKING_THE_BOOKS_HAS_EXCEEDED);
			}
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_CALCULATE, e);
		}

	}

}
