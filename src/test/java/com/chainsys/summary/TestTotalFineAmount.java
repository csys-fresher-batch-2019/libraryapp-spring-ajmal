package com.chainsys.summary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.service.SummaryDetailsService;

public class TestTotalFineAmount {
	private final static Logger logger = LoggerFactory.getLogger(TestTotalFineAmount.class);

	public static void main(String[] args) throws Exception {

		SummaryDetailsService ob = new SummaryDetailsService();
		int total = ob.totalFineAmount();
		logger.info("Total Fine = " + total);
//		System.out.println("Tootal Fine = " + total);
	}

}
