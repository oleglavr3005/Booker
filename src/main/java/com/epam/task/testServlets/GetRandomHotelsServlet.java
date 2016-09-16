package com.epam.task.testServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.service.HotelService;

@WebServlet("/get_hotels")
public class GetRandomHotelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetRandomHotelsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("hotelsNum"));
		List<Hotel> allHotels = new HotelService().getAllHotels();
		List<Hotel> hotels = new ArrayList<>();
		
		for (int i = 0; i<num; i++) {
			hotels.add(allHotels.get(i));
		}

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			for(Hotel hotel : hotels) {
				JSONObject hotelJson = new JSONObject();
				hotelJson.put("id", hotel.getId());
				hotelJson.put("name", hotel.getName());
//				hotelJson.put("city", hotel.getCity());
//				hotelJson.put("street", hotel.getStreet());
				hotelJson.put("stars", hotel.getStars());
				hotelJson.put("rating", hotel.getRating());
				hotelJson.put("phoneNumber", hotel.getPhoneNumber());
				hotelJson.put("photo", hotel.getPhotos().get(0).getImg());
				array.put(hotelJson);
			}
			json.put("hotels", array);
			json.put("countOfHotels", hotels.size());
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
