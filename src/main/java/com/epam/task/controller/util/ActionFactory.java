package com.epam.task.controller.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	private static Map<String, Method> actions = new HashMap<>();

	public static Method getAction(HttpServletRequest request) {
		Method action = actions
				.get(request.getPathInfo() + request.getMethod());

		if (action == null) {
			Integer i = request.getPathInfo().lastIndexOf("/");
			String key = request.getPathInfo().substring(0, i + 1) + '*'
					+ request.getMethod();
			action = actions.get(key);
		}

		return action;
	}

	static void addAction(String key, Method value) {

		if (actions.put(key, value) != null) {
			throw new NullPointerException("action is allready in map!");
		}
	}

}
