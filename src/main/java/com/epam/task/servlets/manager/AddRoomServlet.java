package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Room;
import com.epam.task.database.model.RoomPhoto;
import com.epam.task.database.service.RoomPhotoService;
import com.epam.task.database.service.RoomService;

@WebServlet("/add_room")
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String hotelIdString = request.getParameter("hotelId");
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
		
		String roomImagesString = request.getParameter("roomImages");
		
		String food = request.getParameter("food");

		String freeBook = request.getParameter("freeBook");
		
		if (hotelIdString == null || number == null || type == null || doubleBedsCountString == null || bedsCountString == null ||
				priceString == null || food == null || roomImagesString == null) {
			return;
		}
		
		if(roomImagesString.equals("error")) {
			response.sendError(500);
			return;
		}
		
		String[] roomImagesArray = roomImagesString.split(":::");
		
		int hotelId = Integer.parseInt(hotelIdString);
		int doubleBedsCount = Integer.parseInt(doubleBedsCountString);
		int bedsCount = Integer.parseInt(bedsCountString);
		int price = Integer.parseInt(priceString);
		
		boolean hasWifi = hasWiFiString == null ? false : true;
		boolean hasShower = hasShowerString == null ? false : true;
		boolean hasParking = hasParkingString == null ? false : true;
		boolean hasCondition = hasConditionString == null ? false : true;
		boolean hasPool = hasPoolString == null ? false : true;
		boolean hasGym = hasGymString == null ? false : true;
		boolean hasBalcony = hasBalconyString == null ? false : true;
		int daysCount;
		int percentage;
		
		if(freeBook != null) {
			daysCount = Integer.parseInt(request.getParameter("daysCount"));
			percentage = Integer.parseInt(request.getParameter("percentage"));
		} else {
			daysCount = -1;
			percentage = 0;
		}
		
		int roomId = new RoomService().insertRoom(new Room(0, hotelId, number, type, bedsCount, doubleBedsCount, price, 
				hasWifi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, food, daysCount, percentage, false));

		RoomPhotoService roomPhotoService = new RoomPhotoService();
		if (roomId > 0) {
			for (int i = 0; i<roomImagesArray.length; i++) {
				roomPhotoService.insertRoomPhoto(new RoomPhoto(0, roomImagesArray[i], "", roomId));
			}
		}
		
		response.getWriter().write(roomId > 0 ? ""+roomId : "error");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
