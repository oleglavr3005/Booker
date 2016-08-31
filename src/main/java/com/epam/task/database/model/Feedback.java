package com.epam.task.database.model;

import java.sql.Timestamp;

import com.epam.task.database.transformers.DataBaseField;

public class Feedback {
	@DataBaseField(fieldName = "feedback_id")
	private int id;
	
	@DataBaseField(fieldName = "user_id")
	private Integer userId;
	
	@DataBaseField(fieldName = "hotel_id")
	private Integer hotelId;
	
	@DataBaseField(fieldName = "rating")
	private Integer rating;
		
	@DataBaseField(fieldName = "comment")
	private String comment;
	
	@DataBaseField(fieldName = "title")
	private String title;
	
	@DataBaseField(fieldName = "date")
	private Timestamp date;

	public Feedback(int feedbackId, Integer userId, Integer hotelId, Integer rating, String comment, String title,
			Timestamp date) {
		super();
		this.id = feedbackId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.comment = comment;
		this.title = title;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int feedbackId) {
		this.id = feedbackId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
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
