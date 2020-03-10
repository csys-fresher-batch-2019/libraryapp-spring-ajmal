package com.chainsys.libraryapp.service;

import java.util.ArrayList;

import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.exception.ValidationException;
import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.validation.Validation;

public class BookDetailsService {

	// private BookDetailsDAO bookDetailsDAO = new BookDetailsDAOImp();
	private BookDetailsDAO bookDetailsDAO=DAOFactory.getBookDetailDAO();
//	private Jdbi jdbi = Connectionutil.getJdbi();
//	private BookDetailsDAO bookDetailsDAO = jdbi.onDemand(BookDetailsDAO.class);

	public void addNewBook(BookDetails bookdetails) throws ServiceException {
		try {
			bookDetailsDAO.addNewBook(bookdetails);
		} catch (DbException e) {
			throw new ServiceException("Unable to Add Book", e);
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
			throw new ServiceException("Unable to Update", e);
		}
	}

	public BookDetails displayBook(int bookId) throws ServiceException {
		try {
			Validation.checkBookId(bookId);
			return bookDetailsDAO.displayBook(bookId);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException("Unable to Dispay", e);
		}

	}

	public ArrayList<BookDetails> displayAllBooks() throws ServiceException {
		try {
			return bookDetailsDAO.displayAllBooks();
		} catch (DbException e) {
			throw new ServiceException("Unable to Dispay", e);
		}
	}

	public ArrayList<BookDetails> searchByName(String bookName) throws ServiceException {
		try {
			return bookDetailsDAO.searchByName(bookName);
		} catch (DbException e) {
			throw new ServiceException("Unable to Search", e);
		}

	}

}
