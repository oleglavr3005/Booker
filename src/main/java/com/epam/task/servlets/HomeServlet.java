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

import com.epam.task.database.model.Hotel;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("pages/index.jsp");
		//or
		HotelService hotelService = new HotelService();
		HotelPhotoService hotelPhotoService = new HotelPhotoService();
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);

//		List<Hotel> hotels;
//		HttpSession session = request.getSession(true);
//		if(session.getAttribute("name") != null) {
//			Timestamp startDate;
//			Timestamp endDate;
//			try {
//				startDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("startDate").toString()).getTime());
//			} catch (Exception e) {
//				startDate = new Timestamp(0);
//			}
//			try {
//				endDate = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(session.getAttribute("endDate").toString()).getTime());
//			} catch (Exception e) {
//				endDate = new Timestamp(0);
//			}
//			hotels = hotelService.getAllSuitableHotels(session.getAttribute("name").toString(), 
//					(int) session.getAttribute("minStars"), (int) session.getAttribute("maxStars"), 
//					(int) session.getAttribute("people"), 
//					(boolean) session.getAttribute("typeStandart"), (boolean) session.getAttribute("typeLux"), (boolean) session.getAttribute("typeDelux"), 
//					(boolean) session.getAttribute("foodNone"), (boolean) session.getAttribute("foodBreakfast"), 
//					(boolean) session.getAttribute("foodTwice"), (boolean) session.getAttribute("foodFull"), 
//					(int) session.getAttribute("minPrice"), (int) session.getAttribute("maxPrice"), 
//					(boolean) session.getAttribute("hasWiFi"), (boolean) session.getAttribute("hasShower"), (boolean) session.getAttribute("hasParking"), 
//					(boolean) session.getAttribute("hasCondition"), (boolean) session.getAttribute("hasPool"), (boolean) session.getAttribute("hasGym"), 
//					(boolean) session.getAttribute("hasBalcony"), (boolean) session.getAttribute("noDeposit"), 
//					startDate, endDate, page);
//		} else {
//			hotels = hotelService.getAllHotelsByPage(page);
//		}
		
		List<Hotel> hotels = hotelService.getAllHotelsByPage(page);
		for(Hotel hotel : hotels){
			hotel.setPhotos(hotelPhotoService.getHotelPhotosByHotel(hotel.getId()));
		}
		
		request.setAttribute("hotels", hotels);
		request.setAttribute("countOfHotels", hotels.size());
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
