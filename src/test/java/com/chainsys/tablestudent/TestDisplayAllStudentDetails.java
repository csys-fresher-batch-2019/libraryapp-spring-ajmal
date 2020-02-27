package com.chainsys.tablestudent;

import java.util.ArrayList;

import com.chainsys.libraryapp.model.StudentDetails;
import com.chainsys.libraryapp.service.StudentDetailsService;

public class TestDisplayAllStudentDetails {

	public static void main(String[] args) throws Exception {
		StudentDetailsService ob=new StudentDetailsService();
		ArrayList<StudentDetails> list = new ArrayList<StudentDetails>();
		list=ob.displayAllStudents();
		for(StudentDetails details:list)
		{
			System.out.println(details);
		}

	}

}
