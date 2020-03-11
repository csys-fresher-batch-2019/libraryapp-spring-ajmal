package com.chainsys.tablestudent;

import java.util.Scanner;

import com.chainsys.libraryapp.model.StudentDetails;
import com.chainsys.libraryapp.service.StudentDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestDisplayStudentDetail {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		StudentDetailsService ob = new StudentDetailsService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter Student Id - ");
		int studentId = sc.nextInt();
		StudentDetails obj = new StudentDetails();
		obj = ob.displayStudentDetail(studentId);
		logger.info(obj);
		sc.close();
	}

}
