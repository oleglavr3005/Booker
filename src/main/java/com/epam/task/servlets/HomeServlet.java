package com.epam.task.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.service.HotelService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("pages/index.jsp");
		//or
		HotelService service = new HotelService();
		List<Hotel> hotels = service.getAllHotels();
		request.setAttribute("hotels", hotels);
		request.setAttribute("countOfHotels", hotels.size());
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
