package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.RoomPhoto;
import com.epam.task.database.service.RoomPhotoService;
import com.epam.task.database.service.RoomService;

@WebServlet("/remove_room_photo")
public class RemoveRoomPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(RemoveRoomPhotoServlet.class);

    public RemoveRoomPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String photoIdsString = request.getParameter("img");
		if(photoIdsString == null) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		try {
    		String[] photoIds = photoIdsString.split(",");
			RoomPhotoService roomPhotoService = new RoomPhotoService();
			int roomId = 0;
    		for(int i = 0; i<photoIds.length; i++) {
    			if(roomId == 0){
    				roomId = roomPhotoService.getRoomPhotoById(Integer.parseInt(photoIds[i])).getRoomId();
    			}
    			int photoId = Integer.parseInt(photoIds[i]);
    			RoomPhoto roomPhoto = roomPhotoService.getRoomPhotoById(photoId);
    			roomPhotoService.deleteRoomPhoto(photoId);
    			if(roomPhoto.isMain()) {
    				//set another main photo
    				List<RoomPhoto> roomPhotos = roomPhotoService.getRoomPhotosByRoom(roomId);
    				if(!roomPhotos.isEmpty()) {
    					RoomPhoto p = roomPhotos.get(0);
    					p.setMain(true);
    					roomPhotoService.updateRoomPhoto(p);
    				}
    			}
    		}
			request.setAttribute("room", new RoomService().getRoomById(roomId));
			request.getRequestDispatcher("/pages/cards/roomPhotoCard.jsp").forward(request, response);
		} catch (Exception e) {
        	LOGGER.error("Remove room pics exception", e);
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
