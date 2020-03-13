package com.chainsys.tablebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.BookService;

public class TestUpdateCopies {
	private final static Logger logger = LoggerFactory.getLogger(TestUpdateCopies.class);

	public static void main(String[] args) throws Exception {
		BookService obj = new BookService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter the Book Name : ");
		String bookName = sc.nextLine();
		List<Book> list = new ArrayList<>();
		list = obj.searchByName(bookName);
		for (Book details : list) {
			logger.info("",details);
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
