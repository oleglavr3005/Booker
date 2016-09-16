package com.epam.task.database.model;

import java.util.Comparator;
import java.util.List;

import com.epam.task.database.service.HotelPhotoService;
import com.epam.task.database.transformers.DataBaseField;

public class Hotel {

	public Hotel(int id, String name, String location, int stars, String desc, int managerId,
			double xCoord, double yCoord, double rating, boolean isDeleted, String phoneNumber,
			boolean parking, boolean pool, boolean gym, boolean spa, boolean service, boolean cleaner) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.stars = stars;
		this.desc = desc;
		this.managerId = managerId;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.rating = rating;
		this.isDeleted = isDeleted;
		this.phoneNumber = phoneNumber;

		this.parking = parking;
		this.pool = pool;
		this.gym = gym;
		this.spa = spa;
		this.service = service;
		this.cleaner = cleaner;
		
		photos = new HotelPhotoService().getHotelPhotosByHotel(id);
		if(photos.size() == 0) {
			photos.add(new HotelPhoto(0, "no_hotel_pic.jpg", "", id, true));
		} else {
			photos.sort(new Comparator<HotelPhoto>() {
				@Override
				public int compare(HotelPhoto o1, HotelPhoto o2) {
					if(o1.isMain()) {
						return -1;
					} else if (o2.isMain()) {
						return 1;
					} else {
						return 0;
					}
				}
			});
		}
	}
	
	@DataBaseField(fieldName = "hotel_id")
	private int id;
	@DataBaseField(fieldName = "name")
	private String name;
	@DataBaseField(fieldName = "location")
	private String location;
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
	@DataBaseField(fieldName = "phone_number")
	private String phoneNumber;
	
	@DataBaseField(fieldName = "has_parking")
	private boolean parking;
	@DataBaseField(fieldName = "has_pool")
	private boolean pool;
	@DataBaseField(fieldName = "has_gym")
	private boolean gym;
	@DataBaseField(fieldName = "has_spa")
	private boolean spa;
	@DataBaseField(fieldName = "has_service")
	private boolean service;
	@DataBaseField(fieldName = "has_cleaner")
	private boolean cleaner;
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public boolean getIsDeleted() {
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean getParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	public boolean getPool() {
		return pool;
	}
	public void setPool(boolean pool) {
		this.pool = pool;
	}
	public boolean getGym() {
		return gym;
	}
	public void setGym(boolean gym) {
		this.gym = gym;
	}
	public boolean getSpa() {
		return spa;
	}
	public void setSpa(boolean spa) {
		this.spa = spa;
	}
	public boolean getService() {
		return service;
	}
	public void setService(boolean service) {
		this.service = service;
	}
	public boolean getCleaner() {
		return cleaner;
	}
	public void setCleaner(boolean cleaner) {
		this.cleaner = cleaner;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", location=" + location + ", stars=" + stars + ", desc=" + desc
				+ ", managerId=" + managerId + ", xCoord=" + xCoord + ", yCoord=" + yCoord + ", rating=" + rating
				+ ", isDeleted=" + isDeleted + ", phoneNumber=" + phoneNumber + ", parking=" + parking + ", pool="
				+ pool + ", gym=" + gym + ", spa=" + spa + ", service=" + service + ", cleaner=" + cleaner + ", photos="
				+ photos + "]";
	}	
	
}
