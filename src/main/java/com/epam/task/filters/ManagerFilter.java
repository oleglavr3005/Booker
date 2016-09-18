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
import com.epam.task.database.model.enums.UserType;

@WebFilter({ "/add_hotel", "/edit_hotel", "/change_hotel_status", "/upload_hotel", "/upload_room", "/add_room", "/edit_room", "/change_room_status",
	"/remove_hotel_photo", "/remove_room_photo", "/set_main_hotel_photo", "/set_main_room_photo", 
	"/get_manager_chart_data", "/get_visitors_chart_data", "/cabinet/create_hotel"})
public class ManagerFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(ManagerFilter.class);

    public ManagerFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpRequest.getSession(true);
		
		User user = (User) httpSession.getAttribute("user");
		
		if(user != null && user.getType() == UserType.MANAGER) {
			chain.doFilter(request, response);
		} else {		//throw the unexpected visitor on the error page
        	LOGGER.warn("Not-manager user tried to visit manager page");
			((HttpServletResponse) response).sendError(404);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
