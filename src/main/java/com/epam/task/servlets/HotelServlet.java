package com.epam.task.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Conveniences;
import com.epam.task.database.model.Feedback;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Room;
import com.epam.task.database.service.ConveniencesService;
import com.epam.task.database.service.FeedbackService;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomService;

@WebServlet("/hotel/*")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(HotelServlet.class);

	public HotelServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hotelId = request.getPathInfo().substring(1);
		if(hotelId.length() > 1) {
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(hotelId);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Bad user id for hotel");
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		Hotel hotel = new HotelService().getHotelById(id);
		Conveniences conveniences = null;
		if(hotel != null){
			conveniences = new ConveniencesService().getConveniencesForHotel(hotel.getId());
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			LOGGER.info("Bad user id for hotel, hotel not found");
			return;
		}
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		HttpSession session = request.getSession(true);
		boolean typeStandart = session.getAttribute("typeStandart") == null ? false : (boolean) session.getAttribute("typeStandart");
		boolean typeLux = session.getAttribute("typeLux") == null ? false : (boolean) session.getAttribute("typeLux");
		boolean typeDelux = session.getAttribute("typeDelux") == null ? false : (boolean) session.getAttribute("typeDelux");
				
		boolean foodNone = session.getAttribute("foodNone") == null ? false : (boolean) session.getAttribute("foodNone");
		boolean foodBreakfast = session.getAttribute("foodBreakfast") == null ? false : (boolean) session.getAttribute("foodBreakfast");
		boolean foodTwice = session.getAttribute("foodTwice") == null ? false : (boolean) session.getAttribute("foodTwice");
		boolean foodFull = session.getAttribute("foodFull") == null ? false : (boolean) session.getAttribute("foodFull");
		
		RoomService roomService = new RoomService();
		int minPrice = session.getAttribute("minUserPrice") == null ? roomService.getMinPrice() : (int) session.getAttribute("minUserPrice");
		int maxPrice = session.getAttribute("maxUserPrice") == null ? roomService.getMaxPrice() : (int) session.getAttribute("maxUserPrice");
		int people = session.getAttribute("people") == null ? 1 : (int) session.getAttribute("people");
		
		boolean hasWiFi = session.getAttribute("hasWiFi") == null ? false : (boolean) session.getAttribute("hasWiFi");
		boolean hasShower = session.getAttribute("hasShower") == null ? false : (boolean) session.getAttribute("hasShower");
		boolean hasParking = session.getAttribute("hasParking") == null ? false : (boolean) session.getAttribute("hasParking");
		boolean hasCondition = session.getAttribute("hasCondition") == null ? false : (boolean) session.getAttribute("hasCondition");
		boolean hasPool = session.getAttribute("hasPool") == null ? false : (boolean) session.getAttribute("hasPool");
		boolean hasGym = session.getAttribute("hasGym") == null ? false : (boolean) session.getAttribute("hasGym");
		boolean hasBalcony = session.getAttribute("hasBalcony") == null ? false : (boolean) session.getAttribute("hasBalcony");
		boolean noDeposit = session.getAttribute("noDeposit") == null ? false : (boolean) session.getAttribute("noDeposit");
		
		Timestamp startDate;
		Timestamp endDate;
		try {
			startDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("startDate").toString()).getTime());
		} catch (Exception e) {
			startDate = new Timestamp(0);
		}
		try {
			endDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("endDate").toString()).getTime());
		} catch (Exception e) {
			endDate = new Timestamp(0);
		}
		
		List<Feedback> feedbacks = new FeedbackService().getAllFeedbacksByHotel(id);
		List<Room> rooms = new RoomService().getAllSuitableRoomsForHotel(id, page, 
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull, 
				minPrice, maxPrice, people,
				hasWiFi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, noDeposit, 
				startDate, endDate);
		request.setAttribute("hotel", hotel);
		request.setAttribute("conveniences", conveniences);
		request.setAttribute("feedbacks", feedbacks);
		request.setAttribute("rooms", rooms);
		if (hotel.getPhotos().size() > 0) {
			request.setAttribute("MainPhoto", hotel.getPhotos().get(0));
			hotel.getPhotos().remove(0);
			request.setAttribute("hotelPhotos", hotel.getPhotos());
		}
		request.getRequestDispatcher("/pages/hotel.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
