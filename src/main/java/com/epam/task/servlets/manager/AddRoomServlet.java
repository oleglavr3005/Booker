package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.RoomPhoto;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomPhotoService;
import com.epam.task.database.service.RoomService;
import com.epam.task.database.service.UserService;
import com.epam.task.util.MailSender;
import com.epam.task.util.StringUtil;

@WebServlet("/add_room")
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddRoomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String hotelIdString = request.getParameter("hotelId");
		String number = request.getParameter("number");
		String type = request.getParameter("type");	//STANDART LUX DELUX
		
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
		
		String food = request.getParameter("food");	//NONE BREAKFAST TWICE FULL
		String freeBookString = request.getParameter("freeBook");
		
		String daysCountString = request.getParameter("daysCount");
		String percentageString = request.getParameter("percentage");
				
		String roomImagesString = request.getParameter("roomImages");
		
		String sendNotifString = request.getParameter("sendNotif");
		
		if (hotelIdString == null || number == null || !number.matches("^[1-9][0-9]*[a-zA-Zа-яА-ЯіІьїЇєЄґҐ]?(, *[1-9][0-9]*[a-zA-Zа-яА-ЯіІьїЇєЄґҐ]?)*$") || 
				type == null || doubleBedsCountString == null || bedsCountString == null ||
				priceString == null || food == null || roomImagesString == null || freeBookString == null ||
				!StringUtil.isPositiveInteger(hotelIdString) || !StringUtil.isPositiveInteger(doubleBedsCountString) || !StringUtil.isPositiveInteger(bedsCountString) ||
				!StringUtil.isPositiveInteger(priceString) || !StringUtil.isBoolean(freeBookString) ||
				!(type.equalsIgnoreCase("STANDART") || type.equalsIgnoreCase("LUX") || type.equalsIgnoreCase("DELUX")) || 
				!(food.equalsIgnoreCase("NONE") || food.equalsIgnoreCase("BREAKFAST") || food.equalsIgnoreCase("TWICE") || food.equalsIgnoreCase("FULL")) ||
				!StringUtil.isBoolean(sendNotifString)) {
			response.sendError(500);
			return;
		}
		boolean freeBook = Boolean.parseBoolean(freeBookString);
		if (freeBook && (daysCountString == null || percentageString == null) ) {
			response.sendError(500);
			return;
		}
		
		if(roomImagesString.equals("error")) {
			response.sendError(500);
			return;
		}
		
		int hotelId = Integer.parseInt(hotelIdString);
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
		
		if(!freeBook) {
			daysCount = Integer.parseInt(daysCountString);
			percentage = Integer.parseInt(percentageString);
		} else {
			daysCount = -1;
			percentage = 0;
		}
		
		
		String[] numbers = number.split(", *");
		List<Integer> roomIds = new ArrayList<>();
		for(int i = 0; i<numbers.length; i++) {
			int roomId = new RoomService().insertRoom(new Room(0, hotelId, numbers[i], type, bedsCount, doubleBedsCount, price, 
					hasWifi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, food, daysCount, percentage, false));

			if(roomId > 0) {
				roomIds.add(roomId);
			}
		}

		if(roomIds.size() > 0) {
			String[] roomImagesArray = roomImagesString.split(":::");
			RoomPhotoService roomPhotoService = new RoomPhotoService();
			
			for (Integer id : roomIds) {
				for(int i = 0; i<roomImagesArray.length; i++){
					roomPhotoService.insertRoomPhoto(new RoomPhoto(0, roomImagesArray[i], "", id));
				}
			}
		}	
		
		
		if(Boolean.parseBoolean(sendNotifString) && roomIds.size() > 0) {
			List<User> usersEmail = new UserService().getAllUsersWithEmailNotificationInHotel(hotelId);
			List<User> usersPhone = new UserService().getAllUsersWithPhoneNotificationInHotel(hotelId);

			for(User user : usersEmail) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						sendMail(user, hotelId, "http://localhost:8080/booker/hotel/" + hotelId);
					}
				}).start();
			}

			for(User user : usersPhone) {
				//send sms
			}
		}
		
		response.getWriter().write(roomIds.size() > 0 ? ""+roomIds.get(0) : "error");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void sendMail(User user, int hotelId, String href) {
		Hotel hotel = new HotelService().getHotelById(hotelId);
		
		String subject = "A new room was created in " + hotel.getName() + "!";
		String text = "<body style='background-color: #fff'>" +

				"<div style='width: 100%; height:20px; background-color: #00000 position: relative color:white;'>Check out a new room!"
				+ "<div style='top: 10px; background-color: white; padding:20px'>"
				+ "<div><h1 style='color: #00264d;'> Hello, " + user.getFirstName() + "</h1>" + "<p>A new rooms were created in \""
				+ hotel.getName() + "\"! You may be interested in it, because you have orders in this hotel.</p>" + "</div>"
						+ "<a href='" + href + "'>Check it out now!</a></div></div></body>";

		MailSender.send(subject, text, user.getEmail());
	}
}
