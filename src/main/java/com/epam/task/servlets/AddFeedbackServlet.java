package com.epam.task.servlets;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.task.database.dto.FeedbackDto;
import com.epam.task.database.model.Feedback;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Order;
import com.epam.task.database.model.User;
import com.epam.task.database.service.FeedbackService;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.util.StringUtil;

@WebServlet("/addFeedback")
public class AddFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddFeedbackServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("comment");
		String ratingString = request.getParameter("rating");
		String hotelIdString = request.getParameter("hotelId");
		String title = request.getParameter("title");
		
		if(comment == null || ratingString == null || hotelIdString == null || title == null ||
				!StringUtil.isInRatingRange(ratingString) || !StringUtil.isPositiveInteger(hotelIdString)) {
			response.sendError(500);
			return;
		}
		int userId = ((User) request.getSession().getAttribute("user")).getId();
		int hotelId = Integer.parseInt(hotelIdString);
		
		//ADDED CHECK: if user has no finished orders in this hotel, he cannot leave feedback
		List<Order> finishedOrdersInHotel = new OrderService().getFinishedOrdersByUserAndHotel(userId, hotelId);
		if(finishedOrdersInHotel.isEmpty()) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("false");
			response.getWriter().flush();
			return;
		}
		
		int rating = Integer.parseInt(ratingString);

		HotelService hotelService = new HotelService();
		FeedbackService feedbackService = new FeedbackService();
		
		Hotel hotel = hotelService.getHotelById(hotelId);
		Feedback userFeedback = feedbackService.getFeedBackByUserAndHotel(userId, hotelId);
		
		int success;
		if(userFeedback != null) { //modify
			userFeedback.setComment(comment);
			userFeedback.setRating(rating);
			userFeedback.setTitle(title);
			success = feedbackService.updateFeedback(userFeedback);
		} else { 	//create new
			userFeedback = new Feedback(0, userId, hotelId, rating, comment, title, new Timestamp(new Date().getTime()));
			success = feedbackService.insertFeedback(userFeedback);
		}
		
		if (success > 0) { //calculate new rating
			List<Feedback> feedbacks = feedbackService.getAllFeedbacksByHotel(hotelId);
			double newRating = 0;
			for(Feedback feedback : feedbacks) {
				newRating += feedback.getRating();
			}
			newRating /= feedbacks.size(); 
			DecimalFormat df = new DecimalFormat(".##");
			df.setRoundingMode(RoundingMode.UP);
			hotel.setRating(Double.parseDouble(df.format(newRating).replace(",", ".")));
			hotelService.updateHotelRating(hotel);
			
			List<Feedback> listFeedBack = new ArrayList<Feedback>();
			listFeedBack.add(userFeedback);
			request.setAttribute("feedbacks", FeedbackDto.listConverter(listFeedBack));
			request.getRequestDispatcher("/pages/comments/oneComment.jsp").forward(request, response);
		} else {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("false");
			response.getWriter().flush();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
