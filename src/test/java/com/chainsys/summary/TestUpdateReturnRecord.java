package com.chainsys.summary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestUpdateReturnRecord {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		SummaryDetailsService ob = new SummaryDetailsService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter the BookId : ");
//		System.out.print("Enter the BookId : ");
		int bookId = sc.nextInt();
		logger.debug("Enter the StudentId : ");
//		System.out.print("Enter the StudentId : ");
		int studentId = sc.nextInt();
		Integer fineAmount = ob.calculateFineAmount(studentId, bookId);
		if (fineAmount != null) {
			logger.debug("Fine Amount = " + fineAmount + "\nDo you want to return (Y/N) - ");
//			System.out.println("Fine Amount = " + fineAmount + "\nDo you want to return (Y/N) - ");
			String output = sc.next();
			sc.close();
			if (output.equalsIgnoreCase("Y")) {
				ob.updateReturnRecord(studentId, bookId, fineAmount);
				logger.info("Book Returned");
//				System.out.println("Book Returned");
			} else {
				logger.info("ThankYou...!");
//				System.out.println("ThankYou...!");
			}
		}
		sc.close();

	}

}
