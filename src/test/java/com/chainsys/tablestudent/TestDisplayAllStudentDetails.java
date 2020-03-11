package com.chainsys.tablestudent;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.StudentDetails;
import com.chainsys.libraryapp.service.StudentDetailsService;

public class TestDisplayAllStudentDetails {
	private final static Logger logger = LoggerFactory.getLogger(TestDisplayAllStudentDetails.class);

	public static void main(String[] args) throws Exception {
		StudentDetailsService ob = new StudentDetailsService();
		List<StudentDetails> list = new ArrayList<StudentDetails>();
		list = ob.displayAllStudents();
		for (StudentDetails details : list) {
			logger.info("",details);
		}

	}

}
