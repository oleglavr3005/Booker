package com.epam.task.util;

public class StringUtil {
	
	public static boolean isPositiveInteger (String stringToCheck) {
		try {
			return Integer.parseInt(stringToCheck) > 0 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isNotNegativeInteger (String stringToCheck) {
		try {
			return Integer.parseInt(stringToCheck) >= 0 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isInRatingRange (String stringToCheck) {
		try {
			int rating = Integer.parseInt(stringToCheck);
			return (rating > 0 && rating < 11) ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isInStarsRange (String stringToCheck) {
		try {
			int stars = (int) Double.parseDouble(stringToCheck);
			return (stars > 0 && stars < 6) ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isNotNegativeDouble (String stringToCheck) {
		try {
			return Double.parseDouble(stringToCheck) >= 0 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isBoolean(String stringToCheck) {
		try {
			Boolean.parseBoolean(stringToCheck);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean isPositiveIntegerOrNull (String stringToCheck) {
		try {
			if (stringToCheck == null) {
				return true;
			}
			return ((int) Double.parseDouble(stringToCheck)) > 0 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isInStarsRangeOrNull (String stringToCheck) {
		try {
			if (stringToCheck == null) {
				return true;
			}
			int stars = (int) Double.parseDouble(stringToCheck);
			return (stars > 0 && stars < 6) ? true : false;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isDouble(String stringToCheck) {
		try {
			Double.parseDouble(stringToCheck);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
