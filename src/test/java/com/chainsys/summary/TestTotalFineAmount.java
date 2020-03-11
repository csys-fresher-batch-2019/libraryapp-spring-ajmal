package com.chainsys.summary;

import com.chainsys.libraryapp.service.SummaryDetailsService;
import com.chainsys.libraryapp.util.LoggerUtil;

public class TestTotalFineAmount {

	public static void main(String[] args) throws Exception {
		LoggerUtil logger = LoggerUtil.getInstance();
		SummaryDetailsService ob = new SummaryDetailsService();
		int total = ob.totalFineAmount();
		logger.info("Total Fine = " + total);
//		System.out.println("Tootal Fine = " + total);
	}

}
