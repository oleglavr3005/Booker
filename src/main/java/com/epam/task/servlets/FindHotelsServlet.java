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
import com.epam.task.database.service.RoomService;

@WebServlet("/search")
public class FindHotelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindHotelsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		HttpSession session = request.getSession(true);
		
		if(request.getParameter("flag") == null || !request.getParameter("flag").equals("true")) {
			
			if(request.getParameter("name") == null || request.getParameter("name").equals("") ||
					request.getParameter("people").equals("") || request.getParameter("startDate").equals("") || request.getParameter("endDate").equals("")) {
				response.sendRedirect("home");
				return;
			}
			
			RoomService roomService = new RoomService();
			boolean togler = Boolean.parseBoolean(request.getParameter("togler"));
			
			String name = request.getParameter("name"); //get from request
			int minStars = (int) Double.parseDouble(request.getParameter("minStars")); //get from request
			int maxStars = (int) Double.parseDouble(request.getParameter("maxStars")); //get from request
			int people = Integer.parseInt(request.getParameter("people")); //get from request
			
			boolean typeStandart = togler == true? request.getParameter("typeStandart") != null : false; //get from request
			boolean typeLux = togler == true? request.getParameter("typeLux") != null : false; //get from request
			boolean typeDelux = togler == true? request.getParameter("typeDelux") != null : false; //get from request
			
			boolean foodNone = togler == true? request.getParameter("foodNone") != null : false; //get from request
			boolean foodBreakfast = togler == true? request.getParameter("foodBreakfast") != null : false; //get from request
			boolean foodTwice = togler == true? request.getParameter("foodTwice") != null : false; //get from request
			boolean foodFull = togler == true? request.getParameter("foodFull") != null : false; //get from request
			
			int minPrice = togler == true? (int) Double.parseDouble(request.getParameter("minUserPrice")) : roomService.getMinPrice(); //get from request
			int maxPrice = togler == true? (int) Double.parseDouble(request.getParameter("maxUserPrice")) : roomService.getMaxPrice(); //get from request
			
			boolean hasWiFi = togler == true? request.getParameter("hasWifi") != null : false; //get from request
			boolean hasShower = togler == true? request.getParameter("hasShower") != null : false; //get from request
			boolean hasParking = togler == true? request.getParameter("hasParking") != null : false; //get from request
			boolean hasCondition = togler == true? request.getParameter("hasCondition") != null : false; //get from request
			boolean hasPool = togler == true? request.getParameter("hasPool") != null : false; //get from request
			boolean hasGym = togler == true? request.getParameter("hasPym") != null : false; //get from request
			boolean hasBalcony = togler == true? request.getParameter("hasBalcony") != null : false; //get from request

			boolean noDeposit = togler == true? request.getParameter("noDeposit") != null : false; //get from request
			
			session.setAttribute("togler", togler);
			
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
			
			session.setAttribute("minUserPrice", minPrice);
			session.setAttribute("maxUserPrice", maxPrice);
			
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
			
			session.setAttribute("minPrice", roomService.getMinPrice());
			session.setAttribute("maxPrice", roomService.getMaxPrice());
		}
		
		Timestamp startDate;
		Timestamp endDate;
		try {
			startDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("startDate").toString()).getTime());
		} catch (ParseException e) {
			startDate = new Timestamp(new Date().getTime());
		}
		try {
			endDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("endDate").toString()).getTime());
		} catch (ParseException e) {
			endDate = new Timestamp(new Date().getTime());
		}
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		
		int countOfHotels = new HotelService().getSuitableHotelsNumber(session.getAttribute("name").toString(), 
				(int) session.getAttribute("minStars"), (int) session.getAttribute("maxStars"), (int) session.getAttribute("people"), 
				(boolean) session.getAttribute("typeStandart"), (boolean) session.getAttribute("typeLux"), (boolean) session.getAttribute("typeDelux"), 
				(boolean) session.getAttribute("foodNone"), (boolean) session.getAttribute("foodBreakfast"), 
				(boolean) session.getAttribute("foodTwice"), (boolean) session.getAttribute("foodFull"), 
				(int) session.getAttribute("minUserPrice"), (int) session.getAttribute("maxUserPrice"), 
				(boolean) session.getAttribute("hasWiFi"), (boolean) session.getAttribute("hasShower"), (boolean) session.getAttribute("hasParking"), 
				(boolean) session.getAttribute("hasCondition"), (boolean) session.getAttribute("hasPool"), (boolean) session.getAttribute("hasGym"), 
				(boolean) session.getAttribute("hasBalcony"), (boolean) session.getAttribute("noDeposit"), 
				startDate, endDate);
		
		int countOfPages = (int) Math.ceil(countOfHotels / 3.0);
		if (page > countOfPages) {
			page--;
		}
		
		request.setAttribute("countOfHotels", countOfHotels);
		request.setAttribute("countOfPages", countOfPages);
		request.setAttribute("currentPage", page);

		List<Hotel> suitableHotels = new HotelService().getAllSuitableHotels(session.getAttribute("name").toString(), 
				(int) session.getAttribute("minStars"), (int) session.getAttribute("maxStars"), 
				(int) session.getAttribute("people"), 
				(boolean) session.getAttribute("typeStandart"), (boolean) session.getAttribute("typeLux"), (boolean) session.getAttribute("typeDelux"), 
				(boolean) session.getAttribute("foodNone"), (boolean) session.getAttribute("foodBreakfast"), 
				(boolean) session.getAttribute("foodTwice"), (boolean) session.getAttribute("foodFull"), 
				(int) session.getAttribute("minUserPrice"), (int) session.getAttribute("maxUserPrice"), 
				(boolean) session.getAttribute("hasWiFi"), (boolean) session.getAttribute("hasShower"), (boolean) session.getAttribute("hasParking"), 
				(boolean) session.getAttribute("hasCondition"), (boolean) session.getAttribute("hasPool"), (boolean) session.getAttribute("hasGym"), 
				(boolean) session.getAttribute("hasBalcony"), (boolean) session.getAttribute("noDeposit"), 
				startDate, endDate, page);
		
		request.setAttribute("hotels", suitableHotels);
		
		if(request.getParameter("flag") != null && request.getParameter("flag").equals("true")) {
			request.getRequestDispatcher("pages/card.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("pages/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
