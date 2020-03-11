package com.chainsys.summary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestEntryOfBook {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		SummaryDetailsService ob = new SummaryDetailsService();
		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter Book ID : ");
		logger.debug("Enter Book ID : ");
		int bookId = sc.nextInt();
//		System.out.print("Enter Student ID : ");
		logger.debug("Enter Student ID : ");
		int studentId = sc.nextInt();
		ob.addNewEntry(studentId, bookId);
//		System.out.println("Thanks for talking the book");
		logger.info("Thanks for talking the book");
		sc.close();

	}

}
