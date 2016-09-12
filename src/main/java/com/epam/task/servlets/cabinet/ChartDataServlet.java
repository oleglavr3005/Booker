package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.epam.task.database.dto.OrderDto;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;

@WebServlet("/get_chart_data")
public class ChartDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChartDataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		List<OrderDto> orders = OrderDto.listConverter(new OrderService().getOrdersByUser(user.getId()));
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			Map<Integer, Integer> hotels = new HashMap<>(); //hotel id, how many times
			for(OrderDto order : orders) {
				Integer hotelId = order.getHotel().getId();
				if(hotels.get(hotelId) != null) {	//if array already contains this hotel, increment
					hotels.put(hotelId, hotels.get(hotelId) + 1);
				} else {		//else add it
					hotels.put(hotelId, 1);				
				}
			}

			HotelService service = new HotelService();
			JSONObject json = new JSONObject();
			JSONArray donutArray = new JSONArray();
			for (Map.Entry<Integer, Integer> element : hotels.entrySet()) {		//iterate over map, create json objects
				JSONObject orderJson = new JSONObject();
				orderJson.put("label", service.getHotelById(element.getKey()).getName()); //hotel
				orderJson.put("value", element.getValue());						//times visited
				donutArray.put(orderJson);	
			}
			json.put("donutData", donutArray);
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
