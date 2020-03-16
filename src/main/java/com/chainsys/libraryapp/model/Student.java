package com.chainsys.libraryapp.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private int id;
	private String name;
	private String dept;
	private LocalDate dob;
	private String mailId;
	private long mobileNumber;
	private int yearOfJoin;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dept=" + dept + ", dob=" + dob + ", mailId=" + mailId
				+ ", mobileNumber=" + mobileNumber + ", yearOfJoin=" + yearOfJoin + "]";
	}
}
