package com.epam.task.servlets.cabinet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.service.OrderService;
import com.epam.task.util.StringUtil;

@WebServlet("/remove_from_cart")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveFromCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdString = request.getParameter("orderId");
		if(orderIdString == null || !StringUtil.isPositiveInteger(orderIdString)) {
			response.sendError(500);
			return;
		}
		
		int orderId = Integer.parseInt(orderIdString);
		int removed = new OrderService().removeOrder(orderId);

		response.getWriter().write(removed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
