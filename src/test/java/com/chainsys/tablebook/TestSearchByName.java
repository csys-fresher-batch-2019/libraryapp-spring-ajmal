package com.chainsys.tablebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.BookDetailsService;

public class TestSearchByName {
	private final static Logger logger = LoggerFactory.getLogger(TestSearchByName.class);

	public static void main(String[] args) throws Exception {
		BookDetailsService ob = new BookDetailsService();
		List<Book> list = new ArrayList<>();
		logger.debug("Enter the name to be searched : ");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next();
		list = ob.searchByName(bookName);
		boolean result = false;
		for (Book details : list) {
			result = true;
			logger.info("",details);
		}
		if (!result) {

			logger.error("Enter The Correct Name of the Book to Found");
			TestSearchByName.main(null);
		}
		sc.close();

	}

}
