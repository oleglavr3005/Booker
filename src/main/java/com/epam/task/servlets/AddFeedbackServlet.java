package com.epam.task.servlets;

import java.io.IOException;
import java.sql.Timestamp;
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
import com.epam.task.database.model.User;
import com.epam.task.database.service.FeedbackService;
import com.epam.task.database.service.HotelService;
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
		//removed user check : filter has already done it, removed code would never work!
		
		int rating = Integer.parseInt(ratingString);
		int hotelId = Integer.parseInt(hotelIdString);

		HotelService hotelService = new HotelService();
		FeedbackService feedbackService = new FeedbackService();
		
		Hotel hotel = hotelService.getHotelById(hotelId);
		int userId = ((User) request.getSession().getAttribute("user")).getId();
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
			hotel.setRating(newRating);
			hotelService.updateHotelRating(hotel);
			
			List<Feedback> listFeedBack = new ArrayList<Feedback>();	//WTF????? 
			listFeedBack.add(userFeedback);								//List with a single element? Logic?
			request.setAttribute("feedbacks", FeedbackDto.listConverter(listFeedBack));
			request.getRequestDispatcher("/pages/oneComment.jsp").forward(request, response);
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
