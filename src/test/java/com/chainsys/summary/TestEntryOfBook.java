package com.chainsys.summary;

import java.util.Scanner;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestEntryOfBook {

	public static void main(String[] args) throws Exception {
		SummaryDetailsService ob=new SummaryDetailsService();
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter Book ID : ");
		int bookId = sc.nextInt();
		System.out.print("Enter Student ID : ");
		int studentId=sc.nextInt();
		ob.addNewEntry(studentId, bookId);
	System.out.println("Thanks for talking the book");
	
	
		sc.close();

	}

}
