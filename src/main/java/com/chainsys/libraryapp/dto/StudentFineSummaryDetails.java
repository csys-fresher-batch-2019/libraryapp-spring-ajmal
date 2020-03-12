package com.chainsys.libraryapp.dto;

import java.time.LocalDate;

public class StudentFineSummaryDetails {

	private String studentName;
	private int bookId;
	private String bookName;
	private int fineAmount;
	private String bookCategory;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private int totalFineAmount;

	public int getTotalFineAmount() {
		return totalFineAmount;
	}

	public void setTotalFineAmount(int totalFineAmount) {
		this.totalFineAmount = totalFineAmount;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "StudentFineSummaryDetails [ bookId=" + bookId + ", bookName=" + bookName + ", fineAmount=" + fineAmount
				+ ", bookCategory=" + bookCategory + ", issueDate=" + issueDate + ", dueDate=" + dueDate + "]";
	}
}
