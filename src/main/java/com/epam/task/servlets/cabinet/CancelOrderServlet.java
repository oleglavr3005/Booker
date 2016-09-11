package com.epam.task.servlets.cabinet;

import java.io.IOException;
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
import com.epam.task.util.MailSender;
import com.epam.task.util.StringUtil;

@WebServlet("/cancel_order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CancelOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderIdString = request.getParameter("orderId");
		if (orderIdString == null || !StringUtil.isPositiveInteger(orderIdString)) {
			response.sendError(500);
			return;
		}

		User user = ((User) request.getSession().getAttribute("user"));
		int orderId = Integer.parseInt(orderIdString);
		OrderService service = new OrderService();
		Order order = service.getOrderById(orderId);
		if (order.getUserId() != user.getId()) {
			response.sendError(500);
			return;
		}
		Room room = new RoomService().getRoomById(order.getRoomId());

		int days = room.getDaysCount();

		if (days > -1) { // do some stuff with money
			int daysLeft = (int) ((order.getStartDate().getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24));

			int moneyToReturn;
			if (daysLeft >= days) { // return all money and cancel
				moneyToReturn = order.getPrice() / 2; // we are paying a half of
														// the sum
			} else { // return %
				moneyToReturn = (order.getPrice() / 200) * room.getPercentage(); // same
																					// as
																					// above
			}
			String email = user.getEmail();
			String phone = user.getPhoneNumber();
			if (email != null) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						sendMail(user, order, moneyToReturn);
					}
				}).start();
			}
			if (phone != null) {
				// TODO: SEND SMS WITH moneyToReturn
			}
		}
		order.setStatus(OrderStatus.CANCELED);
		int result = service.updateOrder(order);
		response.getWriter().write(result > 0 ? "true" : "false");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void sendMail(User user, Order order, int money) {
		String subject = "Order was canceled";
		String moneyLine = "You will get your refund on card \""
				+ order.getCardNumber() + "\" in amount of " + money + "";
		if (money == 0){
			moneyLine = "";
		}
		String text = "<body style='background-color: #fff'>" +

				"<div style='width: 100%; height:20px; background-color: #00000 position: relative color:white;'>Order was canceled"
				+ "<div style='top: 10px; background-color: white; padding:20px'>"
				+ "<div><h1 style='color: #00264d;'> Hello, " + user.getFirstName() + "</h1>" + "<p>Your order #"
				+ order.getId() + " was succesfully canceled." + moneyLine + "</p>" + "</div><div id='one'><p>"
				+ "<p></div></div></div></body>";

		MailSender.send(subject, text, user.getEmail());
	}

}
