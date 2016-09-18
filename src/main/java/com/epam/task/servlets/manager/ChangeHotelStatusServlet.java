package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.util.StringUtil;

@WebServlet("/change_hotel_status")
public class ChangeHotelStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ChangeHotelStatusServlet.class);

    public ChangeHotelStatusServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelIdString = request.getParameter("hotelId");
		String deletedString = request.getParameter("deleted"); //true or false
		
		if(hotelIdString == null || deletedString == null || 
				!StringUtil.isPositiveInteger(hotelIdString) || !StringUtil.isBoolean(deletedString)) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		int hotelId = Integer.parseInt(hotelIdString);
		boolean deleted = Boolean.parseBoolean(deletedString);
		
		HotelService hotelService = new HotelService();
		Hotel hotel = hotelService.getHotelById(hotelId);
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		if(hotel.getManagerId() != userId) {
			response.sendError(500);
			return;
		}
		hotel.setDeleted(deleted);
		int changed = hotelService.updateHotel(hotel);
		
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
