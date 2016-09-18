package com.epam.task.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserStatus;

@WebFilter({ "/cabinet/*", "/cancel_order", "/change_info", "/change_password", "/change_image", "/change_email", 
	"/change_phone", "/refresh_cart", "/get_chart_data" })
public class UserFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(UserFilter.class);

    public UserFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpRequest.getSession(true);
		
		User user = (User) httpSession.getAttribute("user");
		
		if(user != null && user.getStatus() != UserStatus.PENDING) {
			chain.doFilter(request, response);
		} else {		//throw the unexpected visitor on the error page
        	LOGGER.warn("Not-logged user tried to visit logged users page");
			((HttpServletResponse) response).sendError(404);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
