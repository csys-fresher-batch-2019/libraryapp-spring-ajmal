package com.chainsys.summary;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.dto.SummaryStudentDetails;
import com.chainsys.libraryapp.service.SummaryService;

public abstract class TestUnReturnedStudentBookDetails {
	private final static Logger logger = LoggerFactory.getLogger(TestUnReturnedStudentBookDetails.class);

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		SummaryService ob = new SummaryService();
		logger.debug("Enter the Student id : ");
//		System.out.print("Enter the Student id : ");
		int studentId = sc.nextInt();

		List<SummaryStudentDetails> out = null;
		out = ob.unReturnedStudentBookDetails(studentId);
		if (out != null) {
			for (SummaryStudentDetails details : out) {
				logger.info("",details);
//				System.out.println(details);
			}
		} else {
			logger.error("This Student has not taken any book");
//			System.out.println("This Student has not taken any book");
		}
		sc.close();
	}

}
