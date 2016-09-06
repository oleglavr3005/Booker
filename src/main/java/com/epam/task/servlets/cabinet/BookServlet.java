package com.epam.task.servlets.cabinet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.HotelUtil;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdString = request.getParameter("orderId");
		String cardNumber = request.getParameter("cardNumber");
		String comment = request.getParameter("comment");
		
		if(orderIdString == null || cardNumber == null) {
			return;
		}
		OrderService orderService = new OrderService();
		int orderId = Integer.parseInt(orderIdString);
		int booked = orderService.bookOrder(orderId, cardNumber, comment);
		int roomId = orderService.getOrderById(orderId).getRoomId();
		Room room = new RoomService().getRoomById(roomId);
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		
		request.setAttribute("recomendedHotels", HotelUtil.getRecomendedHotelsForUser(room.getHotelId(), userId));
		
		response.getWriter().write(booked > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
