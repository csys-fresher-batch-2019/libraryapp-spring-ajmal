package com.chainsys.libraryapp.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.jdbi.v3.core.Jdbi;

import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.dao.StudentDetailsDAO;
import com.chainsys.libraryapp.dao.SummaryDetailsDAO;
import com.chainsys.libraryapp.model.StudentFineSummaryDetails;
import com.chainsys.libraryapp.model.SummaryDetailsDueDate;
import com.chainsys.libraryapp.model.SummaryDetailsStudentDetails;
import com.chainsys.libraryapp.util.Connectionutil;

public class SummaryDetailsService {
	static Jdbi jdbi = Connectionutil.getJdbi();
	static SummaryDetailsDAO summaryDetailsDAO = jdbi.onDemand(SummaryDetailsDAO.class);
	static BookDetailsDAO bookDetailsDAO = jdbi.onDemand(BookDetailsDAO.class);
	static StudentDetailsDAO studentDetailsDAO = jdbi.onDemand(StudentDetailsDAO.class);
	
	// private SummaryDetailsDAO summaryDetailsDAO=new SummaryDetailsDAOImp();

	public void addNewEntry(int studentId, int bookId) throws Exception {

		Integer cont = bookDetailsDAO.findByBookId(bookId);

		// if invalid bookId throw exception
		if (cont == null) {
			throw new Exception("Invalid Book Id");
		}
		Integer contt = studentDetailsDAO.findByStudentId(studentId);
		if (contt == null) {
			throw new Exception("Invalid Student Id");
		}
			
		Integer bookTaken= summaryDetailsDAO.bookTaken(studentId, bookId);
		
		if (bookTaken==null ) {
			 summaryDetailsDAO.addNewEntry(studentId, bookId);
		}
		else {
			throw new Exception("You have Already taken the book");
		}
		
	}

	public Integer calculateFineAmount(int studentId, int bookId) throws Exception {
		Integer cont = bookDetailsDAO.findByBookId(bookId);
		if (cont == null) {
			throw new Exception("Invalid Book Id");
		}
		Integer contt = studentDetailsDAO.findByStudentId(studentId);
		if (contt == null) {
			throw new Exception("Invalid Student Id");
		}
		//bookTaken(studentId, bookId);
		Integer fine = 0;
		//if (bookTaken) {
			//throw new Exception("You have not taken book");
		//}
		LocalDate dueDate = summaryDetailsDAO.returnDueDate(studentId, bookId);
		if(dueDate ==null)
		{
			throw new Exception("You have not taken the book");
		}
		LocalDate returnedDate = LocalDate.now();
		if (returnedDate.isAfter(dueDate)) {
			int diffInDays = (int) ChronoUnit.DAYS.between(dueDate, returnedDate);
			fine = diffInDays * 2;

		} else {
			// System.out.println("No Due Pending");
			fine = 0;
		}
		return fine;
	}

	public void updateReturnRecord(int studentId, int bookId, Integer fineAmount) throws Exception {
		summaryDetailsDAO.updateReturnRecord(studentId, bookId, fineAmount);
	}

	public ArrayList<SummaryDetailsDueDate> unReturnedBookDetails(int bookId) throws Exception {
		Integer cont = bookDetailsDAO.findByBookId(bookId);
		if (cont == null) {
			throw new Exception("Invalid Book Id");
		}
		return summaryDetailsDAO.unReturnedBookDetails(bookId);
	}

	public int totalFineAmount() throws Exception {
		return summaryDetailsDAO.totalFineAmount();
	}

	public ArrayList<SummaryDetailsStudentDetails> unReturnedStudentBookDetails(int studentId) throws Exception {
		Integer std=studentDetailsDAO.findByStudentId(studentId);
		if(std==null)
		{
			throw new Exception("Invalid Student Id");
		}
		return summaryDetailsDAO.unReturnedStudentBookDetails(studentId);
	}

	public void bookTaken(int studentId, int bookId) throws Exception {
		Integer bookTaken = summaryDetailsDAO.bookTaken(studentId, bookId);
		if(bookTaken !=null)
		{
			throw new Exception("You have not taken the book");
		}
		//return bookTaken != null;
	}

	public ArrayList<StudentFineSummaryDetails> totalFineAmountOfStudent(int studentId) throws Exception {
		Integer std=studentDetailsDAO.findByStudentId(studentId);
		LocalDate returnedDate=LocalDate.now();
		if(std==null)
		{
			throw new Exception("Invalid Student Id");
		}
		ArrayList<StudentFineSummaryDetails> out=summaryDetailsDAO.totalFineAmountOfStudent(studentId);
		for(StudentFineSummaryDetails details:out)
		{
			if (returnedDate.isAfter(details.getDueDate())) {
				int diffInDays = (int) ChronoUnit.DAYS.between(details.getDueDate(), returnedDate);
				int fineAmount = diffInDays * 2;
				details.setFineAmount(fineAmount);

			} else {
				// System.out.println("No Due Pending");
				
			}
		}
		//return summaryDetailsDAO.totalFineAmountOfStudent(studentId);
		return out;
	}

	public Integer noOfBooksAvailable(int bookId) throws Exception {
		Integer cont = bookDetailsDAO.findByBookId(bookId);
		if (cont == null) {
			throw new Exception("Invalid Book Id");
		}
		return summaryDetailsDAO.noOfBooksAvailable(bookId);
	}

	public void limitForStudent(int studentId) throws Exception {
		Integer std=studentDetailsDAO.findByStudentId(studentId);
		if(std==null)
		{
			throw new Exception("Invalid Student Id");
		}
		int limit = summaryDetailsDAO.limitForStudent(studentId);
		if(limit>5)
		{
			throw new Exception("You limit for talking the books has Exceeded");
		}
		
	}

}
