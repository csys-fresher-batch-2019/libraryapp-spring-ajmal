package com.chainsys.tablestudent;

import java.util.ArrayList;

import com.chainsys.libraryapp.model.StudentDetails;
import com.chainsys.libraryapp.service.StudentDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestDisplayAllStudentDetails {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		StudentDetailsService ob = new StudentDetailsService();
		ArrayList<StudentDetails> list = new ArrayList<StudentDetails>();
		list = ob.displayAllStudents();
		for (StudentDetails details : list) {
			logger.info(details);
		}

	}

}
