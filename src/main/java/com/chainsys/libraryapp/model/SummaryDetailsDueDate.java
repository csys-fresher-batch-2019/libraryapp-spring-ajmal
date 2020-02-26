package com.chainsys.libraryapp.model;

import java.time.LocalDate;

import lombok.Data;
@Data
public class SummaryDetailsDueDate {
	private int bookId;
	private int studentId;
	private String studentName;
	private String studentDept;
	private String bookName;
	private long mobileNumber;
	private LocalDate issueDate;
	private LocalDate dueDate;
@Override
public String toString() {
	return "SummaryDetailsDueDate [bookId=" + bookId + ", studentId=" + studentId + ", studentName=" + studentName
			+ ", studentDept=" + studentDept + ", bookName=" + bookName + ", mobileNumber=" + mobileNumber
			+ ", issueDate=" + issueDate + ", dueDate=" + dueDate + "]";
}


}
