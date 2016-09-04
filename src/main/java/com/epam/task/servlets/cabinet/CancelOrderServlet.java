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
			
			if (daysLeft >= days) { //return all money and cancel
				int moneyToReturn = order.getPrice(); 	//if we are paying the whole sum (like we are doing now)
														//if we are paying a half of the sum (like I want to), 
														//than change this value
			} else { //return %
				int moneyToReturn = (order.getPrice() / 100) * room.getPercentage(); //same as above
			}
			//TODO: RETURN MONEY
		}
		
		order.setStatus(OrderStatus.CANCELED);
		int result = service.updateOrder(order);
		response.getWriter().write(result > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
