package com.chainsys.tableadmin;

import java.time.LocalDate;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.model.Admin;
import com.chainsys.libraryapp.service.AdminService;

public abstract class TestAddNewAdmin {
	private final static Logger logger = LoggerFactory.getLogger(TestAddNewAdmin.class);

	public static void main(String[] args) throws Exception {
		AdminService ob = new AdminService();
		Admin obj = new Admin();
		logger.debug("Creation Of New Admin \n Enter Name : ");
		Scanner sc = new Scanner(System.in);
		obj.setName(sc.next());
		logger.debug("Date Of Birth (yyyy-MM-dd) : ");
		String dob = sc.next();
		obj.setDob(LocalDate.parse(dob));
		logger.debug("Mail Id : ");
		obj.setMailId(sc.next());
		logger.debug("Mobile Number (10-Digits): ");
		long mnum = sc.nextLong();

		if ((int) (Math.log10(mnum) + 1) == 10) {
			obj.setMobileNo(mnum);
		} else {
			logger.error("Enter the valid 10 digit number");
			TestAddNewAdmin.main(null);
		}
		logger.debug("Crete A password : ");
		obj.setPassword(sc.next());
		logger.debug("Gender (Male/Female) : ");
		obj.setGender(sc.next());
		ob.addNewAdmin(obj);
		logger.info("updated");
		sc.close();
	}

}
