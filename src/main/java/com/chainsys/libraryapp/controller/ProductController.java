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

import com.chainsys.libraryapp.model.Book;
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
		Book obj = new Book();
		obj.setName(bookname);
		obj.setAuthorName(bookauthor);
		obj.setCategory(bookcategory);
		obj.setCopies(bookcopies);
		obj.setEdition(bookedition);
		obj.setPages(bookpages);
		obj.setPrice(bookprice);
		LocalDate db = LocalDate.parse(publisheddate);
		obj.setPublishedDate(db);
		try {
			ob.addNewBook(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GetMapping("/DisplayAllBooks")
	public List<Book> displayAllBooks() throws Exception {
		List<Book> obj = new ArrayList<Book>();
		obj = ob.displayAllBooks();
		return obj;

	}

}
