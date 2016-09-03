package com.epam.task.servlets.cabinet;

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
import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.service.FeedbackService;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/cabinet/order")
public class OrderConcreteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(OrderConcreteServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderConcreteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hotelId = "4"; //test value
		if(hotelId.length() > 1) {
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(hotelId);
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
		
		Order order = new OrderService().getOrderById(1);  //test value
		List<HotelPhoto> hotelPhoto = new HotelPhotoService().getHotelPhotosByHotel(id);
		Room room = new RoomService().getAllRoomsForHotel(1, 1).get(0); //test value
		request.setAttribute("hotel", hotel);
		request.setAttribute("order", order);
		request.setAttribute("room", room);
		if (hotelPhoto.size() > 0) {
			request.setAttribute("MainPhoto", hotelPhoto.get(0));
			hotelPhoto.remove(0);
			request.setAttribute("hotelPhotos", hotelPhoto);
		}
		
		request.getRequestDispatcher("/pages/user/orderConcrete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
