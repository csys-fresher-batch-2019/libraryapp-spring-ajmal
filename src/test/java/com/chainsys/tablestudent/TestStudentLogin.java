package com.chainsys.tablestudent;

import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.libraryapp.service.StudentDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestStudentLogin {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
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
