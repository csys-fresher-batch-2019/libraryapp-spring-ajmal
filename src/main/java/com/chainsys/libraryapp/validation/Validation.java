package com.chainsys.libraryapp.validation;

import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.dao.StudentDetailsDAO;
import com.chainsys.libraryapp.exception.ValidationException;

public class Validation {

	private static BookDetailsDAO bookDetailsDAO = DAOFactory.getBookDetailDAO();
	private static StudentDetailsDAO studentDetailsDAO = DAOFactory.getStudentDetailDAO();

	/**
	 * if invalid bookId throw exception
	 * 
	 * @param bookId
	 * @throws ValidationException
	 */
	public static void checkBookId(int bookId) throws ValidationException {
		Integer cont = bookDetailsDAO.findByBookId(bookId);
		if (cont == null) {
			throw new ValidationException("Invalid Book Id");
		}
	}

	/**
	 * if invalid StudentId throw exception
	 * 
	 * @param studentId
	 * @throws ValidationException
	 */
	public static void checkStudentId(int studentId) throws ValidationException {
		Integer cont = studentDetailsDAO.findByStudentId(studentId);
		if (cont == null) {
			throw new ValidationException("Invalid Student Id");
		}
	}

}
