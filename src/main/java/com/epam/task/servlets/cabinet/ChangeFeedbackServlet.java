package com.epam.task.servlets.cabinet;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Feedback;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.service.FeedbackService;
import com.epam.task.database.service.HotelService;
import com.epam.task.util.StringUtil;

@WebServlet("/change_feedback")
public class ChangeFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ChangeFeedbackServlet.class);

    public ChangeFeedbackServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("comment");
		String ratingString = request.getParameter("rating");
		String title = request.getParameter("title");
		String feedbackIdString = request.getParameter("feedbackId");
		
		if(comment == null || ratingString == null || feedbackIdString == null || title == null ||
				!StringUtil.isInRatingRange(ratingString) || !StringUtil.isPositiveInteger(feedbackIdString)) {
        	LOGGER.error("Invalid data injection attempt");
			response.sendError(500);
			return;
		}
		
		int rating = Integer.parseInt(ratingString);
		int feedbackId = Integer.parseInt(feedbackIdString);

		HotelService hotelService = new HotelService();
		FeedbackService feedbackService = new FeedbackService();
		
		Feedback feedback = feedbackService.getFeedbackById(feedbackId);
		User user = (User) request.getSession().getAttribute("user");
		if (feedback.getUserId() != user.getId()) {
			response.sendError(500);
			return;
		}
		Hotel hotel = hotelService.getHotelById(feedback.getHotelId());
		
		feedback.setComment(comment);
		feedback.setRating(rating);
		feedback.setTitle(title);
		int success = feedbackService.updateFeedback(feedback);

		if(success > 0) { //calculate new rating
			List<Feedback> feedbacks = feedbackService.getAllFeedbacksByHotel(feedback.getHotelId());
			double newRating = 0;
			if(feedbacks.size() != 0) {
				for(Feedback feedback1 : feedbacks) {
					newRating += feedback1.getRating();
				}
				newRating /= feedbacks.size(); 
			}
			DecimalFormat df = new DecimalFormat(".##");
			df.setRoundingMode(RoundingMode.UP);
			hotel.setRating(Double.parseDouble(df.format(newRating).replaceAll(",", ".")));
			hotelService.updateHotel(hotel);
		}
		
		response.getWriter().write(""+hotel.getRating());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
