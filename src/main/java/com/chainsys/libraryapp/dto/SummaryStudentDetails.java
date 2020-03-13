package com.chainsys.libraryapp.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class SummaryStudentDetails {
	private String studentName;
	private int bookId;
	private String bookName;
	private LocalDate issueDate;
	private LocalDate duedate;
	@Override
	public String toString() {
		return "SummaryDetailsStudentDetails [studentName=" + studentName + ", bookId=" + bookId + ", bookName="
				+ bookName + ", issueDate=" + issueDate + ", duedate=" + duedate + "]";
	}

}
