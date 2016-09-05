package com.epam.task.database.model;

import java.sql.Timestamp;

import com.epam.task.database.transformers.DataBaseField;

public class Feedback {
	@DataBaseField(fieldName = "feedback_id")
	private int id;
	
	@DataBaseField(fieldName = "user_id")
	private int userId;
	
	@DataBaseField(fieldName = "hotel_id")
	private int hotelId;
	
	@DataBaseField(fieldName = "rating")
	private int rating;
		
	@DataBaseField(fieldName = "comment")
	private String comment;
	
	@DataBaseField(fieldName = "title")
	private String title;
	
	@DataBaseField(fieldName = "date")
	private Timestamp date;

	public Feedback(int id, int userId, int hotelId, int rating, String comment, String title, Timestamp date) {
		super();
		this.id = id;
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

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
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
