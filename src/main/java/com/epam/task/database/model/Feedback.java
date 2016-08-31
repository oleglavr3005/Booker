package com.epam.task.database.model;

import java.sql.Timestamp;

import com.epam.task.database.transformers.DataBaseField;

public class Feedback {
	@DataBaseField(fieldName = "feedback_id")
	private int feedback_id;
	
	@DataBaseField(fieldName = "user_id")
	private Integer user_id;
	
	@DataBaseField(fieldName = "hotel_id")
	private Integer hotel_id;
	
	@DataBaseField(fieldName = "rating")
	private Integer rating;
		
	@DataBaseField(fieldName = "comment")
	private String comment;
	
	@DataBaseField(fieldName = "title")
	private String title;
	
	@DataBaseField(fieldName = "date")
	private Timestamp date;

	public Feedback(int feedback_id, Integer user_id, Integer hotel_id, Integer rating, String comment, String title,
			Timestamp date) {
		super();
		this.feedback_id = feedback_id;
		this.user_id = user_id;
		this.hotel_id = hotel_id;
		this.rating = rating;
		this.comment = comment;
		this.title = title;
		this.date = date;
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Integer hotel_id) {
		this.hotel_id = hotel_id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}
