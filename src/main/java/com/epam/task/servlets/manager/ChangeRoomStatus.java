package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.StringUtil;

@WebServlet("/change_room_status")
public class ChangeRoomStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ChangeRoomStatus.class);

    public ChangeRoomStatus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomIdString = request.getParameter("roomId");
		String deletedString = request.getParameter("deleted"); //true or false

		if(roomIdString == null || deletedString == null || 
				!StringUtil.isPositiveInteger(roomIdString) || !StringUtil.isBoolean(deletedString)) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		int roomId = Integer.parseInt(roomIdString);
		boolean deleted = Boolean.parseBoolean(deletedString);
		
		RoomService roomService = new RoomService();
		Room room = roomService.getRoomById(roomId);
		Hotel hotel = new HotelService().getHotelById(room.getHotelId());
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		if(hotel.getManagerId() != userId) {
			response.sendError(500);
			return;
		}
		room.setDeleted(deleted);
		int changed = roomService.updateRoom(room);
		
		response.getWriter().write(changed > 0 ? "true" : "false");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
