package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.HotelPhoto;
import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.Extracter;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/cabinet/order/*")
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

		Integer orderId = Integer.valueOf(Extracter.getLast(request.getPathInfo()));
		Order order = new OrderService().getOrderById(orderId);
		Room room = new RoomService().getRoomById(order.getRoomId());
		Hotel hotel = new HotelService().getHotelById(room.getHotelId());		
		List<HotelPhoto> hotelPhoto = new HotelPhotoService().getHotelPhotosByHotel(room.getHotelId());
		
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
