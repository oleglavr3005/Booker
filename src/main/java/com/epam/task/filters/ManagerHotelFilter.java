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

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.database.service.HotelService;

@WebFilter("/cabinet/my_hotels/*")
public class ManagerHotelFilter implements Filter {

    public ManagerHotelFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpRequest.getSession(true);
		
		User manager = (User) httpSession.getAttribute("user");
		int hotelId;
		try {
			hotelId = Integer.parseInt(httpRequest.getPathInfo().substring(1));
		} catch (Exception e) {
			if(httpRequest.getPathInfo() != null || manager == null || manager.getType() != UserType.MANAGER) {
				((HttpServletResponse) response).sendError(404);
			} else {
				chain.doFilter(request, response);
			}
			return;
		}
		
		Hotel hotel = new HotelService().getHotelById(hotelId);
		
		if(manager != null && manager.getType() == UserType.MANAGER && hotel != null && hotel.getManagerId() == manager.getId()) {
			chain.doFilter(request, response);
		} else {		//throw the unexpected visitor on the error page
			((HttpServletResponse) response).sendError(404);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
