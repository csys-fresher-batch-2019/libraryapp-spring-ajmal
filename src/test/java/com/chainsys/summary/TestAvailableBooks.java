package com.chainsys.summary;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.BookService;
import com.chainsys.libraryapp.service.SummaryService;

public class TestAvailableBooks {
	private final static Logger logger = LoggerFactory.getLogger(TestAvailableBooks.class);

	public static void main(String[] args) throws Exception {

		SummaryService ob = new SummaryService();
		BookService obj = new BookService();
		Book out = new Book();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter the bookId to be found available : ");
		// System.out.print("Enter the bookId to be found available : ");
		int bookId = sc.nextInt();
		Integer remaining = null;
		out = obj.displayBook(bookId);
		logger.info("", out);
		// System.out.println(out);
		remaining = ob.noOfBooksAvailable(bookId);
		// System.out.println("Available copies = " + remaining);
		logger.info("Available copies = " + remaining);
		sc.close();
	}

}
