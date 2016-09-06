package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.HotelUtil;

@WebServlet("/book_all")
public class BookAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardNumber = request.getParameter("cardNumber");
		String comment = request.getParameter("comment");
		if(cardNumber == null) {
			return;
		}
		int userId = ((User) request.getSession().getAttribute("user")).getId();

		List<Order> userOrders = new OrderService().getOrdersByUserAndStatus(userId, OrderStatus.ORDER);
		Set<Integer> hotelIds = new HashSet<>();
		for (Order order : userOrders) {
			Room room = new RoomService().getRoomById(order.getRoomId());
			hotelIds.add(room.getHotelId());
		}
		List<Hotel> recomendedHotels = HotelUtil.getRecomendedHotelsForUser(hotelIds, userId);

		request.setAttribute("recomendedHotels", recomendedHotels);
		request.setAttribute("recomendedHotelsSize", recomendedHotels.size());
		
		int booked = new OrderService().bookAllByUser(userId, cardNumber, comment);
		
		response.getWriter().write(booked > 0 ? "true" : "false");
		if(booked > 0) {
			request.getRequestDispatcher("/pages/orderCard.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
