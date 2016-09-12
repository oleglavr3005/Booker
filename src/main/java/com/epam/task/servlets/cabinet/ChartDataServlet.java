package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.util.Calendar;
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
import com.epam.task.database.model.enums.OrderStatus;
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
		List<OrderDto> orders = OrderDto.listConverter(new OrderService().getOrdersByUserAndStatus(user.getId(), OrderStatus.ACTIVE));
		List<OrderDto> ordersFin = OrderDto.listConverter(new OrderService().getOrdersByUserAndStatus(user.getId(), OrderStatus.FINISHED));
		orders.addAll(ordersFin);
		
		Map<Integer, Integer> hotelsByTimes = new HashMap<>(); //hotel id, how many times
		for(OrderDto order : orders) {
			Integer hotelId = order.getHotel().getId();
			if(hotelsByTimes.get(hotelId) != null) {	//if array already contains this hotel, increment
				hotelsByTimes.put(hotelId, hotelsByTimes.get(hotelId) + 1);
			} else {		//else add it
				hotelsByTimes.put(hotelId, 1);				
			}
		}
		
		Map<String, Integer> monthTimes = new HashMap<>(); //date, how many times
		Calendar calendar = Calendar.getInstance();
		for(OrderDto order : orders) {
			calendar.setTime(order.getStartDate());
			int month = calendar.get(Calendar.MONTH) + 1;
			String monthString;
			if(month < 10) {
				monthString = "0" + month;
			} else {
				monthString = "" + month;
			}
			String date = calendar.get(Calendar.YEAR) + "-" + monthString;
			if(monthTimes.get(date) != null) {
				monthTimes.put(date, monthTimes.get(date) + 1);
			} else {
				monthTimes.put(date, 1);
			}
		}
		
		HotelService service = new HotelService();
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			JSONObject json = new JSONObject();
			
			JSONArray donutArray = new JSONArray();
			for (Map.Entry<Integer, Integer> element : hotelsByTimes.entrySet()) {		//iterate over map, create json objects
				JSONObject orderJson = new JSONObject();
				orderJson.put("label", service.getHotelById(element.getKey()).getName()); //hotel
				orderJson.put("value", element.getValue());						//times visited
				donutArray.put(orderJson);	
			}
			
			JSONArray lineArray = new JSONArray();
			for (Map.Entry<String, Integer> element : monthTimes.entrySet()) {		//iterate over map, create json objects
				JSONObject orderJson = new JSONObject();
				orderJson.put("year", element.getKey()); //date
				orderJson.put("value", element.getValue());						//times visited
				lineArray.put(orderJson);	
			}
			
			json.put("donutData", donutArray);
			json.put("lineData", lineArray);
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
