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
		String name = "Hotel"; //get from request
		int minStars = 4; //get from request
		int maxStars = 5; //get from request
		int people = 3; //get from request
		
		boolean typeStandart = false; //get from request
		boolean typeLux = false; //get from request
		boolean typeDelux = false; //get from request

		boolean foodNone = true; //get from request
		boolean foodBreakfast = true; //get from request
		boolean foodTwice = false; //get from request
		boolean foodFull = false; //get from request
		
		int minPrice = 1; //get from request
		int maxPrice = 120; //get from request

		boolean hasWiFi = false; //get from request
		boolean hasShower = false; //get from request
		boolean hasParking = false; //get from request
		boolean hasCondition = false; //get from request
		boolean hasPool = false; //get from request
		boolean hasGym = false; //get from request
		boolean hasBalcony = false; //get from request

		boolean noDeposit = false; //get from request
		
		Timestamp startDate;
		Timestamp endDate;
		try {
			startDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse("2016-09-22").getTime());
		} catch (ParseException e) {
			startDate = new Timestamp(new Date().getTime());
		}
		try {
			endDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse("2016-09-26").getTime());
		} catch (ParseException e) {
			endDate = new Timestamp(new Date().getTime());
		}
		
		List<Hotel> suitableHotels = new HotelService().getAllSuitableHotels(name, minStars, maxStars, people, 
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull, 
				minPrice, maxPrice, 
				hasWiFi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, noDeposit, 
				startDate, endDate);
		
		for(Hotel hotel : suitableHotels) {
			System.out.println(hotel);
		}
		
		request.setAttribute("hotels", suitableHotels);
		request.setAttribute("countOfHotels", suitableHotels.size());
		
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
