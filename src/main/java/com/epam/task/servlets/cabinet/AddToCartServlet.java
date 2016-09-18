package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Order;
import com.epam.task.database.model.User;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.StringUtil;

@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(AddToCartServlet.class);

    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = ((User) session.getAttribute("user")).getId();
		String allRoomIdsString = request.getParameter("allRoomIds");
		String amountString = request.getParameter("amount");
		if (allRoomIdsString == null || !StringUtil.isPositiveInteger(amountString)) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		String[] allRoomIds = allRoomIdsString.split(":");
		int amount = Integer.parseInt(amountString);

		Timestamp startDate;
		Timestamp endDate;
		try {
			startDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("startDate").toString()).getTime());
		} catch (ParseException e) {
        	LOGGER.error("Exception while parsing date " + session.getAttribute("startDate").toString(), e);
			startDate = new Timestamp(new Date().getTime());
		}
		try {
			endDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("endDate").toString()).getTime());
		} catch (ParseException e) {
        	LOGGER.error("Exception while parsing date " + session.getAttribute("endDate").toString(), e);
			endDate = new Timestamp(new Date().getTime());
		}
		Timestamp orderDate = new Timestamp(new Date().getTime());

		int daysCount = (int)( (endDate.getTime() - startDate.getTime()) 
                / (1000 * 60 * 60 * 24) );
		
		int added = 0;
		List<Order> orders = new ArrayList<>();
		for(int i = 0; i<amount; i++) {
			
			int roomId = Integer.parseInt(allRoomIds[i]);
			int price = new RoomService().getRoomById(roomId).getPrice() * daysCount;
			
			boolean available = new RoomService().isRoomAvailable(roomId, startDate, endDate);
			if(available) {
				orders.add(new Order(0, userId, roomId, startDate, endDate, "ORDER", orderDate, price, "", ""));
			}
		}
		
		if(orders.size() == amount) {
			for(Order order : orders) {
				int result = new OrderService().insertOrder(order);
				if(result > 0) {
					added++;
				}
			}
		}
		
		response.getWriter().write(added == amount ? "true" : "false");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
