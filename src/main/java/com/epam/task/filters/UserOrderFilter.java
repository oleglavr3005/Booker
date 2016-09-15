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

import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;

@WebFilter("/cabinet/order/*")
public class UserOrderFilter implements Filter {

    public UserOrderFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpRequest.getSession(true);
		
		User user = (User) httpSession.getAttribute("user");
		int orderId;
		try {
			orderId = Integer.parseInt(httpRequest.getPathInfo().substring(1));
		} catch (Exception e) {
			((HttpServletResponse) response).sendError(404);
			return;
		}
		
		if(user != null) {		
			Order order = new OrderService().getOrderByUserAndId(user.getId(), orderId);
			if(order != null && order.getStatus() != OrderStatus.ORDER) {
				chain.doFilter(request, response);
			} else {
				if(order != null) {
					Room room = new RoomService().getRoomById(order.getRoomId());
					int managerId = new HotelService().getHotelById(room.getHotelId()).getManagerId();
					if(managerId == user.getId()) {
						chain.doFilter(request, response);
					} else {
						((HttpServletResponse) response).sendError(404);
					}
				} else {
					((HttpServletResponse) response).sendError(404);
				}
			}
		} else {		//throw the unexpected visitor on the error page
			((HttpServletResponse) response).sendError(404);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
