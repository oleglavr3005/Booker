package com.epam.task.servlets.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.RoomPhoto;
import com.epam.task.database.service.RoomPhotoService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.ImageSetter;

@WebServlet("/edit_room_pictures/*")
public class EditRoomPictures extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditRoomPictures() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
    		int roomId = Integer.parseInt(request.getPathInfo().substring(1));
			List<RoomPhoto> photos = new ImageSetter(request).uploadRoomImages();
			RoomPhotoService roomPhotoService = new RoomPhotoService();
			for(RoomPhoto photo : photos){
				photo.setRoomId(roomId);
				roomPhotoService.insertRoomPhoto(photo);
			}
			request.setAttribute("room", new RoomService().getRoomById(roomId));
			request.getRequestDispatcher("/pages/cards/roomPhotoCard.jsp").forward(request, response);
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
