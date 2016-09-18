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

import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;

@WebFilter("/cabinet/manager_order/*")
public class ManagerOrderFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(ManagerOrderFilter.class);

    public ManagerOrderFilter() {
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
        	LOGGER.warn("Manager order page does not exist");
			((HttpServletResponse) response).sendError(404);
			return;
		}
		
		if(user != null && user.getType() == UserType.MANAGER) {		
			Order order = new OrderService().getOrderByUserAndId(user.getId(), orderId);
			if(order != null && order.getStatus() != OrderStatus.ORDER) {
				Room room = new RoomService().getRoomById(order.getRoomId());
				int managerId = new HotelService().getHotelById(room.getHotelId()).getManagerId();
				if(managerId == user.getId()) {
					chain.doFilter(request, response);
				} else {
		        	LOGGER.warn("Manager user tried to visit order page for hotel, that does not belong him");
					((HttpServletResponse) response).sendError(404);
				}
			} else {
	        	LOGGER.warn("Manager user tried to visit order page that does not exist");
				((HttpServletResponse) response).sendError(404);
			}
		} else {		//throw the unexpected visitor on the error page
        	LOGGER.warn("Not-manager user tried to visit manager order page");
			((HttpServletResponse) response).sendError(404);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
