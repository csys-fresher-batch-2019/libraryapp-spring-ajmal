package com.chainsys.tableadmin;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.service.AdminService;

public class TestAdminLogin {
	private final static Logger logger = LoggerFactory.getLogger(TestAdminLogin.class);

	public static void main(String[] args) throws Exception {
		AdminService ob = new AdminService();
		Scanner sc = new Scanner(System.in);
		logger.debug("Enter your mail id : ");
		String mailId = sc.next();
		logger.debug("Enter your Password : ");
		String password = sc.next();
		Boolean out = ob.userLogin(mailId, password);
		if (out) {
			logger.info("LoggedIn");
		}
		sc.close();
	}

}
