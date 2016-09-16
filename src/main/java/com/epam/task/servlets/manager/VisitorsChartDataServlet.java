package com.epam.task.servlets.manager;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.epam.task.database.model.Counter;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.service.CounterService;
import com.epam.task.database.service.HotelService;
import com.epam.task.util.StringUtil;

@WebServlet("/get_visitors_chart_data")
public class VisitorsChartDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VisitorsChartDataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelIdString = request.getParameter("hotelId");
		String startDateString = request.getParameter("startDate");
		String endDateString = request.getParameter("endDate");
		
		if(!StringUtil.isPositiveInteger(hotelIdString) || 
				!StringUtil.isDateInFormat(startDateString, "yyyy-MM-dd") || 
				!StringUtil.isDateInFormat(endDateString, "yyyy-MM-dd")) {
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
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate;
		Date endDate;
		try {
			startDate = format.parse(startDateString);
		} catch (ParseException e1) {
			startDate = new Date();
		}
		try {
			endDate = format.parse(endDateString);
		} catch (ParseException e1) {
			endDate = new Date();
		}
		
		///////////
		CounterService counterService = new CounterService();
		Map<String, Integer> visitedTimes = new HashMap<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		
		while(!calendar.getTime().after(endDate)) {	//from start date to end
			Counter counter = counterService.getCounterByHotelAndDate(hotelId, 
					new Timestamp(calendar.getTime().getTime()));
			String currentDate = format.format(calendar.getTime());
			if(counter == null) { //set date, 0
				visitedTimes.put(currentDate, 0);
			} else {	//set counter data
				visitedTimes.put(currentDate, counter.getCount());
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}		
		
		///////////
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			JSONObject json = new JSONObject();
			
			JSONArray visitorsArray = new JSONArray();
			for (Map.Entry<String, Integer> element : visitedTimes.entrySet()) {		//iterate over map, create json objects
				JSONObject visitorJson = new JSONObject();
				visitorJson.put("date", element.getKey()); 		//date
				visitorJson.put("value", element.getValue());	//times visited
				visitorsArray.put(visitorJson);	
			}

			json.put("visitorsData", visitorsArray);
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
