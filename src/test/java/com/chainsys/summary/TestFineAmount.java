package com.chainsys.summary;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestFineAmount {
	private final static Logger logger = LoggerFactory.getLogger(TestFineAmount.class);

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob = new SummaryDetailsService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter the BookId : ");
//		System.out.print("Enter the BookId : ");
		int bookId = sc.nextInt();
		logger.debug("Enter the StudentId : ");
//		System.out.print("Enter the StudentId : ");
		int studentId = sc.nextInt();
		Integer fineAmount = ob.calculateFineAmount(studentId, bookId);
//		System.out.println("Fine Amount = " + fineAmount);
		logger.info("Fine Amount = " + fineAmount);
		sc.close();
	}

}
