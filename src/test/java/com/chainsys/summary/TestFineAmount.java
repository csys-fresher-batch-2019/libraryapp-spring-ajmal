package com.chainsys.summary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestFineAmount {

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
//		System.out.println("Fine Amount = " + fineAmount);
		logger.info("Fine Amount = " + fineAmount);
		sc.close();
	}

}
