package com.chainsys.tablebook;

import java.util.Scanner;

import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestDisplayBookDetails {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		BookDetailsService ob = new BookDetailsService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter the bookId : ");
		int bookId = sc.nextInt();
		BookDetails out = new BookDetails();
		out = ob.displayBook(bookId);
		if (out != null) {
			logger.info(out);
		} else {
			logger.debug("No Book Found, Please Enter A valid BookId\n");
			TestDisplayBookDetails.main(args);
		}
		sc.close();
	}

}
