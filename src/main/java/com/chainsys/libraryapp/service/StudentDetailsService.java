package com.chainsys.libraryapp.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.dao.StudentDetailsDAO;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.exception.ValidationException;
import com.chainsys.libraryapp.model.StudentDetails;
import com.chainsys.libraryapp.validation.Validation;

public class StudentDetailsService {

	private StudentDetailsDAO studentDetailsDAO = DAOFactory.getStudentDetailDAO();

	public void addStudentDetails(StudentDetails studentdetails) throws ServiceException {
		try {
			studentDetailsDAO.addStudentDetails(studentdetails);
		} catch (DbException e) {
			throw new ServiceException("Unable to Add", e);
		}
	}

	public StudentDetails displayStudentDetail(int studentId) throws ServiceException {
		try {
			Validation.checkStudentId(studentId);
			return studentDetailsDAO.displayStudentDetail(studentId);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException("Unable to Dispay", e);
		}

	}

	public ArrayList<StudentDetails> displayAllStudents() throws ServiceException {
		try {
			return studentDetailsDAO.displayAllStudents();
		} catch (DbException e) {
			throw new ServiceException("Unable to Dispay", e);
		}
	}

	public Boolean studentLogin(int studentId, LocalDate dateOfBirth) throws ServiceException {
		Boolean valid;
		try {
			Validation.checkStudentId(studentId);
			valid = studentDetailsDAO.studentLogin(studentId, dateOfBirth);
			if (valid == null) {
				throw new ServiceException("Invalid StudentId/Date Of Birth");
			}
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException("Unable to Login", e);
		}

		return valid;

	}
}
