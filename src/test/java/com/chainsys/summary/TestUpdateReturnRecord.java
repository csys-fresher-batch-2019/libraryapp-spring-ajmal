package com.chainsys.summary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestUpdateReturnRecord {

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob=new SummaryDetailsService();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the BookId : ");
		int bookId=sc.nextInt();
		System.out.print("Enter the StudentId : ");
		int studentId=sc.nextInt();
		Integer fineAmount=ob.calculateFineAmount(studentId, bookId);
		if(fineAmount != null)
		{
		System.out.println("Fine Amount = "+fineAmount +"\nDo you want to return (Y/N) - " );
		String output=sc.next();
		sc.close();
		if(output.equalsIgnoreCase("Y"))
		{
			ob.updateReturnRecord(studentId, bookId,fineAmount);
			System.out.println("Book Returned");
		}
		else
		{
			System.out.println("ThankYou...!");
		}
		}
		sc.close();

	}

}
