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
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomService;

@WebFilter("/cabinet/room/*")
public class ManagerRoomFilter implements Filter {

    public ManagerRoomFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpRequest.getSession(true);
		
		User manager = (User) httpSession.getAttribute("user");
		int roomId;
		try {
			roomId = Integer.parseInt(httpRequest.getPathInfo().substring(1));
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(404);
			return;
		}
		Room room = new RoomService().getRoomById(roomId);
		
		if(manager != null && room != null) {
			Hotel hotel = new HotelService().getHotelById(room.getHotelId());
			if (hotel.getManagerId() == manager.getId()) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendError(404);
			}
		} else {		//throw the unexpected visitor on the error page
			((HttpServletResponse) response).sendError(404);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
