package com.chainsys.libraryapp.service;

import com.chainsys.libraryapp.dao.AdminDetailsDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.model.AdminDetails;

public class AdminDetailsService {

	private AdminDetailsDAO adminDetailsDAO = DAOFactory.getAdminDetailDAO();

	public void addNewAdmin(AdminDetails admindetails) throws ServiceException {
		try {
			adminDetailsDAO.addNewAdmin(admindetails);
		} catch (DbException e) {
			throw new ServiceException("Unable to add admin", e);
		}
	}

	public Boolean userLogin(String mailId, String password) throws ServiceException {
		Boolean valid = null;
		try {
			valid = adminDetailsDAO.userLogin(mailId, password);
			if (valid == null || !valid) {
				throw new ServiceException("Invalid Email/Password");
			}
		} catch (DbException e) {
			throw new ServiceException("Unable to Login", e);
		}

		return valid;
	}
}
