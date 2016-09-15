package com.epam.task.servlets.manager;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.dto.OrderDto;
import com.epam.task.database.model.Order;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.OrderService;

@WebServlet("/cabinet/hotel_orders/*")
public class MyHotelOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyHotelOrdersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hotelId;
		try {
			hotelId = Integer.parseInt(request.getPathInfo().substring(1));
		} catch (Exception e) {
			return;
		}

		OrderService orderService = new OrderService();
		List<Order> activeOrders = orderService.getOrdersByHotelAndStatus(hotelId, OrderStatus.ACTIVE);
		Date currentDate = new Date();
		for (Order order : activeOrders) {
			Timestamp endDate = order.getEndDate();
			if (endDate.getTime() < currentDate.getTime()) {
				order.setStatus(OrderStatus.FINISHED);
				orderService.updateOrder(order);
			}
		}

		List<Order> finishedOrders = orderService.getOrdersByHotelAndStatus(hotelId, OrderStatus.FINISHED);
		List<Order> canceledOrders = orderService.getOrdersByHotelAndStatus(hotelId, OrderStatus.CANCELED);
		List<Order> allOrders = orderService.getOrdersByHotelAndStatus(hotelId, OrderStatus.ACTIVE);
		allOrders.addAll(finishedOrders);
		allOrders.addAll(canceledOrders);
		
		request.setAttribute("allOrders", OrderDto.listConverter(allOrders));
		request.setAttribute("activeOrders", OrderDto.listConverter(activeOrders));
		request.setAttribute("finishedOrders", OrderDto.listConverter(finishedOrders));
		
		request.getRequestDispatcher("/pages/manager/managerOrders.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
