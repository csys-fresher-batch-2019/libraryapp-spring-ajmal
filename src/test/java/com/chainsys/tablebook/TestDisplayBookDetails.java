package com.chainsys.tablebook;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.BookDetailsService;

public class TestDisplayBookDetails {
	private final static Logger logger = LoggerFactory.getLogger(TestDisplayBookDetails.class);

	public static void main(String[] args) throws Exception {
		BookDetailsService ob = new BookDetailsService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter the bookId : ");
		int bookId = sc.nextInt();
		Book out = new Book();
		out = ob.displayBook(bookId);
		if (out != null) {
			logger.info("",out);
		} else {
			logger.debug("No Book Found, Please Enter A valid BookId\n");
			TestDisplayBookDetails.main(args);
		}
		sc.close();
	}

}
