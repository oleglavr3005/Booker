package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.StringUtil;

@WebServlet("/edit_room")
public class EditRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(EditRoomServlet.class);

    public EditRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomIdString = request.getParameter("roomId");
		String number = request.getParameter("number");
		String type = request.getParameter("type");	//STANDART LUX DELUX
		
		String doubleBedsCountString = request.getParameter("doubleBedsCount");
		String bedsCountString = request.getParameter("bedsCount");
		
		String priceString = request.getParameter("price");
		
		String hasWiFiString = request.getParameter("hasWiFi");
		String hasShowerString = request.getParameter("hasShower");
		String hasConditionString = request.getParameter("hasCondition");
		String hasBalconyString = request.getParameter("hasBalcony");
		String hasTvString = request.getParameter("hasTv");
		
		String food = request.getParameter("food");	//NONE BREAKFAST TWICE FULL

		String freeBookString = request.getParameter("freeBook");
		
		String daysCountString = request.getParameter("daysCount");
		String percentageString = request.getParameter("percentage");

		String deletedString = request.getParameter("deleted"); //true or false
		
		if (roomIdString == null || number == null || type == null || doubleBedsCountString == null || bedsCountString == null ||
				priceString == null || food == null || freeBookString == null ||
				!StringUtil.isPositiveInteger(roomIdString) || !StringUtil.isNotNegativeInteger(doubleBedsCountString) || !StringUtil.isNotNegativeInteger(bedsCountString) ||
				!StringUtil.isNotNegativeInteger(priceString) || !StringUtil.isBoolean(freeBookString) ||
				!(type.equalsIgnoreCase("STANDART") || type.equalsIgnoreCase("LUX") || type.equalsIgnoreCase("DELUX")) || 
				!(food.equalsIgnoreCase("NONE") || food.equalsIgnoreCase("BREAKFAST") || food.equalsIgnoreCase("TWICE") || food.equalsIgnoreCase("FULL")) ||
				!StringUtil.isBoolean(deletedString) || !StringUtil.isBoolean(hasWiFiString) || !StringUtil.isBoolean(hasShowerString) ||
				!StringUtil.isBoolean(hasConditionString) || !StringUtil.isBoolean(hasBalconyString) || !StringUtil.isBoolean(hasTvString)) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		int roomId = Integer.parseInt(roomIdString);
		
		RoomService roomService = new RoomService();
		
		Room room = roomService.getRoomById(roomId);
		Hotel hotel = new HotelService().getHotelById(room.getHotelId());
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		if(hotel.getManagerId() != userId) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		if(Boolean.parseBoolean(deletedString)) {
			int changed = roomService.removeRoom(roomId);
			response.getWriter().write(changed > 0 ? "true" : "false");
			return;
		}
		
		boolean freeBook = Boolean.parseBoolean(freeBookString);
		if (freeBook && (daysCountString == null || percentageString == null) ) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}

		int doubleBedsCount = Integer.parseInt(doubleBedsCountString);
		int bedsCount = Integer.parseInt(bedsCountString);
		int price = Integer.parseInt(priceString);
		
		boolean hasWifi = Boolean.parseBoolean(hasWiFiString);
		boolean hasShower = Boolean.parseBoolean(hasShowerString);
		boolean hasCondition = Boolean.parseBoolean(hasConditionString);
		boolean hasBalcony = Boolean.parseBoolean(hasBalconyString);
		boolean hasTv = Boolean.parseBoolean(hasTvString);
		int daysCount;
		int percentage;
		
		if(!freeBook) {
			daysCount = Integer.parseInt(daysCountString);
			percentage = Integer.parseInt(percentageString);
		} else {
			daysCount = -1;
			percentage = 0;
		}
		
		room.setNumber(number);
		room.setType(type);
		room.setBedsCount(bedsCount);
		room.setDoubleBedsCount(doubleBedsCount);
		room.setPrice(price);
		room.setFood(food);
		
		room.setWifi(hasWifi);
		room.setShower(hasShower);
		room.setCondition(hasCondition);
		room.setBalcony(hasBalcony);
		room.setTv(hasTv);

		room.setDaysCount(daysCount);
		room.setPercentage(percentage);
		
		room.setDeleted(Boolean.parseBoolean(deletedString));
		
		int changed = roomService.updateRoom(room);
	
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
