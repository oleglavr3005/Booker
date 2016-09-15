package com.epam.task.servlets.cabinet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Order;
import com.epam.task.database.service.OrderService;
import com.epam.task.util.StringUtil;

@WebServlet("/change_order_comment")
public class ChangeOrderCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeOrderCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdString = request.getParameter("orderId");
		String newComment = request.getParameter("comment");
		
		if(!StringUtil.isPositiveInteger(orderIdString) || newComment == null) {
			response.sendError(500);
			return;
		}
		
		int orderId = Integer.parseInt(orderIdString);
		
		OrderService orderService = new OrderService();
		Order order = orderService.getOrderById(orderId);
		order.setComment(newComment);
		int updated = orderService.updateOrder(order);

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(updated > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
