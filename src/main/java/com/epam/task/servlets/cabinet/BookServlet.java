package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.User;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;
import com.epam.task.util.HotelUtil;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderIdString = request.getParameter("orderId");
		String cardNumber = request.getParameter("cardNumber");
		String comment = request.getParameter("comment");
		
		if(orderIdString == null || cardNumber == null) {
			return;
		}
		OrderService orderService = new OrderService();
		int orderId = Integer.parseInt(orderIdString);
		
		int roomId = orderService.getOrderById(orderId).getRoomId();
		Room room = new RoomService().getRoomById(roomId);
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		Set<Integer> hotelIds = new HashSet<>();
		hotelIds.add(room.getHotelId());
		
		List<Hotel> recomendedHotels = HotelUtil.getRecomendedHotelsForUser(hotelIds, userId);
		
		int booked = orderService.bookOrder(orderId, cardNumber, comment);
		
//		request.setAttribute("recomendedHotels", recomendedHotels);
//		request.setAttribute("recomendedHotelsSize", recomendedHotels.size());

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			for(Hotel hotel : recomendedHotels) {
				JSONObject hotelJson = new JSONObject();
				hotelJson.put("id", hotel.getId());
				hotelJson.put("name", hotel.getName());
				hotelJson.put("city", hotel.getCity());
				hotelJson.put("street", hotel.getStreet());
				hotelJson.put("stars", hotel.getStars());
				hotelJson.put("rating", hotel.getRating());
				hotelJson.put("phoneNumber", hotel.getPhoneNumber());
				hotelJson.put("photo", hotel.getPhotos().get(0));
				array.put(hotelJson);
			}
			json.put("hotels", array);
			json.put("countOfHotels", recomendedHotels.size());
			json.put("booked", booked > 0 ? "true" : "false");
			response.getWriter().print(json);
			response.getWriter().flush();
		} catch (JSONException e) {
			response.getWriter().write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
