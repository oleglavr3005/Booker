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

import com.epam.task.database.model.Hotel;
import com.epam.task.database.service.HotelService;

@WebFilter("/hotel/*")
public class UserHotelFilter implements Filter {

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
			((HttpServletResponse) response).sendError(404);
			return;
		}
		
		Hotel hotel = new HotelService().getHotelById(hotelId);
		if(hotel != null && hotel.isDeleted() == false) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendError(404);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
