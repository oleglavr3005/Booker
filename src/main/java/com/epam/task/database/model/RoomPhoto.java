package com.epam.task.database.model;
import com.epam.task.database.transformers.DataBaseField;

public class RoomPhoto {
	
	@DataBaseField(fieldName = "room_photo_id")
	private int id;
	
	@DataBaseField(fieldName = "img")
	private String img;

	@DataBaseField(fieldName = "desk")	
	private String desc;

	@DataBaseField(fieldName = "room_id")
	private int roomId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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
	
}
