package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;

@WebServlet("/cancel_order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CancelOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdString = request.getParameter("orderId");
		if(orderIdString == null) {
			return;
		}
		
		int orderId = Integer.parseInt(orderIdString);
		OrderService service = new OrderService();
		Order order = service.getOrderById(orderId);
		Room room = new RoomService().getRoomById(order.getRoomId());

		int days = room.getDaysCount();
		
		if(days > -1) { //do some stuff with money
			int daysLeft = (int)( (order.getStartDate().getTime() - new Date().getTime()) 
	                / (1000 * 60 * 60 * 24) );
			
			int moneyToReturn;
			if (daysLeft >= days) { //return all money and cancel
				moneyToReturn = order.getPrice() / 2; 	//we are paying a half of the sum
			} else { //return %
				moneyToReturn = (order.getPrice() / 200) * room.getPercentage(); //same as above
			}
			User user = ((User) request.getSession().getAttribute("user"));
			String email = user.getEmail();
			String phone = user.getPhoneNumber();
			if(email != null) {
				//TODO: SEND EMAIL WITH moneyToReturn
			}
			if(phone != null) {
				//TODO: SEND SMS WITH moneyToReturn
			}
		}
		
		order.setStatus(OrderStatus.CANCELED);
		int result = service.updateOrder(order);
		response.getWriter().write(result > 0 ? "true" : "false");
		
		try {
			if (Integer.parseInt(request.getPathInfo().substring(1)) == orderId) {
				response.sendRedirect("/cabinet/orders");
			}
		} catch (Exception e) {
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
