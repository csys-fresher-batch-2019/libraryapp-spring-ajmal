package com.chainsys.libraryapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.BookDetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class ProductController {
	BookDetailsService ob = new BookDetailsService();

	@PostMapping("/AddBook")
	public void addBooks(@RequestParam("bookname") String bookname, @RequestParam("bookauthor") String bookauthor,
			@RequestParam("bookcategory") String bookcategory, @RequestParam("bookpages") int bookpages,
			@RequestParam("bookprice") int bookprice, @RequestParam("bookcopies") int bookcopies,
			@RequestParam("bookedition") int bookedition, @RequestParam("publisheddate") String publisheddate) {
		BookDetails obj = new BookDetails();
		obj.setBookName(bookname);
		obj.setBookAutherName(bookauthor);
		obj.setBookCategory(bookcategory);
		obj.setBookCopies(bookcopies);
		obj.setBookEdition(bookedition);
		obj.setBookPages(bookpages);
		obj.setBookPrice(bookprice);
		LocalDate db = LocalDate.parse(publisheddate);
		obj.setBookPublishedDate(db);
		try {
			ob.addNewBook(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GetMapping("/DisplayAllBooks")
	public List<BookDetails> displayAllBooks() throws Exception {
		List<BookDetails> obj = new ArrayList<BookDetails>();
		obj = ob.displayAllBooks();
		return obj;

	}

}
