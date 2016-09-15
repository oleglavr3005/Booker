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

import com.epam.task.database.model.Feedback;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.service.FeedbackService;
import com.epam.task.database.service.HotelService;
import com.epam.task.util.StringUtil;

@WebServlet("/deleteFeedback")
public class DeleteFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteFeedback() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentIdString = request.getParameter("commentId");
		if(commentIdString == null || !StringUtil.isPositiveInteger(commentIdString)) {
			response.sendError(500);
			return;
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try{
			FeedbackService feedbackService = new FeedbackService();
			int commentId = Integer.parseInt(commentIdString);
			Feedback feedback = feedbackService.getFeedbackById(commentId);

			User user = (User) request.getSession().getAttribute("user");
			if (feedback.getUserId() != user.getId()) {
				response.sendError(500);
				return;
			}
			
			int hotelId = feedback.getHotelId();
			int result = feedbackService.deleteFeedback(commentId);
			
			if (result > 0) { //calculate new rating
				HotelService hotelService = new HotelService();
				List<Feedback> feedbacks = feedbackService.getAllFeedbacksByHotel(hotelId);
				double newRating = 0;
				if(feedbacks.size() != 0) {
					for(Feedback feedback1 : feedbacks) {
						newRating += feedback1.getRating();
					}
					newRating /= feedbacks.size(); 
				}
				Hotel hotel = hotelService.getHotelById(hotelId);
				DecimalFormat df = new DecimalFormat(".##");
				df.setRoundingMode(RoundingMode.UP);
				hotel.setRating(Double.parseDouble(df.format(newRating).replaceAll(",", ".")));
				hotelService.updateHotel(hotel);
			}
			response.getWriter().write(result > 0 ? "true" : "false");
		} catch (Exception e) {
			response.getWriter().write("false");
		}
		response.getWriter().flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
