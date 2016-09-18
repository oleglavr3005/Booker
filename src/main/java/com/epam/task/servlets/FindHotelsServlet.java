package com.epam.task.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.StringUtil;

@WebServlet("/search")
public class FindHotelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(FindHotelsServlet.class);

    public FindHotelsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		HttpSession session = request.getSession(true);
		
		if(request.getParameter("flag") == null || !request.getParameter("flag").equals("true")) {
			
			if(request.getParameter("name") == null ) {
	        	LOGGER.error("Invalid data injection attempt");
				response.sendError(500);
				return;
			}
			
			RoomService roomService = new RoomService();
			String toglerString = request.getParameter("togler");
			boolean togler;
			if (toglerString == null) {
				togler = false;
			} else {
				togler = Boolean.parseBoolean(toglerString);
			}
			
			String minStarsString = request.getParameter("minStars");
			String maxStarsString = request.getParameter("maxStars");
			String peopleString = request.getParameter("people");
			String minUserPriceString = request.getParameter("minUserPrice");
			String maxUserPriceString = request.getParameter("maxUserPrice");
			
			if(!StringUtil.isInStarsRangeOrNull(minStarsString) || !StringUtil.isInStarsRangeOrNull(maxStarsString) || !StringUtil.isPositiveIntegerOrNull(peopleString) ||
					!StringUtil.isPositiveIntegerOrNull(minUserPriceString) || !StringUtil.isPositiveIntegerOrNull(maxUserPriceString)) {	
	        	LOGGER.error("Invalid data injection attempt");			
				response.sendError(500);
				return;
			}

			session.setAttribute("togler", togler);
			
			session.setAttribute("name", request.getParameter("name"));
			
			session.setAttribute("minStars", minStarsString == null ? 1 : (int) Double.parseDouble(minStarsString));
			session.setAttribute("maxStars", maxStarsString == null ? 5 : (int) Double.parseDouble(maxStarsString));
			session.setAttribute("people", peopleString == null ? 1 : Integer.parseInt(peopleString));
			
			session.setAttribute("typeStandart", togler == true? request.getParameter("typeStandart") != null : false);
			session.setAttribute("typeLux", togler == true? request.getParameter("typeLux") != null : false);
			session.setAttribute("typeDelux", togler == true? request.getParameter("typeDelux") != null : false);
			
			session.setAttribute("foodNone", togler == true? request.getParameter("foodNone") != null : false);
			session.setAttribute("foodBreakfast", togler == true? request.getParameter("foodBreakfast") != null : false);
			session.setAttribute("foodTwice", togler == true? request.getParameter("foodTwice") != null : false);
			session.setAttribute("foodFull", togler == true? request.getParameter("foodFull") != null : false);
			
			session.setAttribute("minUserPrice", togler == true? (int) Double.parseDouble(minUserPriceString) : roomService.getMinPrice());
			session.setAttribute("maxUserPrice", togler == true? (int) Double.parseDouble(maxUserPriceString) : roomService.getMaxPrice());
			
			session.setAttribute("hasWiFi", togler == true? request.getParameter("hasWifi") != null : false);
			session.setAttribute("hasShower", togler == true? request.getParameter("hasShower") != null : false);
			session.setAttribute("hasParking", togler == true? request.getParameter("hasParking") != null : false);
			session.setAttribute("hasCondition", togler == true? request.getParameter("hasCondition") != null : false);
			session.setAttribute("hasPool", togler == true? request.getParameter("hasPool") != null : false);
			session.setAttribute("hasGym", togler == true? request.getParameter("hasGym") != null : false);
			session.setAttribute("hasBalcony", togler == true? request.getParameter("hasBalcony") != null : false);
			session.setAttribute("hasSpa", togler == true? request.getParameter("hasSpa") != null : false);
			session.setAttribute("hasService", togler == true? request.getParameter("hasService") != null : false);
			session.setAttribute("hasCleaner", togler == true? request.getParameter("hasCleaner") != null : false);
			session.setAttribute("hasTv", togler == true? request.getParameter("hasTv") != null : false);
			
			session.setAttribute("noDeposit", togler == true? request.getParameter("noDeposit") != null : false);
			
			String startDateString = request.getParameter("startDate");
			String endDateString = request.getParameter("endDate");
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			String currentDateString = format.format(calendar.getTime());
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			String tomorrowDateString = format.format(calendar.getTime());
			session.setAttribute("startDate", startDateString == null ? currentDateString : startDateString);
			session.setAttribute("endDate", endDateString == null ? tomorrowDateString : endDateString);
			
			session.setAttribute("minPrice", roomService.getMinPrice());
			session.setAttribute("maxPrice", roomService.getMaxPrice());
		}
		
		Timestamp startDate;
		Timestamp endDate;
		try {
			startDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("startDate").toString()).getTime());
		} catch (ParseException e) {
        	LOGGER.error("Exception while parsing date " + session.getAttribute("startDate").toString(), e);
			startDate = new Timestamp(new Date().getTime());
		}
		try {
			endDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("endDate").toString()).getTime());
		} catch (ParseException e) {
        	LOGGER.error("Exception while parsing date " + session.getAttribute("endDate").toString(), e);
			endDate = new Timestamp(new Date().getTime());
		}
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		List<Hotel> allHotels = new HotelService().getAllSuitableHotels(session.getAttribute("name").toString(), 
				(int) session.getAttribute("minStars"), (int) session.getAttribute("maxStars"), (int) session.getAttribute("people"), 
				(boolean) session.getAttribute("typeStandart"), (boolean) session.getAttribute("typeLux"), (boolean) session.getAttribute("typeDelux"), 
				(boolean) session.getAttribute("foodNone"), (boolean) session.getAttribute("foodBreakfast"), 
				(boolean) session.getAttribute("foodTwice"), (boolean) session.getAttribute("foodFull"), 
				(int) session.getAttribute("minUserPrice"), (int) session.getAttribute("maxUserPrice"), 
				(boolean) session.getAttribute("hasWiFi"), (boolean) session.getAttribute("hasShower"), (boolean) session.getAttribute("hasParking"), 
				(boolean) session.getAttribute("hasCondition"), (boolean) session.getAttribute("hasPool"), (boolean) session.getAttribute("hasGym"), 
				(boolean) session.getAttribute("hasBalcony"), (boolean) session.getAttribute("hasSpa"), 
				(boolean) session.getAttribute("hasService"), (boolean) session.getAttribute("hasCleaner"), 
				(boolean) session.getAttribute("hasTv"), (boolean) session.getAttribute("noDeposit"), 
				startDate, endDate);
		
		int countOfHotels = allHotels.size();
		int countOfPages = (int) Math.ceil(countOfHotels / 5.0);
		if (page > countOfPages) {
			page--;
		}
		
		request.setAttribute("countOfHotels", countOfHotels);
		request.setAttribute("countOfPages", countOfPages);
		request.setAttribute("currentPage", page);

		String compareBy = request.getParameter("compareBy");
		List<Hotel> suitableHotels = new HotelService().getAllSuitableHotelsByPage(session.getAttribute("name").toString(), 
				(int) session.getAttribute("minStars"), (int) session.getAttribute("maxStars"), 
				(int) session.getAttribute("people"), 
				(boolean) session.getAttribute("typeStandart"), (boolean) session.getAttribute("typeLux"), (boolean) session.getAttribute("typeDelux"), 
				(boolean) session.getAttribute("foodNone"), (boolean) session.getAttribute("foodBreakfast"), 
				(boolean) session.getAttribute("foodTwice"), (boolean) session.getAttribute("foodFull"), 
				(int) session.getAttribute("minUserPrice"), (int) session.getAttribute("maxUserPrice"), 
				(boolean) session.getAttribute("hasWiFi"), (boolean) session.getAttribute("hasShower"), (boolean) session.getAttribute("hasParking"), 
				(boolean) session.getAttribute("hasCondition"), (boolean) session.getAttribute("hasPool"), (boolean) session.getAttribute("hasGym"), 
				(boolean) session.getAttribute("hasBalcony"), (boolean) session.getAttribute("hasSpa"), 
				(boolean) session.getAttribute("hasService"), (boolean) session.getAttribute("hasCleaner"), 
				(boolean) session.getAttribute("hasTv"), (boolean) session.getAttribute("noDeposit"), 
				startDate, endDate, page, compareBy);
		
		request.setAttribute("suitableHotels", suitableHotels);
		
		if(request.getParameter("flag") != null && request.getParameter("flag").equals("true")) {
			request.getRequestDispatcher("pages/card.jsp").forward(request, response);
		} else {
			request.setAttribute("hotels", allHotels);
			request.getRequestDispatcher("pages/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
