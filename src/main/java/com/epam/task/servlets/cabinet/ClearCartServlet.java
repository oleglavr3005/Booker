package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Order;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.OrderService;

@WebServlet("/clear_cart")
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClearCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		new OrderService().removeAllOrdersByStatus(userId, OrderStatus.ORDER);
		
//		response.getWriter().write(removed > 0 ? "true" : "false");
		request.setAttribute("orders", new ArrayList<Order>());
		request.getRequestDispatcher("/pages/user/shopping_cart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
