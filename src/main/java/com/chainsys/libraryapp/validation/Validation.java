package com.chainsys.libraryapp.validation;

import com.chainsys.libraryapp.dao.BookDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.dao.StudentDAO;
import com.chainsys.libraryapp.exception.ValidationException;

public class Validation {

	private static BookDAO bookDetailsDAO = DAOFactory.getBookDAO();
	private static StudentDAO studentDetailsDAO = DAOFactory.getStudentDAO();

	/**
	 * if invalid bookId throw exception
	 * 
	 * @param bookId
	 * @throws ValidationException
	 */
	public static void checkBookId(int bookId) throws ValidationException {
		Integer cont = bookDetailsDAO.checkBookId(bookId);
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
		Integer cont = studentDetailsDAO.checkStudentId(studentId);
		if (cont == null) {
			throw new ValidationException("Invalid Student Id");
		}
	}

}
