package com.chainsys.libraryapp.service;

import com.chainsys.libraryapp.dao.AdminDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.exception.ValidationException;
import com.chainsys.libraryapp.model.Admin;
import com.chainsys.libraryapp.util.Constant;
import com.chainsys.libraryapp.validation.Validation;

public class AdminService {

	private AdminDAO adminDetailsDAO = DAOFactory.getAdminDAO();

	public void addNewAdmin(Admin admindetails) throws ServiceException {
		try {
			adminDetailsDAO.save(admindetails);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_ADD, e);
		}
	}

	public Boolean userLogin(String mailId, String password) throws ServiceException {
		Boolean valid = null;
		try {
			valid = adminDetailsDAO.userLogin(mailId, password);
			Validation.validationSearch(mailId, password);
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_LOGIN, e);
		} catch (ValidationException e) {
			throw new ServiceException("", e);
		}

		return valid;
	}
}
