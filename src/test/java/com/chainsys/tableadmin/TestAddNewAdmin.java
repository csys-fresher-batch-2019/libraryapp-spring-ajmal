package com.chainsys.tableadmin;

import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.libraryapp.model.AdminDetails;
import com.chainsys.libraryapp.service.AdminDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public abstract class TestAddNewAdmin {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		AdminDetailsService ob = new AdminDetailsService();
		AdminDetails obj = new AdminDetails();
		logger.debug("Creation Of New Admin \n Enter Name : ");
		Scanner sc = new Scanner(System.in);
		obj.setAdminName(sc.next());
		logger.debug("Date Of Birth (yyyy-MM-dd) : ");
		String dob = sc.next();
		obj.setAdminDOB(LocalDate.parse(dob));
		logger.debug("Mail Id : ");
		obj.setAdminMailId(sc.next());
		logger.debug("Mobile Number (10-Digits): ");
		long mnum = sc.nextLong();

		if ((int) (Math.log10(mnum) + 1) == 10) {
			obj.setAdminMobileNo(mnum);
		} else {
			logger.error("Enter the valid 10 digit number");
			TestAddNewAdmin.main(null);
		}
		logger.debug("Crete A password : ");
		obj.setAdminPassword(sc.next());
		logger.debug("Gender (Male/Female) : ");
		obj.setAdminGender(sc.next());
		ob.addNewAdmin(obj);
		logger.info("updated");
		sc.close();
	}

}
