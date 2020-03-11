package com.chainsys.tablebook;

import java.util.ArrayList;

import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestDisplayAllBooks {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		BookDetailsService ob = new BookDetailsService();
		ArrayList<BookDetails> out = new ArrayList<BookDetails>();
		out = ob.displayAllBooks();
		logger.info("All Books Details");
		for (BookDetails details : out) {
			logger.info(details);
		}

	}

}
