package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.Order;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.OrderService;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/cabinet/orders")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int userId = ((User) session.getAttribute("user")).getId();
		
		List<Order> allOrders = new OrderService().getOrdersByUser(userId);
		List<Order> activeOrders = new OrderService().getOrdersByUserAndStatus(userId, OrderStatus.ACTIVE);
		List<Order> canceledOrders = new OrderService().getOrdersByUserAndStatus(userId, OrderStatus.CANCELED);
		List<Order> finishedOrders = new OrderService().getOrdersByUserAndStatus(userId, OrderStatus.FINISHED);
		
		request.setAttribute("allOrders", allOrders);
		request.setAttribute("activeOrders", activeOrders);
		request.setAttribute("canceledOrders", canceledOrders);
		request.setAttribute("finishedOrders", finishedOrders);
		
		request.getRequestDispatcher("/pages/user/orders.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
