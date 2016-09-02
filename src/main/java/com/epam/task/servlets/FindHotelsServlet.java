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

import com.epam.task.database.model.Hotel;
import com.epam.task.database.service.HotelService;

@WebServlet("/search")
public class FindHotelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindHotelsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		HttpSession session = request.getSession(true);
		
		if(request.getParameter("name") == null) {
			response.sendRedirect("home");
			return;
		}
		
		String name = request.getParameter("name"); //get from request
		int minStars = (int) Double.parseDouble(request.getParameter("minStars")); //get from request
		int maxStars = (int) Double.parseDouble(request.getParameter("maxStars")); //get from request
		int people = Integer.parseInt(request.getParameter("people")); //get from request
		
		boolean typeStandart = request.getParameter("typeStandart") != null; //get from request
		boolean typeLux = request.getParameter("typeLux") != null; //get from request
		boolean typeDelux = request.getParameter("typeDelux") != null; //get from request
		
		boolean foodNone = request.getParameter("foodNone") != null; //get from request
		boolean foodBreakfast = request.getParameter("foodBreakfast") != null; //get from request
		boolean foodTwice = request.getParameter("foodTwice") != null; //get from request
		boolean foodFull = request.getParameter("foodFull") != null; //get from request
		
		int minPrice = (int) Double.parseDouble(request.getParameter("minPrice")); //get from request
		int maxPrice = (int) Double.parseDouble(request.getParameter("maxPrice")); //get from request

		boolean hasWiFi = request.getParameter("hasWifi") != null; //get from request
		boolean hasShower = request.getParameter("hasShower") != null; //get from request
		boolean hasParking = request.getParameter("hasParking") != null; //get from request
		boolean hasCondition = request.getParameter("hasCondition") != null; //get from request
		boolean hasPool = request.getParameter("hasPool") != null; //get from request
		boolean hasGym = request.getParameter("hasPym") != null; //get from request
		boolean hasBalcony = request.getParameter("hasBalcony") != null; //get from request

		boolean noDeposit = request.getParameter("noDeposit") != null; //get from request
		
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
		
		session.setAttribute("name", name);
		session.setAttribute("minStars", minStars);
		session.setAttribute("maxStars", maxStars);
		session.setAttribute("people", people);
		
		session.setAttribute("typeStandart", typeStandart);
		session.setAttribute("typeLux", typeLux);
		session.setAttribute("typeDelux", typeDelux);
		
		session.setAttribute("foodNone", foodNone);
		session.setAttribute("foodBreakfast", foodBreakfast);
		session.setAttribute("foodTwice", foodTwice);
		session.setAttribute("foodFull", foodFull);
		
		session.setAttribute("minPrice", minPrice);
		session.setAttribute("maxPrice", maxPrice);
		
		session.setAttribute("hasWiFi", hasWiFi);
		session.setAttribute("hasShower", hasShower);
		session.setAttribute("hasParking", hasParking);
		session.setAttribute("hasCondition", hasCondition);
		session.setAttribute("hasPool", hasPool);
		session.setAttribute("hasGym", hasGym);
		session.setAttribute("hasBalcony", hasBalcony);
		session.setAttribute("noDeposit", noDeposit);
		
		session.setAttribute("startDate", request.getParameter("startDate"));
		session.setAttribute("endDate", request.getParameter("endDate"));

		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		List<Hotel> suitableHotels = new HotelService().getAllSuitableHotels(name, minStars, maxStars, people, 
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull, 
				minPrice, maxPrice, 
				hasWiFi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, noDeposit, 
				startDate, endDate, page);

		request.setAttribute("hotels", suitableHotels);
		request.setAttribute("countOfHotels", suitableHotels.size());
		
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
