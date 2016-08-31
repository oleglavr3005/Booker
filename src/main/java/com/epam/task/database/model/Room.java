package com.epam.task.database.model;

import com.epam.task.database.model.enums.RoomType;
import com.epam.task.database.transformers.DataBaseField;

public class Room {
	
	@DataBaseField(fieldName = "room_id")
	private int id;

	@DataBaseField(fieldName = "hotel_id")
	private int hotelId;
	
	@DataBaseField(fieldName = "number")
	private String number;
	
	@DataBaseField(fieldName = "type")
	private RoomType type;
	

}
