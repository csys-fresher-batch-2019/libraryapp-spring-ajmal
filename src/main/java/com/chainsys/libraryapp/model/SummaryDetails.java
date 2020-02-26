package com.chainsys.libraryapp.model;

import java.time.LocalDate;

import lombok.Data;
@Data
public class SummaryDetails {
	private int bookCount;
	private int bookId;
	private int studentId;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private LocalDate returnedDate;
	private int fineAmount;
	private int activeStatus;
}
 