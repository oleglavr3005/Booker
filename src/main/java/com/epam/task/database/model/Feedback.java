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
	
	@DataBaseField(fieldName = "first_name")
	private String firstName;
	
	@DataBaseField(fieldName = "last_name")
	private String lastName;
	
	@DataBaseField(fieldName = "img")
	private String img;

	public Feedback(int id, Integer userId, Integer hotelId, Integer rating, String comment, String title,
			Timestamp date, String firstName, String lastName, String img) {
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
