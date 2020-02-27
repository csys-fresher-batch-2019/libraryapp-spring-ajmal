package com.chainsys.tablestudent;


import java.sql.Date;
import java.util.Scanner;

import com.chainsys.libraryapp.model.StudentDetails;
import com.chainsys.libraryapp.service.StudentDetailsService;

public class TestAddNewStudent {

	public static void main(String[] args) throws Exception {
		System.out.print("Entre values \nStudent Name :");
		Scanner sc= new Scanner(System.in);
	    String studentName = sc.nextLine();
	    System.out.print("Department : ");
	    String studentDepartment= sc.nextLine();
	    System.out.print("Date of Birth : ");
	    String dateOfBirth=sc.nextLine();
	    System.out.print("Mail Id :");
	    String studentMailId = sc.nextLine();
	    System.out.print("Mobile Number :");
	    long mobileNumber = sc.nextLong();
	    System.out.print("Year Of Joining :");
	    int yearOfJoin = sc.nextInt();
	    Date date = Date.valueOf(dateOfBirth);
	    
	    StudentDetailsService obj =new StudentDetailsService();
	    StudentDetails ob=new StudentDetails();
	    ob.setStudentName(studentName);
	    ob.setStudentDepatment(studentDepartment);
	    ob.setDateOfBirth(date.toLocalDate());
	    ob.setStudentMailId(studentMailId);
	    ob.setMobileNumber(mobileNumber);
	    ob.setYearOfJoin(yearOfJoin);
	    
	    obj.addStudentDetails(ob);
	    sc.close();
	    

	}

}
