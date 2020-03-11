package com.chainsys.tableadmin;

import java.util.Scanner;

import com.chainsys.libraryapp.service.AdminDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestAdminLogin {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		AdminDetailsService ob = new AdminDetailsService();
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
