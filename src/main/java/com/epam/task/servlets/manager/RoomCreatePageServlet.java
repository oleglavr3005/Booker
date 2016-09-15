package com.epam.task.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.util.StringUtil;

@WebServlet("/cabinet/create_room")
public class RoomCreatePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoomCreatePageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelIdString = request.getParameter("hotelId");
		if(!StringUtil.isPositiveInteger(hotelIdString)) {
			response.sendError(500);
			return;
		}
		
		int managerId = ((User) request.getSession().getAttribute("user")).getId();
		request.setAttribute("hotelId", Integer.parseInt(hotelIdString));
		request.setAttribute("hotels", new HotelService().getAllHotelsByManager(managerId));
		request.getRequestDispatcher("/pages/manager/roomCreate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
