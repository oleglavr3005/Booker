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

@WebFilter({ "/add_to_cart", "/remove_from_cart", "/clear_cart", "/book_all", "/book", 
	"/check_order", "/create_request", "/add_feedback", "/change_feedback", "/deleteFeedback" })
public class ActiveUserFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(ActiveUserFilter.class);
	
    public ActiveUserFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpRequest.getSession(true);
		
		User user = (User) httpSession.getAttribute("user");
		
		if(user != null && user.getStatus() == UserStatus.ACTIVE) {
			chain.doFilter(request, response);
		} else {		//throw the unexpected visitor on the error page
        	LOGGER.warn("Not-active user tried to visit active users page");
			((HttpServletResponse) response).sendError(404);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
