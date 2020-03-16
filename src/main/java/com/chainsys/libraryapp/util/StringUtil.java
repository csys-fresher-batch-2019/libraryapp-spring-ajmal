package com.chainsys.libraryapp.util;

import com.chainsys.libraryapp.exception.ValidationException;

public class StringUtil {
	/*
	 * public static boolean isInvalidString(String input) { boolean result =
	 * StringUtils.hasText(input); return result; }
	 */

	public static void rejectIfInvalid(String input, String message) throws ValidationException {
		if (input == null || input.equals("") || input.trim().equals("")) {
			throw new ValidationException(message);
		}
	}
}
