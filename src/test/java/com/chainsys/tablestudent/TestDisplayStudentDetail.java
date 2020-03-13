package com.chainsys.tablestudent;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Student;
import com.chainsys.libraryapp.service.StudentService;

public class TestDisplayStudentDetail {
	private final static Logger logger = LoggerFactory.getLogger(TestDisplayStudentDetail.class);

	public static void main(String[] args) throws Exception {
		StudentService ob = new StudentService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter Student Id - ");
		int studentId = sc.nextInt();
		Student obj = new Student();
		obj = ob.displayStudentDetail(studentId);
		logger.info("", obj);
		sc.close();
	}

}
