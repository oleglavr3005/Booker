package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.HotelPhoto;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;

@WebServlet("/remove_hotel_photo")
public class RemoveHotelPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(RemoveHotelPhotoServlet.class);
       
    public RemoveHotelPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String photoIdsString = request.getParameter("images");
		if(photoIdsString == null) {
        	LOGGER.error("Invalid data injection attempt");
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
    			int photoId = Integer.parseInt(photoIds[i]);
    			HotelPhoto hotelPhoto = hotelPhotoService.getHotelPhotoById(photoId);
    			hotelPhotoService.deleteHotelPhoto(photoId);
    			if(hotelPhoto.isMain()) {
    				//set another main photo
    				List<HotelPhoto> hotelPhotos = hotelPhotoService.getHotelPhotosByHotel(hotelId);
    				if(!hotelPhotos.isEmpty()) {
    					HotelPhoto p = hotelPhotos.get(0);
    					p.setMain(true);
    					hotelPhotoService.updateHotelPhoto(p);
    				}
    			}
    		}
			request.setAttribute("hotel", new HotelService().getHotelById(hotelId));
			request.getRequestDispatcher("/pages/cards/hotelPhotoCard.jsp").forward(request, response);
		} catch (Exception e) {
        	LOGGER.error("Remove hotel pics exception", e);
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
