package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;
import com.epam.task.database.service.UserService;

@WebServlet("/cabinet/manager_order/*")
public class ManagerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManagerOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId;
		try {
			orderId = Integer.parseInt(request.getPathInfo().substring(1));
		} catch (Exception e) {
			return;
		}
		Order order = new OrderService().getOrderById(orderId);
		Room room = new RoomService().getRoomById(order.getRoomId());
		Hotel hotel = new HotelService().getHotelById(room.getHotelId());		
		User user = new UserService().getUserById(order.getUserId());
		
		request.setAttribute("hotel", hotel);
		request.setAttribute("order", order);
		request.setAttribute("room", room);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/pages/manager/managerOrderConcrete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
