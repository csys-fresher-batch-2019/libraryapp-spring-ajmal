package com.chainsys.tablebook;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestUpdateCopies {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		BookDetailsService obj = new BookDetailsService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter the Book Name : ");
		String bookName = sc.nextLine();
		ArrayList<BookDetails> list = new ArrayList<>();
		list = obj.searchByName(bookName);
		for (BookDetails details : list) {
			logger.info(details);
		}
		logger.debug("Enter the BookId to Update copies : ");
		int bookId = sc.nextInt();
		logger.debug("Enter the Copies to be Added : ");
		int bookCopies = sc.nextInt();
		obj.updateBookCopies(bookId, bookCopies);
		logger.info("Updated");
		sc.close();

	}

}
