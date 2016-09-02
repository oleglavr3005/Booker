package com.epam.task.database.model;

import java.util.List;

import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.transformers.DataBaseField;

public class Hotel {

	public Hotel(int id, String name, String city, String street, int stars, String desc, int managerId,
			double xCoord, double yCoord, double rating, boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.street = street;
		this.stars = stars;
		this.desc = desc;
		this.managerId = managerId;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.rating = rating;
		this.isDeleted = isDeleted;
		
		photos = new HotelPhotoService().getHotelPhotosByHotel(id);
		if(photos.size() == 0) {
			photos.add(new HotelPhoto(0, "no-image.jpg", "", id));
		}
	}
	
	@DataBaseField(fieldName = "hotel_id")
	private int id;
	@DataBaseField(fieldName = "name")
	private String name;
	@DataBaseField(fieldName = "city")
	private String city;
	@DataBaseField(fieldName = "street")
	private String street;
	@DataBaseField(fieldName = "stars")
	private int stars;
	@DataBaseField(fieldName = "desc")
	private String desc;
	@DataBaseField(fieldName = "manager_id")
	private int managerId;
	@DataBaseField(fieldName = "x_coord")
	private double xCoord;
	@DataBaseField(fieldName = "y_coord")
	private double yCoord;
	@DataBaseField(fieldName = "rating")
	private double rating;
	@DataBaseField(fieldName = "is_deleted")
	private boolean isDeleted;
	
	private List<HotelPhoto> photos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public double getXCoord() {
		return xCoord;
	}
	public void setXCoord(double xCoord) {
		this.xCoord = xCoord;
	}
	public double getYCoord() {
		return yCoord;
	}
	public void setYCoord(double yCoord) {
		this.yCoord = yCoord;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public HotelPhoto getPhoto(){
		return photos.get(0);
	}
	
	public List<HotelPhoto> getPhotos() {
		return photos;
	}
	
	public void setPhotos(List<HotelPhoto> photos) {
		this.photos = photos;
	}
	
	@Override
	public String toString() {
		return "Hotel [hotelId=" + id + ", name=" + name + ", city=" + city + ", street=" + street + ", stars="
				+ stars + ", desc=" + desc + ", managerId=" + managerId + ", xCoord=" + xCoord + ", yCoord=" + yCoord
				+ ", rating=" + rating + ", isDeleted=" + isDeleted + "]";
	}
	
}
