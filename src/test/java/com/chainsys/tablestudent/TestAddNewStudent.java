package com.chainsys.tablestudent;

import java.sql.Date;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Student;
import com.chainsys.libraryapp.service.StudentService;

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

		StudentService obj = new StudentService();
		Student ob = new Student();
		ob.setName(studentName);
		ob.setDept(studentDepartment);
		ob.setDob(date.toLocalDate());
		ob.setMailId(studentMailId);
		ob.setMobileNumber(mobileNumber);
		ob.setYearOfJoin(yearOfJoin);

		obj.addStudentDetails(ob);
		sc.close();

	}

}
