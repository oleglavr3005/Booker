package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.service.RoomPhotoService;
import com.epam.task.database.service.RoomService;

@WebServlet("/remove_room_photo")
public class RemoveRoomPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveRoomPhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
    		String photoIdsString = request.getParameter("photos");
    		String[] photoIds = photoIdsString.split(",");
			RoomPhotoService roomPhotoService = new RoomPhotoService();
			int roomId = 0;
    		for(int i = 0; i<photoIds.length; i++) {
    			if(roomId == 0){
    				roomId = roomPhotoService.getRoomPhotoById(Integer.parseInt(photoIds[i])).getRoomId();
    			}
    			roomPhotoService.deleteRoomPhoto(Integer.parseInt(photoIds[i]));
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
