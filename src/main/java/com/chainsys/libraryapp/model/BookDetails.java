package com.chainsys.libraryapp.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetails {
	private int bookId;
	private String bookName;
	private String bookCategory;
	private String bookAutherName;
	private int bookEdition;
	private int bookPrice;
	private LocalDate bookPublishedDate;
	private int bookCopies;
	private int bookPages;
	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookName=" + bookName + ", bookCategory=" + bookCategory
				+ ", bookAutherName=" + bookAutherName + ", bookEdition=" + bookEdition + ", bookPrice=" + bookPrice
				+ ", bookPublishedDate=" + bookPublishedDate + ", NoOfCopies=" + bookCopies + ", bookpages=" + bookPages
				+ "]";
	}
	
	}
	
	
	

