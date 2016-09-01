package com.epam.task.database.model;
import com.epam.task.database.transformers.DataBaseField;

public class HotelPhoto {
	
	@DataBaseField(fieldName = "hotel_photo_id")
	private int id;
	
	@DataBaseField(fieldName = "img")
	private String img;

	@DataBaseField(fieldName = "desc")	
	private String desc;

	@DataBaseField(fieldName = "hotel_id")
	private int hotelId;

	public HotelPhoto(int id,String img, String desc, int hotelId) {
		super();
		this.id=id;
		this.img = img;
		this.desc = desc;
		this.hotelId = hotelId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	
}
