package com.chainsys.libraryapp.validation;

import com.chainsys.libraryapp.dao.BookDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.dao.StudentDAO;
import com.chainsys.libraryapp.exception.ValidationException;
import com.chainsys.libraryapp.util.Constant;
import com.chainsys.libraryapp.util.StringUtil;

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
		Integer cont = bookDetailsDAO.exist(bookId);
		if (cont == null) {
			throw new ValidationException(Constant.INVALID_BOOK_ID);
		}
	}

	/**
	 * if invalid StudentId throw exception
	 * 
	 * @param studentId
	 * @throws ValidationException
	 */
	public static void checkStudentId(int studentId) throws ValidationException {
		Integer cont = studentDetailsDAO.exist(studentId);
		if (cont == null) {
			throw new ValidationException(Constant.INVALID_STUDENT_ID);
		}
	}

	public static void validationSearch(String mailId, String password) throws ValidationException {
		StringUtil.rejectIfInvalid(mailId, Constant.INVALID_MAIL_ID);
		StringUtil.rejectIfInvalid(password, Constant.INVALID_PASSWORD);
	}

}
