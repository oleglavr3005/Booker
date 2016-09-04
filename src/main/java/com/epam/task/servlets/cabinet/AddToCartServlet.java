package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.Order;
import com.epam.task.database.model.User;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = ((User) session.getAttribute("user")).getId();
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		Timestamp startDate;
		Timestamp endDate;
		try {
			startDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("startDate").toString()).getTime());
		} catch (ParseException e) {
			startDate = new Timestamp(new Date().getTime());
		}
		try {
			endDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("endDate").toString()).getTime());
		} catch (ParseException e) {
			endDate = new Timestamp(new Date().getTime());
		}
		Timestamp orderDate = new Timestamp(new Date().getTime());

		int daysCount = (int)( (endDate.getTime() - startDate.getTime()) 
                / (1000 * 60 * 60 * 24) );
		int price = new RoomService().getRoomById(roomId).getPrice() * daysCount;
		
		boolean available = new RoomService().isRoomAvailable(roomId, startDate, endDate);
		if(available) {
			int result = new OrderService().insertOrder(new Order(0, userId, roomId, startDate, endDate, "ORDER", orderDate, price, ""));
			if(result == 0) {
				available = false;
			}
		}
		response.getWriter().write(available ? "true" : "false");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
