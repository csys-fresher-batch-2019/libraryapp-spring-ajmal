package com.chainsys.summary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestRenewalOfABook {

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob=new SummaryDetailsService();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the BookId : ");
		int bookId=sc.nextInt();
		System.out.print("Enter the StudentId : ");
		int studentId=sc.nextInt();
		Integer fineAmount=ob.calculateFineAmount(studentId, bookId);
		System.out.println("Fine Amount = "+fineAmount+"\nDo you want to Renual the book (Y/N) - ");
		String output=sc.next();
		if(output.equalsIgnoreCase("Y"))
		{
			ob.updateReturnRecord(studentId, bookId,fineAmount);
			ob.addNewEntry(studentId, bookId);
			System.out.println("Book Renawed");
		}
		else
		{
			System.out.println("ThankYou...!");
		}
		
		sc.close();
		

	}

}
