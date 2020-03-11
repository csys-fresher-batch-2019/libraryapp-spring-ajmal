package com.chainsys.tablebook;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestSearchByName {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		BookDetailsService ob = new BookDetailsService();
		ArrayList<BookDetails> list = new ArrayList<>();
		logger.debug("Enter the name to be searched : ");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.next();
		list = ob.searchByName(bookName);
		boolean result = false;
		for (BookDetails details : list) {
			result = true;
			logger.info(details);
		}
		if (!result) {

			logger.error("Enter The Correct Name of the Book to Found");
			TestSearchByName.main(null);
		}
		sc.close();

	}

}
