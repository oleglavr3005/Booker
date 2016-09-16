package com.epam.task.servlets.manager;

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
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.util.StringUtil;

@WebServlet("/get_manager_chart_data")
public class ManagerChartDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManagerChartDataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelIdString = request.getParameter("hotelId");
		if(!StringUtil.isPositiveInteger(hotelIdString)) {
			response.sendError(500);
			return;
		}
		int hotelId = Integer.parseInt(hotelIdString);
		User user = (User) request.getSession().getAttribute("user");
		Hotel hotel = new HotelService().getHotelById(hotelId);
		if(hotel.getManagerId() != user.getId()) {
			response.sendError(404);
			return;
		}
		
		List<OrderDto> orders = OrderDto.listConverter(new OrderService().getOrdersByHotelAndStatus(hotelId, OrderStatus.ACTIVE));
		List<OrderDto> ordersFin = OrderDto.listConverter(new OrderService().getOrdersByHotelAndStatus(hotelId, OrderStatus.FINISHED));
		orders.addAll(ordersFin);
		
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
		
		Map<String, Map<String, Integer>> seasonTimes = new HashMap<>();
		seasonTimes.put("Spring", createMap());
		seasonTimes.put("Summer", createMap());
		seasonTimes.put("Autumn", createMap());
		seasonTimes.put("Winter", createMap());
		for(OrderDto order : orders) {
			calendar.setTime(order.getStartDate());
			int month = calendar.get(Calendar.MONTH) + 1;
			String monthNumber;
			String season;
			if(month >= 3 && month <=5) {	//spring
				season = "Spring";
			} else if (month >= 6 && month <=8) {	//summer
				season = "Summer";
			} else if (month >= 9 && month <=11) {	//fall
				season = "Autumn";
			} else {	//winter
				season = "Winter";
			}
			if(month == 3 || month == 6 || month == 9 || month == 12) {
				monthNumber = "first";
			} else if (month == 4 || month == 7 || month == 10 || month == 1) {
				monthNumber = "second";
			} else {
				monthNumber = "third";
			}
			Map<String, Integer> monthMap = new HashMap<>();
			monthMap.put(monthNumber, seasonTimes.get(season).get(monthNumber) + 1);
			seasonTimes.put(season, monthMap);
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			JSONObject json = new JSONObject();
			
			JSONArray lineArray = new JSONArray();
			for (Map.Entry<String, Integer> element : monthTimes.entrySet()) {		//iterate over map, create json objects
				JSONObject orderJson = new JSONObject();
				orderJson.put("year", element.getKey()); //date
				orderJson.put("value", element.getValue());						//times visited
				lineArray.put(orderJson);	
			}
			
			JSONArray barArray = new JSONArray();
			for (Map.Entry<String, Map<String, Integer>> element : seasonTimes.entrySet()) {		//iterate over map, create json objects
				JSONObject orderJson = new JSONObject();
				String season = element.getKey();
				Map<String, Integer> monthMap = element.getValue();

				orderJson.put("season", season); 				//season
				for(Map.Entry<String, Integer> monthElement : monthMap.entrySet()) {
					orderJson.put(monthElement.getKey(), monthElement.getValue());	//month
				}
				barArray.put(orderJson);	
			}

			json.put("lineData", lineArray);
			json.put("barData", barArray);
			response.getWriter().print(json);
			response.getWriter().flush();
		} catch (JSONException e) {
			response.getWriter().write("false");
		}
	}

	private Map<String, Integer> createMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("first", 0);
		map.put("second", 0);
		map.put("third", 0);
		return map;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
