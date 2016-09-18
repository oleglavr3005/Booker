package com.epam.task.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.task.comparators.PeopleRoomComparator;
import com.epam.task.comparators.PriceRoomComparator;
import com.epam.task.database.dto.FeedbackDto;
import com.epam.task.database.dto.RoomDto;
import com.epam.task.database.model.Feedback;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.HotelPhoto;
import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.service.FeedbackService;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;

@WebServlet("/find_rooms")
public class FindRooms extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(FindRooms.class);

    public FindRooms() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String startDateString = request.getParameter("startDate");
		String endDateString = request.getParameter("endDate");
		String hotelIdString = request.getParameter("hotelId");
		String peopleString = request.getParameter("people");
		
		if(startDateString == null || endDateString == null || !isPositiveInteger(hotelIdString) || !isPositiveInteger(peopleString)) {	
        	LOGGER.error("Invalid data injection attempt");	
			response.sendError(500);
			return;
		}
		Timestamp startDate;
		Timestamp endDate;
		try {
			startDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(startDateString).getTime());
		} catch (ParseException e) {
        	LOGGER.error("Exception while parsing date " + startDateString, e);
        	startDate = new Timestamp(new Date().getTime());
		}
		try {
			endDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(endDateString).getTime());
		} catch (ParseException e) {
        	LOGGER.error("Exception while parsing date " + endDateString, e);
			endDate = new Timestamp(new Date().getTime());
		}
		session.setAttribute("startDate", new SimpleDateFormat("yyyy-MM-dd").format(startDate));
		session.setAttribute("endDate", new SimpleDateFormat("yyyy-MM-dd").format(endDate));
		int hotelId = Integer.parseInt(hotelIdString);
		
		Hotel hotel = new HotelService().getHotelById(hotelId);
		
		int people = Integer.parseInt(peopleString);
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
		boolean hasSpa = session.getAttribute("hasSpa") == null ? false : (boolean) session.getAttribute("hasSpa");
		boolean hasService = session.getAttribute("hasService") == null ? false : (boolean) session.getAttribute("hasService");
		boolean hasCleaner = session.getAttribute("hasCleaner") == null ? false : (boolean) session.getAttribute("hasCleaner");
		boolean hasTv = session.getAttribute("hasTv") == null ? false : (boolean) session.getAttribute("hasTv");
		
		boolean noDeposit = session.getAttribute("noDeposit") == null ? false : (boolean) session.getAttribute("noDeposit");

		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		List<Room> allRooms = new RoomService().getSuitableRooms(hotelId, 
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull, 
				minPrice, maxPrice, people,
				hasWiFi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, 
				hasSpa, hasService, hasCleaner, hasTv, noDeposit, 
				startDate, endDate);
	//////MAGIC
		
		List<RoomDto> roomTemplates = new ArrayList<>();
		for (Room room : allRooms) {
			boolean exists = false;
			for (RoomDto templ : roomTemplates) {
				if (templ.getHotelId() == room.getHotelId() && templ.getType().equals(room.getType())
						&& templ.getBedsCount() == room.getBedsCount()
						&& templ.getDoubleBedsCount() == room.getDoubleBedsCount()
						&& templ.getPrice() == room.getPrice() && templ.getWifi() == room.getWifi()
						&& templ.getShower() == room.getShower() && templ.getTv() == room.getTv()
						&& templ.getCondition() == room.getCondition() && templ.getBalcony() == room.getBalcony()
						&& templ.getFood().equals(room.getFood()) && templ.getDaysCount() == room.getDaysCount()
						&& templ.getPercentage() == room.getPercentage()) {
					// if this tempalte alredy exists, add room id in it
					templ.addRoom(room.getId());
					exists = true;
					break;
				}
			}
			if (!exists) { // create template
				RoomDto template = new RoomDto(room.getHotelId(), room.getType().toString(), room.getBedsCount(),
						room.getDoubleBedsCount(), room.getPrice(), room.getWifi(), room.getShower(),
						room.getCondition(), room.getBalcony(), room.getTv(), room.getFood().toString(),
						room.getDaysCount(), room.getPercentage());
				template.addRoom(room.getId());
				roomTemplates.add(template);
			}
		}

		////// EO MAGIC

		String compareBy = request.getParameter("compareBy");
		if ("compareByPriceAsc".equals(compareBy)) {
			roomTemplates.sort(new PriceRoomComparator());
		} else if ("compareByPriceDesc".equals(compareBy)) {
			roomTemplates.sort(Collections.reverseOrder(new PriceRoomComparator()));
		} else if ("compareByPeopleAsc".equals(compareBy)) {
			roomTemplates.sort(new PeopleRoomComparator());
		} else { // compareByPeopleDesc or null
			roomTemplates.sort(Collections.reverseOrder(new PeopleRoomComparator()));
		}
			
		int countOfPages = (int) Math.ceil(roomTemplates.size() / 5.0);
		if (page > countOfPages) {
			page--;
		}
		if(page < 1) {
			page = 1;
		}
		
		List<RoomDto> roomTemplatesByPage = new ArrayList<>();
		int start = (page-1)*5;
		int end = roomTemplates.size() < start+5 ? roomTemplates.size() : start+5;
		for(int i = start; i<end; i++) {
			roomTemplatesByPage.add(roomTemplates.get(i));
		}

		User user = ((User) session.getAttribute("user"));
		if(user != null) {
			int userId = user.getId();
			//ADDED CHECK: if user has no finished orders in this hotel, he cannot leave feedback
			List<Order> finishedOrdersInHotel = new OrderService().getFinishedOrdersByUserAndHotel(userId, hotelId);
			if(finishedOrdersInHotel.isEmpty()) {
				request.setAttribute("canComment", false);
			} else {
				request.setAttribute("canComment", true);
			}
		} else {
			request.setAttribute("canComment", false);
		}

		request.setAttribute("countOfRooms", roomTemplates.size());
		request.setAttribute("countOfPages", countOfPages);
		request.setAttribute("currentPage", page);
		
		List<Feedback> feedbacks = new FeedbackService().getAllFeedbacksByHotel(hotelId);
		List<HotelPhoto> hotelPhoto = new HotelPhotoService().getHotelPhotosByHotel(hotelId); 
		
		request.setAttribute("hotel", hotel);
		request.setAttribute("feedbacks", FeedbackDto.listConverter(feedbacks));
		request.setAttribute("rooms", roomTemplatesByPage);
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

	private boolean isPositiveInteger (String stringToCheck) {
		try {
			return ((int) Double.parseDouble(stringToCheck)) > 0 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
}
