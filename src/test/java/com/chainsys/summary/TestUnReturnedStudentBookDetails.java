package com.chainsys.summary;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.model.SummaryDetailsStudentDetails;
import com.chainsys.libraryapp.service.SummaryDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public abstract class TestUnReturnedStudentBookDetails {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		Scanner sc = new Scanner(System.in);
		SummaryDetailsService ob = new SummaryDetailsService();
		logger.debug("Enter the Student id : ");
//		System.out.print("Enter the Student id : ");
		int studentId = sc.nextInt();

		ArrayList<SummaryDetailsStudentDetails> out = null;
		out = ob.unReturnedStudentBookDetails(studentId);
		if (out != null) {
			for (SummaryDetailsStudentDetails details : out) {
				logger.info(details);
//				System.out.println(details);
			}
		} else {
			logger.error("This Student has not taken any book");
//			System.out.println("This Student has not taken any book");
		}
		sc.close();
	}

}
