package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.Room;
import com.epam.task.database.service.RoomService;

@WebServlet("/change_room_status")
public class ChangeRoomStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeRoomStatus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomIdString = request.getParameter("roomId");
		String deletedString = request.getParameter("deleted"); //true or false
		
		if(roomIdString == null || deletedString == null) {
			return;
		}
		
		int roomId = Integer.parseInt(roomIdString);
		boolean deleted = Boolean.parseBoolean(deletedString);
		
		RoomService roomService = new RoomService();
		Room room = roomService.getRoomById(roomId);
		room.setDeleted(deleted);
		int changed = roomService.updateRoom(room);
		
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
