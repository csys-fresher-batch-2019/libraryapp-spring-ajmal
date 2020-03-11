package com.chainsys.summary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.SummaryDetailsDueDate;
import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestUnReturnedBookDetails {
	private final static Logger logger = LoggerFactory.getLogger(TestUnReturnedBookDetails.class);

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob = new SummaryDetailsService();
		logger.debug("Enter the BookId to be found :");
//		System.out.print("Enter the BookId to be found :");
		Scanner sc = new Scanner(System.in);
		int bookId = sc.nextInt();
		List<SummaryDetailsDueDate> out = new ArrayList<>();
		out = ob.unReturnedBookDetails(bookId);
		if (out.isEmpty()) {
			logger.info("No Book has been Taken");
//			System.out.println("No Book has been Taken");
		} else {
			for (SummaryDetailsDueDate details : out) {
//				System.out.println(details);
				logger.error("",details);
			}
		}
		sc.close();
	}

}
