package com.epam.task.servlets.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;

@WebServlet("/remove_hotel_photo")
public class RemoveHotelPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveHotelPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String photoIdsString = request.getParameter("images");
		if(photoIdsString == null) {
			response.sendError(500);
			return;
		}
		
		try {
    		String[] photoIds = photoIdsString.split(",");
			HotelPhotoService hotelPhotoService = new HotelPhotoService();
			int hotelId = 0;
    		for(int i = 0; i<photoIds.length; i++) {
    			if(hotelId == 0){
    				hotelId = hotelPhotoService.getHotelPhotoById(Integer.parseInt(photoIds[i])).getHotelId();
    			}
    			hotelPhotoService.deleteHotelPhoto(Integer.parseInt(photoIds[i]));
    		}
			request.setAttribute("hotel", new HotelService().getHotelById(hotelId));
			request.getRequestDispatcher("/pages/cards/hotelPhotoCard.jsp").forward(request, response);
		} catch (Exception e) {
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
