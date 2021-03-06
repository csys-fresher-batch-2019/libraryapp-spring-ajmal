package com.chainsys.libraryapp.util;

public class LoggerUtil {
	public static LoggerUtil getInstance() {
		LoggerUtil logger = new LoggerUtil();
		return (logger);
	}

	public void debug(Object message) {
		System.out.println(message);
	}

	public void info(Object message) {
		System.out.println(message);
	}

	public void error(Object message) {
		System.out.println(message);
	}

}
