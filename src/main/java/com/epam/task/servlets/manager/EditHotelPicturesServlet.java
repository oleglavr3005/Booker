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
import com.epam.task.util.ImageSetter;

@WebServlet("/edit_hotel_pictures/*")
public class EditHotelPicturesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(EditHotelPicturesServlet.class);
       
    public EditHotelPicturesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		int hotelId = Integer.parseInt(request.getPathInfo().substring(1));
			List<HotelPhoto> photos = new ImageSetter(request).uploadHotelImages();
			HotelPhotoService hotelPhotoService = new HotelPhotoService();
			List<HotelPhoto> existingPhotos = hotelPhotoService.getHotelPhotosByHotel(hotelId);
			boolean isMain = false;
			if(existingPhotos.isEmpty()) {
				isMain = true;
			}
			for(HotelPhoto photo : photos){
				photo.setHotelId(hotelId);
				photo.setMain(isMain);
				hotelPhotoService.insertHotelPhoto(photo);
				isMain = false;
			}
			request.setAttribute("hotel", new HotelService().getHotelById(hotelId));
			request.getRequestDispatcher("/pages/cards/hotelPhotoCard.jsp").forward(request, response);
		} catch (Exception e) {
        	LOGGER.error("Edit hotel pics exception", e);
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
