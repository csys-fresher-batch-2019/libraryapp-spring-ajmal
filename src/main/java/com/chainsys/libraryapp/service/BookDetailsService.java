package com.chainsys.libraryapp.service;

import java.util.List;

import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.exception.ValidationException;
import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.util.Constant;
import com.chainsys.libraryapp.validation.Validation;

public class BookDetailsService {


	// private BookDetailsDAO bookDetailsDAO = new BookDetailsDAOImp();
	private BookDetailsDAO bookDetailsDAO = DAOFactory.getBookDetailDAO();

	public void addNewBook(BookDetails bookdetails) throws ServiceException {
		try {
			bookDetailsDAO.save(bookdetails);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_ADD_BOOK, e);
		}
	}

	public void updateBookCopies(int bookId, int bookCopies) throws ServiceException {
		try {
			Validation.checkBookId(bookId);
			bookDetailsDAO.updateBookCopies(bookId, bookCopies);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(Constant.UNABLE_TO_UPDATE, e);
		}
	}

	public BookDetails displayBook(int bookId) throws ServiceException {
		try {
			Validation.checkBookId(bookId);
			return bookDetailsDAO.findByBookId(bookId);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_DISPLAY, e);
		}

	}

	public List<BookDetails> displayAllBooks() throws ServiceException {
		try {
			return bookDetailsDAO.findAll();
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_DISPLAY, e);
		}
	}

	public List<BookDetails> searchByName(String bookName) throws ServiceException {
		try {
			return bookDetailsDAO.findByName(bookName);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_SEARCH, e);
		}

	}

}
