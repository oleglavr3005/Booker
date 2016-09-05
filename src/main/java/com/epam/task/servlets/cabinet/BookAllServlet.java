package com.epam.task.servlets.cabinet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.User;
import com.epam.task.database.service.OrderService;

@WebServlet("/book_all")
public class BookAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO:
		//if total price > 0, pay somehow
		//imagine all orders were payed
		//change all orders with status "order" to "active"
		String cardNumber = request.getParameter("cardNumber");
		if(cardNumber == null) {
			return;
		}
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		int booked = new OrderService().bookAllByUser(userId, cardNumber);
		
		response.getWriter().write(booked > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
