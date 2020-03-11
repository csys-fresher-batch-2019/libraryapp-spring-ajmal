package com.chainsys.libraryapp.service;

import com.chainsys.libraryapp.dao.AdminDetailsDAO;
import com.chainsys.libraryapp.dao.DAOFactory;
import com.chainsys.libraryapp.exception.DbException;
import com.chainsys.libraryapp.exception.ServiceException;
import com.chainsys.libraryapp.model.AdminDetails;
import com.chainsys.libraryapp.util.Constant;

public class AdminDetailsService {

	private AdminDetailsDAO adminDetailsDAO = DAOFactory.getAdminDetailDAO();

	public void addNewAdmin(AdminDetails admindetails) throws ServiceException {
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
			if (valid == null || !valid) {
				throw new ServiceException(Constant.INVALID_EMAIL_PASSWORD);
			}
		} catch (DbException e) {
			throw new ServiceException(Constant.UNABLE_TO_LOGIN, e);
		}

		return valid;
	}
}
