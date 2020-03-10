package com.chainsys.test;

import java.time.LocalDate;

import org.jdbi.v3.core.Jdbi;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chainsys.libraryapp.dao.BookDetailsDAO;
import com.chainsys.libraryapp.dao.StudentDetailsDAO;
import com.chainsys.libraryapp.dao.SummaryDetailsDAO;
import com.chainsys.libraryapp.model.BookDetails;
import com.chainsys.libraryapp.service.SummaryDetailsService;
import com.chainsys.libraryapp.util.Connectionutil;

import static org.junit.Assert.*;

@SpringBootTest
public class LibraryappApplicationTests {
	SummaryDetailsService ob = new SummaryDetailsService();
	static Jdbi jdbi = Connectionutil.getJdbi();
	StudentDetailsDAO obj = jdbi.onDemand(StudentDetailsDAO.class);
	BookDetailsDAO obj1 = jdbi.onDemand(BookDetailsDAO.class);
	SummaryDetailsDAO summaryDetailsDAO = jdbi.onDemand(SummaryDetailsDAO.class);

	@Test
	@Ignore
	public void fineAmountTestWithoutFine() throws Exception {
		int studentId = 1001;
		int bookId = 121;
		int expected = 0;
		SummaryDetailsService ob = new SummaryDetailsService();
		int actual = ob.calculateFineAmount(studentId, bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void fineAmountTestWithFine() throws Exception {
		int bookId = 101;
		int studentId = 1001;
		int expected = 624;
		SummaryDetailsService ob = new SummaryDetailsService();
		int actual = ob.calculateFineAmount(studentId, bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void checkStudentTest() {
		int studentId = 1001;
		int expected = 1;
		int actual = obj.findByStudentId(studentId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void checkStudent1Test() {
		int studentId = 1121;
		Integer expected = null;
		Integer actual = obj.findByStudentId(studentId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void checkBookTest() {
		int bookId = 101;
		int expected = 1;
		int actual = obj1.findByBookId(bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void checkBook1Test() {
		int bookId = 1231;
		Integer expected = null;
		Integer actual = obj1.findByBookId(bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void bookTakenTest() throws Exception {
		int bookId = 101;
		int studentId = 1001;
		Integer expected = 1;
		Integer actual = summaryDetailsDAO.bookTaken(studentId, bookId);
		assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void bookTaken1Test() throws Exception {
		int bookId = 101;
		int studentId = 1003;
		Integer expected = null;
		Integer actual = summaryDetailsDAO.bookTaken(studentId, bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void bookCountTest() throws Exception {
		int bookId = 101;
		Integer expected = 41;
		Integer actual = ob.noOfBooksAvailable(bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void searchBookTest() throws Exception {
		int bookId = 101;
		BookDetails expected = new BookDetails();
		expected.setBookId(bookId);
		expected.setBookName("Electronic Devices and Circuits");
		expected.setBookCategory("Electronics");
		expected.setBookAutherName("Boylested,Robert.L");
		expected.setBookEdition(1);
		expected.setBookCopies(42);
		String date = "1998-02-15";
		expected.setBookPublishedDate(LocalDate.parse(date));
		expected.setBookPrice(200);
		expected.setBookPages(342);
		BookDetails bookdetail = obj1.displayBook(bookId);
		Assert.assertEquals(expected, bookdetail);
	}

}