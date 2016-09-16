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
		String location = request.getParameter("location");
		String starsString = request.getParameter("stars");
		String description = request.getParameter("description");
		String xCoordString = request.getParameter("xCoord");
		String yCoordString = request.getParameter("yCoord");
		String phoneNumber = request.getParameter("phoneNumber");

		String hasParkingString = request.getParameter("hasParking");
		String hasPoolString = request.getParameter("hasPool");
		String hasGymString = request.getParameter("hasGym");
		String hasSpaString = request.getParameter("hasSpa");
		String hasServiceString = request.getParameter("hasService");
		String hasCleanerString = request.getParameter("hasCleaner");

		String deletedString = request.getParameter("deleted"); //true or false
		
		if (hotelIdString == null || name == null || location == null || starsString == null || description == null ||
				xCoordString == null || yCoordString == null || phoneNumber == null ||
				!StringUtil.isPositiveInteger(hotelIdString) || !StringUtil.isInStarsRange(starsString) ||
				!StringUtil.isDouble(xCoordString) || !StringUtil.isDouble(yCoordString) || !StringUtil.isBoolean(deletedString) ||
				!StringUtil.isBoolean(hasParkingString) || !StringUtil.isBoolean(hasPoolString) || !StringUtil.isBoolean(hasGymString) || 
				!StringUtil.isBoolean(hasSpaString) || !StringUtil.isBoolean(hasServiceString) || !StringUtil.isBoolean(hasCleanerString)) {
			response.sendError(500);
			return;
		}
		HotelService hotelService = new HotelService();
		int hotelId = Integer.parseInt(hotelIdString);	

		Hotel hotel = hotelService.getHotelById(hotelId);
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		if(hotel.getManagerId() != userId) {
			response.sendError(500);
			return;
		}
		
		if(Boolean.parseBoolean(deletedString)) {
			int changed = hotelService.removeHotel(hotelId);
			response.getWriter().write(changed > 0 ? "true" : "false");
			return;
		}
			
		int stars = Integer.parseInt(starsString);		
		double xCoord = Double.parseDouble(xCoordString);
		double yCoord = Double.parseDouble(yCoordString);

		boolean hasParking = Boolean.parseBoolean(hasParkingString);
		boolean hasPool = Boolean.parseBoolean(hasPoolString);
		boolean hasGym = Boolean.parseBoolean(hasGymString);
		boolean hasSpa = Boolean.parseBoolean(hasSpaString);
		boolean hasService = Boolean.parseBoolean(hasServiceString);
		boolean hasCleaner = Boolean.parseBoolean(hasCleanerString);
		
		hotel.setName(name);
		hotel.setLocation(location);
		hotel.setStars(stars);
		hotel.setDesc(description);
		hotel.setXCoord(xCoord);
		hotel.setYCoord(yCoord);
		hotel.setPhoneNumber(phoneNumber);
		
		hotel.setParking(hasParking);
		hotel.setPool(hasPool);
		hotel.setGym(hasGym);
		hotel.setSpa(hasSpa);
		hotel.setService(hasService);
		hotel.setCleaner(hasCleaner);
		
		hotel.setDeleted(Boolean.parseBoolean(deletedString));
		int changed = hotelService.updateHotel(hotel);
	
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
