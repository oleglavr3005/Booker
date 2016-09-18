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

import org.apache.log4j.Logger;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.UserService;

@WebFilter("/hotel/*")
public class UserHotelFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(UserHotelFilter.class);

    public UserHotelFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		int hotelId;
		try {
			hotelId = Integer.parseInt(httpRequest.getPathInfo().substring(1));
		} catch (Exception e) {
        	LOGGER.warn("Hotel page does not exist");
			((HttpServletResponse) response).sendError(404);
			return;
		}
		
		Hotel hotel = new HotelService().getHotelById(hotelId);
		User manager = new UserService().getUserById(hotel.getManagerId());
		if(hotel != null && hotel.getIsDeleted() == false && manager.getStatus() != UserStatus.BANNED) {
			chain.doFilter(request, response);
		} else {
        	LOGGER.warn("Hotel doest not exists, is deleted or manager is banned");
			((HttpServletResponse) response).sendError(404);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
