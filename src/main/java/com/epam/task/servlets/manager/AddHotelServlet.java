package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.HotelPhoto;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.UserService;
import com.epam.task.util.MailSender;
import com.epam.task.util.StringUtil;

@WebServlet("/add_hotel")
public class AddHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(AddHotelServlet.class);

    public AddHotelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User manager = (User) request.getSession().getAttribute("user");
		
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
		
		String hotelImagesString = request.getParameter("hotelImages");
		String sendNotifString = request.getParameter("sendNotif");
		
		if (name == null || location == null || starsString == null || description == null ||
				xCoordString == null || yCoordString == null || phoneNumber == null || hotelImagesString == null ||
				hotelImagesString.equals("error") || !StringUtil.isInStarsRange(starsString) || 
				!StringUtil.isDouble(xCoordString) || !StringUtil.isDouble(yCoordString) || !StringUtil.isBoolean(sendNotifString) || 
				!StringUtil.isBoolean(hasParkingString) || !StringUtil.isBoolean(hasPoolString) || !StringUtil.isBoolean(hasGymString) || 
				!StringUtil.isBoolean(hasSpaString) || !StringUtil.isBoolean(hasServiceString) || !StringUtil.isBoolean(hasCleanerString)) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
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
		
		int hotelId = new HotelService().insertHotel(new Hotel(0, name, location, stars, description, 
				manager.getId(), xCoord, yCoord, 0, false, phoneNumber,
				hasParking, hasPool, hasGym, hasSpa, hasService, hasCleaner));
		
		if(hotelImagesString.length() > 0 && hotelId > 0) {
			String[] hotelImagesArray = hotelImagesString.split(":::");
			HotelPhotoService hotelPhotoService = new HotelPhotoService();

			boolean main = true;
			for (int i = 0; i < hotelImagesArray.length; i++) {
				hotelPhotoService.insertHotelPhoto(new HotelPhoto(0, hotelImagesArray[i], "", hotelId, main));
				main = false;
			}
		}		
		
		if(Boolean.parseBoolean(sendNotifString) && hotelId > 0) {
			List<User> usersEmail = new UserService().getAllUsersWithEmailNotification();

			for(User user : usersEmail) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						sendMail(user, hotelId, "http://localhost:8080/booker/hotel/" + hotelId);
					}
				}).start();
			}
		}
		
		response.getWriter().write(hotelId > 0 ? ""+hotelId : "error");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void sendMail(User user, int hotelId, String href) {
		Hotel hotel = new HotelService().getHotelById(hotelId);
		
		String subject = "A new hotel was created!";
		String text = "<body style='background-color: #fff'>" +

				"<div style='width: 100%; height:20px; background-color: #00000 position: relative color:white;'>Check out a new room!"
				+ "<div style='top: 10px; background-color: white; padding:20px'>"
				+ "<div><h1 style='color: #00264d;'> Hello, " + user.getFirstName() + "</h1>" + "<p>A new \""
				+ hotel.getName() + "\" hotel was created!</p>" + "</div>"
						+ "<a href='" + href + "'>Check it out now!</a></div></div></body>";

		MailSender.send(subject, text, user.getEmail());
	}

}
