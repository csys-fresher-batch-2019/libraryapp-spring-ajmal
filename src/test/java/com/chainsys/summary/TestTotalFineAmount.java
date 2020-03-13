package com.chainsys.summary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.libraryapp.service.SummaryService;

public class TestTotalFineAmount {
	private final static Logger logger = LoggerFactory.getLogger(TestTotalFineAmount.class);

	public static void main(String[] args) throws Exception {

		SummaryService ob = new SummaryService();
		int total = ob.totalFineAmount();
		logger.info("Total Fine = " + total);
//		System.out.println("Tootal Fine = " + total);
	}

}
