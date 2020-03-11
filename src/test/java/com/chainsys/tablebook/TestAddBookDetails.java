package com.chainsys.tablebook;

import java.sql.Date;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;

public class TestAddBookDetails {
	private final static Logger logger = LoggerFactory.getLogger(TestAddBookDetails.class);

	public static void main(String[] args) throws Exception {
		BookDetailsService obj = new BookDetailsService();

		logger.debug("Entre values \nBook Name :");
		Scanner sc = new Scanner(System.in);
		String bookName = sc.nextLine();
		System.out.print("Category : ");
		String bookCategory = sc.nextLine();
		logger.debug("Author Name : ");
		String bookAuthor = sc.nextLine();
		logger.debug("Edition : ");
		int bookEdition = sc.nextInt();
		logger.debug("Price of the book : ");
		int bookPrice = sc.nextInt();
		logger.debug("Copies : ");
		int bookCopies = sc.nextInt();
		logger.debug("Pages of book : ");
		int bookPages = sc.nextInt();
		sc.nextLine();
		logger.debug("Purchashed Date : ");
		String bookPublishedDate = sc.next();
		Date date = Date.valueOf(bookPublishedDate);

		BookDetails ob = new BookDetails();
		ob.setBookName(bookName);
		ob.setBookCategory(bookCategory);
		ob.setBookAutherName(bookAuthor);
		ob.setBookEdition(bookEdition);
		ob.setBookPages(bookPages);
		ob.setBookCopies(bookCopies);
		ob.setBookPrice(bookPrice);
		ob.setBookPublishedDate(date.toLocalDate());

		obj.addNewBook(ob);
		logger.info("Added New Book");
		sc.close();

	}

}
