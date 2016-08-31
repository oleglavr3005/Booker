package com.epam.task.controller.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@WebFilter("/*")
public class MainFilter implements Filter {

	public MainFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		if (req.getCharacterEncoding() == null) {
			req.setCharacterEncoding("UTF-8");
		}

		HttpSession session = req.getSession();

		if (session.getAttribute("locale") == null) {
			req.getSession().setAttribute("locale", "en_US");
		}
		String path = req.getRequestURI().substring(
				req.getContextPath().length());
		if (path.startsWith("/resources/")) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/frontcontroller" + path).forward(
					request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}

}
