package com.chainsys.tablestudent;

import java.util.Scanner;

import com.chainsys.libraryapp.model.StudentDetails;
import com.chainsys.libraryapp.service.StudentDetailsService;

public class TestDisplayStudentDetail {

	public static void main(String[] args) throws Exception {
		StudentDetailsService ob=new StudentDetailsService();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Student Id - ");
		int studentId=sc.nextInt();
		StudentDetails obj= new StudentDetails();
		obj=ob.displayStudentDetail(studentId);
			System.out.println(obj);
		sc.close();
	}

}
