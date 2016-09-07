package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Room;
import com.epam.task.database.service.RoomService;

@WebServlet("/edit_room")
public class EditRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomIdString = request.getParameter("roomId");
		String number = request.getParameter("number");
		String type = request.getParameter("type");
		
		String doubleBedsCountString = request.getParameter("doubleBedsCount");
		String bedsCountString = request.getParameter("bedsCount");
		
		String priceString = request.getParameter("price");
		
		String hasWiFiString = request.getParameter("hasWiFi");
		String hasShowerString = request.getParameter("hasShower");
		String hasParkingString = request.getParameter("hasParking");
		String hasConditionString = request.getParameter("hasCondition");
		String hasPoolString = request.getParameter("hasPool");
		String hasGymString = request.getParameter("hasGym");
		String hasBalconyString = request.getParameter("hasBalcony");
		
		String food = request.getParameter("food");

		String freeBook = request.getParameter("freeBook");
		
		if (roomIdString == null || number == null || type == null || doubleBedsCountString == null || bedsCountString == null ||
				priceString == null || food == null || freeBook == null) {
			return;
		}

		int roomId = Integer.parseInt(roomIdString);
		int doubleBedsCount = Integer.parseInt(doubleBedsCountString);
		int bedsCount = Integer.parseInt(bedsCountString);
		int price = Integer.parseInt(priceString);
		
		boolean hasWifi = Boolean.parseBoolean(hasWiFiString);
		boolean hasShower = Boolean.parseBoolean(hasShowerString);
		boolean hasParking = Boolean.parseBoolean(hasParkingString);
		boolean hasCondition = Boolean.parseBoolean(hasConditionString);
		boolean hasPool = Boolean.parseBoolean(hasPoolString);
		boolean hasGym = Boolean.parseBoolean(hasGymString);
		boolean hasBalcony = Boolean.parseBoolean(hasBalconyString);
		int daysCount;
		int percentage;
		
		if(!Boolean.parseBoolean(freeBook)) {
			daysCount = Integer.parseInt(request.getParameter("daysCount"));
			percentage = Integer.parseInt(request.getParameter("percentage"));
		} else {
			daysCount = -1;
			percentage = 0;
		}
		
		RoomService roomService = new RoomService();
		Room room = roomService.getRoomById(roomId);
		room.setNumber(number);
		room.setType(type);
		room.setBedsCount(bedsCount);
		room.setDoubleBedsCount(doubleBedsCount);
		room.setPrice(price);
		room.setFood(food);
		
		room.setWifi(hasWifi);
		room.setShower(hasShower);
		room.setParking(hasParking);
		room.setCondition(hasCondition);
		room.setPool(hasPool);
		room.setGym(hasGym);
		room.setBalcony(hasBalcony);

		room.setDaysCount(daysCount);
		room.setPercentage(percentage);
		
		int changed = roomService.updateRoom(room);
	
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
