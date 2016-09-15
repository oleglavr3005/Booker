package com.epam.task.database.model;

import java.sql.Timestamp;

import com.epam.task.database.transformers.DataBaseField;

public class Counter {

	@DataBaseField(fieldName = "visitor_counter_id")
	private int id;

	@DataBaseField(fieldName = "hotel_id")
	private int hotelId;

	@DataBaseField(fieldName = "date")
	private Timestamp date;

	@DataBaseField(fieldName = "count")
	private int count;

	public Counter(int id, int hotelId, Timestamp date, int count) {
		this.id = id;
		this.hotelId = hotelId;
		this.date = date;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Counter [id=" + id + ", hotelId=" + hotelId + ", date=" + date + ", count=" + count + "]";
	}
	
	
}
