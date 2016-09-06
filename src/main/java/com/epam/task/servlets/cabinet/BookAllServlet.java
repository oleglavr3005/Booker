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
		String cardNumber = request.getParameter("cardNumber");
		String comment = request.getParameter("comment");
		if(cardNumber == null) {
			return;
		}
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		int booked = new OrderService().bookAllByUser(userId, cardNumber, comment);
		
		response.getWriter().write(booked > 0 ? "true" : "false");
		if(booked > 0) {
			request.getRequestDispatcher("/pages/order.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
