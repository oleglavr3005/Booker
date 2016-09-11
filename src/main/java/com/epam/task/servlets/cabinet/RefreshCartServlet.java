package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.dto.OrderDto;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.OrderService;

@WebServlet("/refresh_cart")
public class RefreshCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RefreshCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		OrderService orderService = new OrderService();
		
		List<OrderDto> orders = OrderDto.listConverter(orderService.getOrdersByUserAndStatus(user.getId(), OrderStatus.ORDER));
		int summary = 0;
		for(OrderDto order : orders){
			if(order.getRoom().getDaysCount() >= 0) {
				summary += order.getPrice();
			}
		}

		String compareBy = request.getParameter("compareBy");
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int countOfPages = (int) Math.ceil(orders.size() / 3.0);
		if (page > countOfPages) {
			page--;
		}
		
		List<OrderDto> ordersByPage = OrderDto.listConverter(orderService.getOrdersByUserAndStatusAndPage(user.getId(), OrderStatus.ORDER, page, compareBy));

		request.setAttribute("orders", ordersByPage);
		request.setAttribute("summary", summary);
		request.setAttribute("countOfOrders", orders.size());
		request.setAttribute("countOfPages", countOfPages);
		request.setAttribute("currentPage", 1);
		
		request.getRequestDispatcher("/pages/orderCard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
