package com.chainsys.summary;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.dto.StudentFineSummaryDTO;
import com.chainsys.libraryapp.service.SummaryService;

public class TestStudentFinedetails {
	private final static Logger logger = LoggerFactory.getLogger(TestStudentFinedetails.class);
	
	public static void main(String[] args) throws Exception {
		//LoggerUtil logger = LoggerUtil.getInstance();
		
		SummaryService ob = new SummaryService();
		Scanner sc = new Scanner(System.in);
		// To calculate the Total Fine amount of a student along with their not Returned
		// books
//		System.out.print("Enter the Student Id : ");
		logger.debug("Enter the Student Id : ");
		int studentId = sc.nextInt();
		int totalFineAmount = 0;
		String name = null;
		List<StudentFineSummaryDTO> out = ob.totalFineAmountOfStudent(studentId);
		for (StudentFineSummaryDTO details : out) {
			name = details.getStudentName();
			totalFineAmount = totalFineAmount + details.getFineAmount();
		}
		logger.info("StudentName : " + name);
		logger.info("Total Fine Amount : " + totalFineAmount);
//		System.out.println("StudentName : " + name);
//		System.out.println("Total Fine Amount : " + totalFineAmount);
		for (StudentFineSummaryDTO details : out) {
//			System.out.println(details);
			logger.info("",details);
		}
		sc.close();
	}

}
