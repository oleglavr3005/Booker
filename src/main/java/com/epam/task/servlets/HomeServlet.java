package com.epam.task.servlets;

import java.io.IOException;
import java.util.Enumeration;
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

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelService hotelService = new HotelService();
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
	
		List<Hotel> hotels = hotelService.getAllHotelsByPage(page);
		
		request.setAttribute("hotels", hotels);
		request.setAttribute("countOfHotels", hotels.size());
		
		RoomService roomService = new RoomService();
		
		if(request.getParameter("flag") != null && request.getParameter("flag").equals("true")) {
			request.getRequestDispatcher("pages/card.jsp").forward(request, response);
		} else {			
			HttpSession session = request.getSession(true);
			Enumeration<String> names = session.getAttributeNames();
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				if(!name.equals("user")) {
					session.removeAttribute(name);
				}
			}
			session.setAttribute("minPrice", roomService.getMinPrice());
			session.setAttribute("maxPrice", roomService.getMaxPrice());
			session.setAttribute("countOfPages", Math.ceil(new HotelService().getAllHotels().size() / 3.0));
			request.getRequestDispatcher("pages/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
