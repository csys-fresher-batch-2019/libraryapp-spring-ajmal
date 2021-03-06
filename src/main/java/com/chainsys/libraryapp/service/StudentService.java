package com.chainsys.libraryapp.service;

import java.time.LocalDate;
import java.util.List;

import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.dao.StudentDAO;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.exception.ValidationException;
import com.chainsys.libraryapp.model.Student;
import com.chainsys.libraryapp.util.Constant;
import com.chainsys.libraryapp.validation.Validation;

public class StudentService {

	private StudentDAO studentDetailsDAO = DAOFactory.getStudentDAO();

	public void addStudentDetails(Student studentdetails) throws ServiceException {
		try {
			studentDetailsDAO.save(studentdetails);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_ADD, e);
		}
	}
	
	public Student displayStudentDetail(int studentId) throws ServiceException {
		try {
			Validation.checkStudentId(studentId);
			return studentDetailsDAO.findById(studentId);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_DISPLAY, e);
		}

	}

	public List<Student> displayAllStudents() throws ServiceException {
		try {
			return studentDetailsDAO.findAll();
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_DISPLAY, e);
		}
	}

	public Boolean studentLogin(int studentId, LocalDate dateOfBirth) throws ServiceException {
		Boolean valid;
		try {
			Validation.checkStudentId(studentId);
			valid = studentDetailsDAO.studentLogin(studentId, dateOfBirth);
			if (valid == null) {
				throw new ServiceException(Constant.INVALID_STUDENT_ID_DATE_OF_BIRTH);
			}
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_LOGIN, e);
		}

		return valid;

	}
}
