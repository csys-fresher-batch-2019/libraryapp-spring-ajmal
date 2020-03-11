package com.chainsys.summary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestRenewalOfABook {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		SummaryDetailsService ob = new SummaryDetailsService();
		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter the BookId : ");
		logger.debug("Enter the BookId : ");
		int bookId = sc.nextInt();
//		System.out.print("Enter the StudentId : ");
		logger.debug("Enter the StudentId : ");
		int studentId = sc.nextInt();
		Integer fineAmount = ob.calculateFineAmount(studentId, bookId);
		logger.debug("Fine Amount = " + fineAmount + "\nDo you want to Renual the book (Y/N) - ");
//		System.out.println("Fine Amount = " + fineAmount + "\nDo you want to Renual the book (Y/N) - ");
		String output = sc.next();
		if (output.equalsIgnoreCase("Y")) {
			ob.updateReturnRecord(studentId, bookId, fineAmount);
			ob.addNewEntry(studentId, bookId);
			logger.info("Book Renawed");
//			System.out.println("Book Renawed");
		} else {
			logger.info("ThankYou...!");
//			System.out.println("ThankYou...!");
		}

		sc.close();

	}

}
