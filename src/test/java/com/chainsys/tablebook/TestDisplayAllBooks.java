package com.chainsys.tablebook;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.BookService;

public class TestDisplayAllBooks {
	private final static Logger logger = LoggerFactory.getLogger(TestDisplayAllBooks.class);

	public static void main(String[] args) throws Exception {
		BookService ob = new BookService();
		List<Book> out = new ArrayList<Book>();
		out = ob.displayAllBooks();
		logger.info("All Books Details");
		for (Book details : out) {
			logger.info("", details);
		}

	}

}
