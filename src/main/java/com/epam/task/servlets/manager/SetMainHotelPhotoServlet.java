package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.HotelPhoto;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;
import com.epam.task.util.StringUtil;

@WebServlet("/set_main_hotel_photo")
public class SetMainHotelPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SetMainHotelPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String photoIdString = request.getParameter("photoId");
		
		if(!StringUtil.isPositiveInteger(photoIdString)) {
			response.sendError(500);
			return;
		}
		
		int photoId = Integer.parseInt(photoIdString);
		HotelPhotoService hotelPhotoService = new HotelPhotoService();
		HotelPhoto photo = hotelPhotoService.getHotelPhotoById(photoId);
		
		if(photo == null) {	//no photos by this id
			response.sendError(500);
			return;
		}
		
		Hotel hotel = new HotelService().getHotelById(photo.getHotelId());
		User user = (User) request.getSession().getAttribute("user");
		if(hotel.getManagerId() != user.getId()) {	//not your hotel
			response.sendError(500);
			return;
		}
		
		List<HotelPhoto> photos = hotelPhotoService.getHotelPhotosByHotel(hotel.getId());
		for(HotelPhoto p : photos) {	//set all photos not main
			p.setMain(false);
			hotelPhotoService.updateHotelPhoto(p);
		}
		photo.setMain(true);			//set current photo as main
		int updated = hotelPhotoService.updateHotelPhoto(photo);
		
		response.getWriter().write(updated > 0 ? photo.getImg() : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
