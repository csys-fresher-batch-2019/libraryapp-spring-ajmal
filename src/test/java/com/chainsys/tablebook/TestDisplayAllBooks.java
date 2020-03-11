package com.chainsys.tablebook;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;

public class TestDisplayAllBooks {
	private final static Logger logger = LoggerFactory.getLogger(TestDisplayAllBooks.class);

	public static void main(String[] args) throws Exception {
		BookDetailsService ob = new BookDetailsService();
		List<BookDetails> out = new ArrayList<BookDetails>();
		out = ob.displayAllBooks();
		logger.info("All Books Details");
		for (BookDetails details : out) {
			logger.info("", details);
		}

	}

}
