package com.epam.task.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Feedback;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.HotelPhoto;
import com.epam.task.database.model.Room;
import com.epam.task.database.service.FeedbackService;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomService;

@WebServlet("/hotel/*")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(HotelServlet.class);

	public HotelServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hotelId = request.getPathInfo().substring(1);
		int id = 0;
		try {
			id = Integer.parseInt(hotelId);
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Bad user id for hotel");
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		Hotel hotel = new HotelService().getHotelById(id);
		if (hotel == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			LOGGER.info("Bad user id for hotel, hotel not found");
			return;
		}
		List<Feedback> feedbacks = new FeedbackService().getAllFeedbacksByHotel(id);
		List<Room> rooms = new RoomService().getAllRoomsForHotel(id);
		List<HotelPhoto> hotelPhoto = new HotelPhotoService().getHotelPhotosByHotel(id);
		request.setAttribute("hotel", hotel);
		request.setAttribute("feedbacks", feedbacks);
		request.setAttribute("rooms", rooms);
		if (hotelPhoto.size() > 0) {
			request.setAttribute("MainPhoto", hotelPhoto.get(0));
			hotelPhoto.remove(0);
			request.setAttribute("hotelPhotos", hotelPhoto);
		}
		request.getRequestDispatcher("/pages/hotel.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
