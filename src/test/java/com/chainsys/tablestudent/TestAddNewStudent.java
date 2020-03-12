package com.chainsys.tablestudent;

import java.sql.Date;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Student;
import com.chainsys.libraryapp.service.StudentDetailsService;

public class TestAddNewStudent {
	private final static Logger logger = LoggerFactory.getLogger(TestAddNewStudent.class);

	public static void main(String[] args) throws Exception {
		logger.debug("Entre values \nStudent Name :");
		Scanner sc = new Scanner(System.in);
		String studentName = sc.nextLine();
		logger.debug("Department : ");
		String studentDepartment = sc.nextLine();
		logger.debug("Date of Birth : ");
		String dateOfBirth = sc.nextLine();
		logger.debug("Mail Id :");
		String studentMailId = sc.nextLine();
		logger.debug("Mobile Number :");
		long mobileNumber = sc.nextLong();
		logger.debug("Year Of Joining :");
		int yearOfJoin = sc.nextInt();
		Date date = Date.valueOf(dateOfBirth);

		StudentDetailsService obj = new StudentDetailsService();
		Student ob = new Student();
		ob.setStudentName(studentName);
		ob.setStudentDepatment(studentDepartment);
		ob.setDateOfBirth(date.toLocalDate());
		ob.setStudentMailId(studentMailId);
		ob.setMobileNumber(mobileNumber);
		ob.setYearOfJoin(yearOfJoin);

		obj.addStudentDetails(ob);
		sc.close();

	}

}
