package com.chainsys.tablestudent;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Student;
import com.chainsys.libraryapp.service.StudentDetailsService;

public class TestDisplayAllStudentDetails {
	private final static Logger logger = LoggerFactory.getLogger(TestDisplayAllStudentDetails.class);

	public static void main(String[] args) throws Exception {
		StudentDetailsService ob = new StudentDetailsService();
		List<Student> list = new ArrayList<Student>();
		list = ob.displayAllStudents();
		for (Student details : list) {
			logger.info("",details);
		}

	}

}
