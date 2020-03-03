package com.chainsys.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.chainsys.libraryapp.service.SummaryDetailsService;

@SpringBootTest
public class LibraryappApplicationTests {

	@Test
	public void fineAmountTestWithoutFine() throws Exception {
		int studentId = 1001;
		int bookId = 121;
		int expected = 0;
		SummaryDetailsService ob = new SummaryDetailsService();
		int actual = ob.calculateFineAmount(studentId, bookId);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void fineAmountTestWithFine() throws Exception {
		int bookId = 101;
		int studentId = 1001;
		int expected = 622;
		SummaryDetailsService ob = new SummaryDetailsService();
		int actual = ob.calculateFineAmount(studentId, bookId);
		Assert.assertEquals(expected, actual);
	}
	
	//@Test
	//public void 
}
