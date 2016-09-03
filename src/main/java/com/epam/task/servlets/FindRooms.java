package com.epam.task.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.task.database.model.Conveniences;
import com.epam.task.database.model.Feedback;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.HotelPhoto;
import com.epam.task.database.model.Room;
import com.epam.task.database.service.ConveniencesService;
import com.epam.task.database.service.FeedbackService;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomService;

@WebServlet("/find_rooms")
public class FindRooms extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindRooms() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Timestamp startDate;
		Timestamp endDate;
		try {
			startDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate")).getTime());
		} catch (ParseException e) {
			startDate = new Timestamp(new Date().getTime());
		}
		try {
			endDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate")).getTime());
		} catch (ParseException e) {
			endDate = new Timestamp(new Date().getTime());
		}
		session.setAttribute("startDate", startDate);
		session.setAttribute("endDate", endDate);
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		Hotel hotel = new HotelService().getHotelById(hotelId);
		Conveniences conveniences = null;
		if(hotel != null){
			conveniences = new ConveniencesService().getConveniencesForHotel(hotel.getId());
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int people = Integer.parseInt(request.getParameter("people"));
		session.setAttribute("people", people);
		
		boolean typeStandart = session.getAttribute("typeStandart") == null ? false : (boolean) session.getAttribute("typeStandart");
		boolean typeLux = session.getAttribute("typeLux") == null ? false : (boolean) session.getAttribute("typeLux");
		boolean typeDelux = session.getAttribute("typeDelux") == null ? false : (boolean) session.getAttribute("typeDelux");
		
		boolean foodNone = session.getAttribute("foodNone") == null ? false : (boolean) session.getAttribute("foodNone");
		boolean foodBreakfast = session.getAttribute("foodBreakfast") == null ? false : (boolean) session.getAttribute("foodBreakfast");
		boolean foodTwice = session.getAttribute("foodTwice") == null ? false : (boolean) session.getAttribute("foodTwice");
		boolean foodFull = session.getAttribute("foodFull") == null ? false : (boolean) session.getAttribute("foodFull");
		
		RoomService service = new RoomService();
		int minPrice = session.getAttribute("minUserPrice") == null ? service.getMinPrice() : (int) session.getAttribute("minUserPrice");
		int maxPrice = session.getAttribute("maxUserPrice") == null ? service.getMaxPrice() : (int) session.getAttribute("maxUserPrice");

		boolean hasWiFi = session.getAttribute("hasWiFi") == null ? false : (boolean) session.getAttribute("hasWiFi");
		boolean hasShower = session.getAttribute("hasShower") == null ? false : (boolean) session.getAttribute("hasShower");
		boolean hasParking = session.getAttribute("hasParking") == null ? false : (boolean) session.getAttribute("hasParking");
		boolean hasCondition = session.getAttribute("hasCondition") == null ? false : (boolean) session.getAttribute("hasCondition");
		boolean hasPool = session.getAttribute("hasPool") == null ? false : (boolean) session.getAttribute("hasPool");
		boolean hasGym = session.getAttribute("hasGym") == null ? false : (boolean) session.getAttribute("hasGym");
		boolean hasBalcony = session.getAttribute("hasBalcony") == null ? false : (boolean) session.getAttribute("hasBalcony");
		boolean noDeposit = session.getAttribute("noDeposit") == null ? false : (boolean) session.getAttribute("noDeposit");
		
		List<Feedback> feedbacks = new FeedbackService().getAllFeedbacksByHotel(hotelId);
		List<Room> rooms = new RoomService().getAllSuitableRoomsForHotel(hotelId, page, 
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull, 
				minPrice, maxPrice, people,
				hasWiFi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, noDeposit, 
				startDate, endDate);
		List<HotelPhoto> hotelPhoto = new HotelPhotoService().getHotelPhotosByHotel(hotelId); 
		request.setAttribute("hotel", hotel);
		request.setAttribute("conveniences", conveniences);
		request.setAttribute("feedbacks", feedbacks);
		request.setAttribute("rooms", rooms);
		if (hotelPhoto.size() > 0) {
			request.setAttribute("MainPhoto", hotelPhoto.get(0));
			hotelPhoto.remove(0);
			request.setAttribute("hotelPhotos", hotelPhoto);
		}
		request.getRequestDispatcher("/pages/roomCard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
