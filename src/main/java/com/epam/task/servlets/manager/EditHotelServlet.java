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
import com.epam.task.util.StringUtil;

@WebServlet("/edit_hotel")
public class EditHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditHotelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelIdString = request.getParameter("hotelId");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String starsString = request.getParameter("stars");
		String description = request.getParameter("description");
		String xCoordString = request.getParameter("xCoord");
		String yCoordString = request.getParameter("yCoord");
		String phoneNumber = request.getParameter("phoneNumber");
		
		if (hotelIdString == null || name == null || city == null || street == null || starsString == null || description == null ||
				xCoordString == null || yCoordString == null || phoneNumber == null ||
				!StringUtil.isPositiveInteger(hotelIdString) || !StringUtil.isInStarsRange(starsString) ||
				!StringUtil.isDouble(xCoordString) || !StringUtil.isDouble(yCoordString)) {
			response.sendError(500);
			return;
		}
		
		int hotelId = Integer.parseInt(hotelIdString);		
		int stars = Integer.parseInt(starsString);		
		double xCoord = Double.parseDouble(xCoordString);
		double yCoord = Double.parseDouble(yCoordString);
		
		HotelService hotelService = new HotelService();
		Hotel hotel = hotelService.getHotelById(hotelId);
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		if(hotel.getManagerId() != userId) {
			response.sendError(500);
			return;
		}
		hotel.setName(name);
		hotel.setCity(city);
		hotel.setStreet(street);
		hotel.setStars(stars);
		hotel.setDesc(description);
		hotel.setXCoord(xCoord);
		hotel.setYCoord(yCoord);
		hotel.setPhoneNumber(phoneNumber);
		int changed = hotelService.updateHotel(hotel);
	
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
