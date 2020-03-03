package com.chainsys.summary;

import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.libraryapp.model.SummaryDetailsStudentDetails;
import com.chainsys.libraryapp.service.SummaryDetailsService;

public abstract class TestUnReturnedStudentBookDetails {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		SummaryDetailsService ob=new SummaryDetailsService();
		System.out.print("Enter the Student id : ");
		int studentId=sc.nextInt();
		
		ArrayList<SummaryDetailsStudentDetails> out =null;
				out=ob.unReturnedStudentBookDetails(studentId);
		if(out != null)
		{
			for (SummaryDetailsStudentDetails details : out) {
				System.out.println(details);
			}
		}
		else
		{
			System.out.println("This Student has not taken any book");	
		}
		sc.close();
	}

}
