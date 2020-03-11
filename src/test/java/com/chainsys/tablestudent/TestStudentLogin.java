package com.chainsys.tablestudent;

import java.time.LocalDate;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.service.StudentDetailsService;

public class TestStudentLogin {
	private final static Logger logger = LoggerFactory.getLogger(TestStudentLogin.class);

	public static void main(String[] args) throws Exception {
		StudentDetailsService ob = new StudentDetailsService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter the Student Id");
		int studentId = sc.nextInt();
		logger.debug("Enter the Student DOB");
		String date = sc.next();
		LocalDate dateOfBirth = LocalDate.parse(date);
		Boolean out = ob.studentLogin(studentId, dateOfBirth);
		if (out) {
			logger.info("LoggedIn");
		}
		sc.close();

	}

}
