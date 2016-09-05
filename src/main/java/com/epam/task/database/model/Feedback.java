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
	
	@DataBaseField(fieldName = "first_name")
	private String firstName;
	
	@DataBaseField(fieldName = "last_name")
	private String lastName;
	
	@DataBaseField(fieldName = "img")
	private String img;

	public Feedback(int id, int userId, int hotelId, int rating, String comment, String title, Timestamp date,
			String firstName, String lastName, String img) {
		super();
		this.id = id;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.comment = comment;
		this.title = title;
		this.date = date;
		this.firstName = firstName;
		this.lastName = lastName;
		this.img = img;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userId=" + userId + ", hotelId=" + hotelId + ", rating=" + rating
				+ ", comment=" + comment + ", title=" + title + ", date=" + date + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", img=" + img + "]";
	}
}
