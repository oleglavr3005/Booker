package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.RoomPhoto;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomPhotoService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.StringUtil;

@WebServlet("/set_main_room_photo")
public class SetMainRoomPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(SetMainRoomPhotoServlet.class);

    public SetMainRoomPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String photoIdString = request.getParameter("photoId");
		
		if(!StringUtil.isPositiveInteger(photoIdString)) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		int photoId = Integer.parseInt(photoIdString);
		RoomPhotoService roomPhotoService = new RoomPhotoService();
		RoomPhoto photo = roomPhotoService.getRoomPhotoById(photoId);
		
		if(photo == null) {	//no photos by this id
        	LOGGER.error("Attempt to load page, that does not exist");
			response.sendError(404);
			return;
		}
		
		Room room = new RoomService().getRoomById(photo.getRoomId());
		Hotel hotel = new HotelService().getHotelById(room.getHotelId());
		User user = (User) request.getSession().getAttribute("user");
		if(hotel.getManagerId() != user.getId()) {	//not your hotel
        	LOGGER.error("Attempt to load forbidden page");
			response.sendError(404);
			return;
		}
		
		List<RoomPhoto> photos = roomPhotoService.getRoomPhotosByRoom(room.getId());
		for(RoomPhoto p : photos) {	//set all photos not main
			p.setMain(false);
			roomPhotoService.updateRoomPhoto(p);
		}
		photo.setMain(true);			//set current photo as main
		roomPhotoService.updateRoomPhoto(photo);
		
		request.setAttribute("room", new RoomService().getRoomById(room.getId()));
		request.getRequestDispatcher("/pages/cards/roomPhotoCard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
