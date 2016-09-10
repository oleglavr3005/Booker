package com.epam.task.database.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Feedback;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.User;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.UserService;

public class FeedbackDto extends Feedback{

	private User user;
	private Hotel hotel;
	
	public FeedbackDto(Feedback feedback) {
		super(feedback.getId(), feedback.getUserId(), feedback.getHotelId(), feedback.getRating(), 
				feedback.getComment(), feedback.getTitle(), feedback.getDate());
		user = new UserService().getUserById(feedback.getUserId());
		hotel = new HotelService().getHotelById(feedback.getHotelId());
	}
	
	public FeedbackDto(int id, int userId, int hotelId, int rating, String comment, String title, Timestamp date) {
		super(id, userId, hotelId, rating, comment, title, date);
		user = new UserService().getUserById(userId);
		hotel = new HotelService().getHotelById(hotelId);
	}
	
	public static List<FeedbackDto> listConverter(List<Feedback> feedbacks){
		List<FeedbackDto> newList = new ArrayList<>();
		for (Feedback feedback : feedbacks){
			newList.add(new FeedbackDto(feedback));
		}
		return newList;
	}
	
	public User getUser() {
		return user;
	}

	public Hotel getHotel() {
		return hotel;
	}
}
