package com.epam.task.servlets.cabinet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.service.OrderService;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if this room has days >=0, pay somehow
		//imagine the order was payed
		//change this order by setting status "active"
		String orderIdString = request.getParameter("orderId");
		if(orderIdString == null) {
			return;
		}
		String cardNumber = request.getParameter("cardNumber");
		int orderId = Integer.parseInt(orderIdString);
		int booked = new OrderService().bookOrder(orderId, cardNumber);
		
		response.getWriter().write(booked > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
