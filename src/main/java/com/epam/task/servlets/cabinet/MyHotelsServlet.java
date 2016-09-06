package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;

@WebServlet("/cabinet/my_hotels")
public class MyHotelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyHotelsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");

		HotelService hotelService = new HotelService();
		int countOfHotels = hotelService.getAllHotelsByManager(user.getId()).size();

		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		int countOfPages = (int) Math.ceil(countOfHotels / 3.0);
		if (page > countOfPages) {
			page--;
		}

		String compareBy = request.getParameter("compareBy");
		List<Hotel> hotels = new HotelService().getAllHotelsByManagerAndPage(user.getId(), page, compareBy);

		request.setAttribute("countOfHotels", countOfHotels);
		request.setAttribute("countOfPages", countOfPages);
		request.setAttribute("hotels", hotels);
		request.setAttribute("currentPage", page);
		
		if(request.getParameter("flag") != null && request.getParameter("flag").equals("true")) {
			request.getRequestDispatcher("/pages/card.jsp").forward(request, response);
		} else {	
			request.getRequestDispatcher("/pages/manager/hotelList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
