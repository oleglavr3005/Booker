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

import com.epam.task.database.model.Hotel;
import com.epam.task.database.service.HotelService;

@WebServlet("/search")
public class FindHotelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindHotelsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		String name = request.getParameter("name"); //get from request
		int minStars = (int) Double.parseDouble(request.getParameter("minStars")); //get from request
		int maxStars = (int) Double.parseDouble(request.getParameter("maxStars")); //get from request
		int people = Integer.parseInt(request.getParameter("people")); //get from request
		
		boolean typeStandart = Boolean.parseBoolean(request.getParameter("typeStandart")); //get from request
		boolean typeLux = Boolean.parseBoolean(request.getParameter("typeLux")); //get from request
		boolean typeDelux = Boolean.parseBoolean(request.getParameter("typeDelux")); //get from request

		boolean foodNone = Boolean.parseBoolean(request.getParameter("foodNone")); //get from request
		boolean foodBreakfast = Boolean.parseBoolean(request.getParameter("foodBreakfast")); //get from request
		boolean foodTwice = Boolean.parseBoolean(request.getParameter("foodTwice")); //get from request
		boolean foodFull = Boolean.parseBoolean(request.getParameter("foodFull")); //get from request
		
		int minPrice = (int) Double.parseDouble(request.getParameter("minPrice")); //get from request
		int maxPrice = (int) Double.parseDouble(request.getParameter("maxPrice")); //get from request

		boolean hasWiFi = Boolean.parseBoolean(request.getParameter("wifi")); //get from request
		boolean hasShower = Boolean.parseBoolean(request.getParameter("shower")); //get from request
		boolean hasParking = Boolean.parseBoolean(request.getParameter("parking")); //get from request
		boolean hasCondition = Boolean.parseBoolean(request.getParameter("condition")); //get from request
		boolean hasPool = Boolean.parseBoolean(request.getParameter("pool")); //get from request
		boolean hasGym = Boolean.parseBoolean(request.getParameter("gym")); //get from request
		boolean hasBalcony = Boolean.parseBoolean(request.getParameter("balcony")); //get from request

		boolean noDeposit = Boolean.parseBoolean(request.getParameter("no_deposit")); //get from request
		
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

		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		List<Hotel> suitableHotels = new HotelService().getAllSuitableHotels(name, minStars, maxStars, people, 
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull, 
				minPrice, maxPrice, 
				hasWiFi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, noDeposit, 
				startDate, endDate, page);
		
//		for(Hotel hotel : suitableHotels) {
//			System.out.println(hotel);
//		}
		
		request.setAttribute("hotels", suitableHotels);
		request.setAttribute("countOfHotels", suitableHotels.size());
		
		request.getRequestDispatcher("pages/card.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
