package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.dto.OrderDto;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.OrderService;

@WebServlet("/cabinet/orders")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrdersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int userId = ((User) session.getAttribute("user")).getId();
		
		OrderService orderService = new OrderService();
		List<OrderDto> activeOrders = OrderDto.listConverter(orderService.getOrdersByUserAndStatus(userId, OrderStatus.ACTIVE));
		Date currentDate = new Date();
		for (OrderDto order : activeOrders) {
			Timestamp startDate = order.getStartDate();
			if (startDate.getTime() < currentDate.getTime()) {
				order.setStatus(OrderStatus.FINISHED);
				orderService.updateOrder(order);
			}
		}
		List<OrderDto> finishedOrders = OrderDto.listConverter(orderService.getOrdersByUserAndStatus(userId, OrderStatus.FINISHED));
		List<OrderDto> canceledOrders = OrderDto.listConverter(orderService.getOrdersByUserAndStatus(userId, OrderStatus.CANCELED));
		List<OrderDto> allOrders = OrderDto.listConverter(orderService.getOrdersByUserAndStatus(userId, OrderStatus.ACTIVE));
		allOrders.addAll(finishedOrders);
		allOrders.addAll(canceledOrders);
		
		request.setAttribute("allOrders", allOrders);
		request.setAttribute("activeOrders", activeOrders);
		request.setAttribute("finishedOrders", finishedOrders);
		
		request.getRequestDispatcher("/pages/user/orders.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
