package com.epam.task.servlets.cabinet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Order;
import com.epam.task.database.service.OrderService;

@WebServlet("/check_order")
public class CheckOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdString = request.getParameter("orderId");
		if(orderIdString == null) {
			return;
		}
		
		int orderId = Integer.parseInt(orderIdString);
		Order order = new OrderService().getOrderById(orderId);
		
		response.getWriter().write(order != null ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
