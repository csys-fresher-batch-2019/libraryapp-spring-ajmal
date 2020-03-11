package com.chainsys.summary;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestCheckLimitOfStudent {
	private final static Logger logger = LoggerFactory.getLogger(TestCheckLimitOfStudent.class);
	public static void main(String[] args) throws Exception {
		
		SummaryDetailsService ob = new SummaryDetailsService();
//      SummaryDetailsDAOImp ob= new SummaryDetailsDAOImp();
//		System.out.print("Enter the Student Id to check : ");
		logger.debug("Enter the Student Id to check : ");
		Scanner sc = new Scanner(System.in);
		int studentId = sc.nextInt();
		ob.limitForStudent(studentId);
//		System.out.println("Your limt has not exceeds");
		logger.info("Your limt has not exceeds");
		sc.close();
	}

}
