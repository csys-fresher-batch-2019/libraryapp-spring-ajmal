package com.chainsys.test;

import java.time.LocalDate;

import org.jdbi.v3.core.Jdbi;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chainsys.libraryapp.dao.BookDAO;
import com.chainsys.libraryapp.dao.StudentDAO;
import com.chainsys.libraryapp.dao.SummaryDAO;
import com.chainsys.libraryapp.model.Book;
import com.chainsys.libraryapp.service.SummaryService;
import com.chainsys.libraryapp.util.Connectionutil;

import static org.junit.Assert.*;

@SpringBootTest
public class LibraryappApplicationTests {
	SummaryService ob = new SummaryService();
	static Jdbi jdbi = Connectionutil.getJdbi();
	StudentDAO obj = jdbi.onDemand(StudentDAO.class);
	BookDAO obj1 = jdbi.onDemand(BookDAO.class);
	SummaryDAO summaryDetailsDAO = jdbi.onDemand(SummaryDAO.class);

	@Test
	@Ignore
	public void fineAmountTestWithoutFine() throws Exception {
		int studentId = 1001;
		int bookId = 121;
		int expected = 0;
		SummaryService ob = new SummaryService();
		int actual = ob.calculateFineAmount(studentId, bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void fineAmountTestWithFine() throws Exception {
		int bookId = 101;
		int studentId = 1001;
		int expected = 624;
		SummaryService ob = new SummaryService();
		int actual = ob.calculateFineAmount(studentId, bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void checkStudentTest() {
		int studentId = 1001;
		int expected = 1;
		int actual = obj.checkStudentId(studentId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void checkStudent1Test() {
		int studentId = 1121;
		Integer expected = null;
		Integer actual = obj.checkStudentId(studentId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void checkBookTest() {
		int bookId = 101;
		int expected = 1;
		int actual = obj1.checkBookId(bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	@Ignore
	public void checkBook1Test() {
		int bookId = 1231;
		Integer expected = null;
		Integer actual = obj1.checkBookId(bookId);
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
		Book expected = new Book();
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
		Book bookdetail = obj1.findByBookId(bookId);
		Assert.assertEquals(expected, bookdetail);
	}

}
