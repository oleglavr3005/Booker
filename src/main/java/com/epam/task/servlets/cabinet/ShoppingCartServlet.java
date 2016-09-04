package com.epam.task.servlets.cabinet;

import java.io.IOException;
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

@WebServlet("/cabinet/cart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShoppingCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int userId = ((User) session.getAttribute("user")).getId();
		
		List<OrderDto> orders = OrderDto.listConverter(new OrderService().getOrdersByUserAndStatus(userId, OrderStatus.ORDER));
		
		int summary = 0;
		for(OrderDto order : orders){
			if(order.getRoom().getDaysCount() >= 0) {
				summary += order.getPrice();
			}
		}
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int countOfPages = (int) Math.ceil(orders.size() / 3.0);
		if (page > countOfPages) {
			page--;
		}
				
		List<OrderDto> ordersByPage = OrderDto.listConverter(new OrderService().getOrdersByUserAndStatusAndPage(userId, OrderStatus.ORDER, page));
		
		request.setAttribute("orders", ordersByPage);
		request.setAttribute("summary", summary);
		request.setAttribute("countOfOrders", orders.size());
		session.setAttribute("countOfPages", countOfPages);
		request.setAttribute("currentPage", page);
		
		if(request.getParameter("flag") != null && request.getParameter("flag").equals("true")) {
			request.getRequestDispatcher("/pages/orderCard.jsp").forward(request, response);
		} else {	
			request.getRequestDispatcher("/pages/user/shopping_cart.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
