package com.epam.task.util;

public class Extracter {
	public static String getLast(String path) {
		int i = path.lastIndexOf("/");
		return path.substring(i + 1, path.length());
	}

}
