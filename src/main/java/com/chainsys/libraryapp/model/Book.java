package com.chainsys.libraryapp.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private int id;
	private String name;
	private String category;
	private String authorName;
	private int edition;
	private int price;
	private LocalDate publishedDate;
	private int copies;
	private int pages;
	@Override
	public String toString() {
		return "BookDetails [bookId=" + id + ", bookName=" + name + ", bookCategory=" + category
				+ ", bookAutherName=" + authorName + ", bookEdition=" + edition + ", bookPrice=" + price
				+ ", bookPublishedDate=" + publishedDate + ", NoOfCopies=" + copies + ", bookpages=" + pages
				+ "]";
	}
	
	}
	
	
	

