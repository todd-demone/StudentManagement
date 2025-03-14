package com.todddemone.studentapp.utils;

import com.todddemone.studentapp.exceptions.ValidationException;

public final class ValidationUtils {

	private ValidationUtils() {
	}

	public static <T> T requireNonNull(T obj, String label) {
		if (obj == null) {
			throw new ValidationException(label + " cannot be null.");
		}
		return obj;
	}

	public static String requireNonEmpty(String str, String label) {
		if (str.trim().isEmpty()) {
			throw new ValidationException(label + " cannot be empty.");
		}
		return str;
	}

	public static int requireNonNegative(int number, String label) {
		if (number < 0) {
			throw new ValidationException(label + " cannot be a negative number.");
		}
		return number;
	}

	public static int requireNumberOfDigits(int number, int numberOfDigits, String label) {
		String numToString = String.valueOf(number);
		if (numToString.length() != numberOfDigits) {
			throw new ValidationException(label + " must be exactly " + numberOfDigits + " digits in length.");
		}
		return number;
	}

	public static String requireCharacterLimit(String str, int limit, String label) {
		if (str.length() > limit) {
			throw new ValidationException(label + " cannot exceed " + limit + " characters.");
		}
		return str;
	}

	public static String limitCharCategories(String str) {
		if (!str.matches("^[A-Za-z'\\- ]+$")) {
			throw new ValidationException(
					"Student name can only contain letters, spaces, hyphens and apostrophes.");
		}
		return str;
	}
}
