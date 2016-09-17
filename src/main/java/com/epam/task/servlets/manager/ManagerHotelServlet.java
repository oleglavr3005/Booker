package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomService;

@WebServlet("/cabinet/my_hotels/*")
public class ManagerHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ManagerHotelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User manager = (User) request.getSession().getAttribute("user");

		int id;
		try {
			id = Integer.parseInt(request.getPathInfo().substring(1));
		} catch (Exception e) {
			return;
		}
		
		Hotel hotel = new HotelService().getHotelById(id);
		if(hotel == null || hotel.getManagerId() != manager.getId() ){
			response.sendError(500);
			return;
		}

		request.setAttribute("hotel", hotel);
		request.setAttribute("rooms", new RoomService().getAllRoomsForHotel(id));
		
		request.getRequestDispatcher("/pages/manager/hotelEdit.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
