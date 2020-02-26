package com.chainsys.libraryapp.service;

import java.util.ArrayList;

import org.jdbi.v3.core.Jdbi;

import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.util.Connectionutil;

public class BookDetailsService {

	//private BookDetailsDAO bookDetailsDAO = new BookDetailsDAOImp();
	private Jdbi jdbi = Connectionutil.getJdbi();
	private BookDetailsDAO bookDetailsDAO= jdbi.onDemand(BookDetailsDAO.class);
	
	public void addNewBook(BookDetails bookdetails) throws Exception {
		bookDetailsDAO.addNewBook(bookdetails);
	}

	public void updateBookCopies(int bookId,int bookCopies) throws Exception {
		Integer cont = bookDetailsDAO.findByBookId(bookId);
		if (cont == null) {
			throw new Exception("Invalid Book Id");
		}
		bookDetailsDAO.updateBookCopies(bookId, bookCopies);
	}

	public BookDetails displayBook(int bookId) throws Exception {
		Integer cont = bookDetailsDAO.findByBookId(bookId);
		if (cont == null) {
			throw new Exception("Invalid Book Id");
		}
		return bookDetailsDAO.displayBook(bookId);
	}

	public ArrayList<BookDetails> displayAllBooks() throws Exception {
		return bookDetailsDAO.displayAllBooks();
	}
	public ArrayList<BookDetails> searchByName(String bookName) throws Exception{
		return bookDetailsDAO.searchByName(bookName);
		
	}
	
}
