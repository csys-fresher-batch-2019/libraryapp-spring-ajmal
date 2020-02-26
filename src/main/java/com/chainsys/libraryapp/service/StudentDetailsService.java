package com.chainsys.libraryapp.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.jdbi.v3.core.Jdbi;

import com.chainsys.libraryapp.dao.StudentDetailsDAO;
import com.chainsys.libraryapp.model.StudentDetails;
import com.chainsys.libraryapp.util.Connectionutil;

public class StudentDetailsService {
	
	//private StudentDetailsDAO studentDetailsDAO=new StudentDetailsDAOImp();
	private Jdbi jdbi = Connectionutil.getJdbi();
	private StudentDetailsDAO studentDetailsDAO= jdbi.onDemand(StudentDetailsDAO.class);
	
	public void addStudentDetails(StudentDetails studentdetails)throws Exception
	{
		studentDetailsDAO.addStudentDetails(studentdetails);
	}
	public StudentDetails displayStudentDetail(int studentId)throws Exception{
		Integer contt = studentDetailsDAO.findByStudentId(studentId);
		if (contt == null) {
			throw new Exception("Invalid Student Id");
		}
		return studentDetailsDAO.displayStudentDetail(studentId);
		}
	public ArrayList<StudentDetails> displayAllStudents()throws Exception{
		return studentDetailsDAO.displayAllStudents();
	}

	public Boolean studentLogin(int studentId,LocalDate dateOfBirth)throws Exception{
		Integer contt = studentDetailsDAO.findByStudentId(studentId);
		if (contt == null) {
			throw new Exception("Invalid Student Id");
		}
		Boolean valid=studentDetailsDAO.studentLogin(studentId, dateOfBirth);
			if(valid == null) {
				throw new Exception("Invalid Email/Date Of Birth");
			}
		return valid;
		
	}
}
