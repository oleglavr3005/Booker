package com.epam.task.database.model;

import com.epam.task.database.model.enums.RoomFood;
import com.epam.task.database.model.enums.RoomType;
import com.epam.task.database.transformers.DataBaseField;

public class Room {
		
	public Room(int id, int hotelId, String number, String type, Integer bedsCount, Integer doubleBedsCount,
			Integer price, Boolean wifi, Boolean shower, Boolean parking, Boolean condition, Boolean pool, Boolean gym,
			Boolean balcony, String food, Integer daysCount, Integer percentage, Boolean deleted) {
		super();
		this.id = id;
		this.hotelId = hotelId;
		this.number = number;
		this.type = type == null ? null : RoomType.valueOf(type);
		this.bedsCount = bedsCount;
		this.doubleBedsCount = doubleBedsCount;
		this.price = price;
		this.wifi = wifi;
		this.shower = shower;
		this.parking = parking;
		this.condition = condition;
		this.pool = pool;
		this.gym = gym;
		this.balcony = balcony;
		this.food = food == null ? null : RoomFood.valueOf(food);
		this.daysCount = daysCount;
		this.percentage = percentage;
		this.deleted = deleted;
	}

	@DataBaseField(fieldName = "room_id")
	private int id;

	@DataBaseField(fieldName = "hotel_id")
	private int hotelId;
	
	@DataBaseField(fieldName = "number")
	private String number;
	
	@DataBaseField(fieldName = "type")
	private RoomType type;
	
	@DataBaseField(fieldName = "beds_count")
	private int bedsCount;

	@DataBaseField(fieldName = "double_beds_count")
	private int doubleBedsCount;

	@DataBaseField(fieldName = "price")
	private int price;

	@DataBaseField(fieldName = "has_wifi")
	private boolean wifi;

	@DataBaseField(fieldName = "has_shower")
	private boolean shower;

	@DataBaseField(fieldName = "has_parking")
	private boolean parking;

	@DataBaseField(fieldName = "has_condition")
	private boolean condition;

	@DataBaseField(fieldName = "has_pool")
	private boolean pool;

	@DataBaseField(fieldName = "has_gym")
	private boolean gym;

	@DataBaseField(fieldName = "has_balcony")
	private boolean balcony;
	
	@DataBaseField(fieldName = "food")
	private RoomFood food;

	@DataBaseField(fieldName = "days_count")	
	private int daysCount;
	
	@DataBaseField(fieldName = "percentage")
	private int percentage;

	@DataBaseField(fieldName = "is_deleted")
	private boolean deleted;

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : RoomType.valueOf(type);
	}

	public Integer getBedsCount() {
		return bedsCount;
	}

	public void setBedsCount(Integer bedsCount) {
		this.bedsCount = bedsCount;
	}

	public Integer getDoubleBedsCount() {
		return doubleBedsCount;
	}

	public void setDoubleBedsCount(Integer doubleBedsCount) {
		this.doubleBedsCount = doubleBedsCount;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getWifi() {
		return wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	public Boolean getShower() {
		return shower;
	}

	public void setShower(Boolean shower) {
		this.shower = shower;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean getCondition() {
		return condition;
	}

	public void setCondition(Boolean condition) {
		this.condition = condition;
	}

	public Boolean getPool() {
		return pool;
	}

	public void setPool(Boolean pool) {
		this.pool = pool;
	}

	public Boolean getGym() {
		return gym;
	}

	public void setGym(Boolean gym) {
		this.gym = gym;
	}

	public Boolean getBalcony() {
		return balcony;
	}

	public void setBalcony(Boolean balcony) {
		this.balcony = balcony;
	}

	public RoomFood getFood() {
		return food;
	}
	
	public void setFood(String food) {
		this.food = food == null ? null : RoomFood.valueOf(food);
	}

	public Integer getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(Integer daysCount) {
		this.daysCount = daysCount;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", hotelId=" + hotelId + ", number=" + number + ", type=" + type + ", bedsCount="
				+ bedsCount + ", doubleBedsCount=" + doubleBedsCount + ", price=" + price + ", wifi=" + wifi
				+ ", shower=" + shower + ", parking=" + parking + ", condition=" + condition + ", pool=" + pool
				+ ", gym=" + gym + ", balcony=" + balcony + ", food=" + food + ", daysCount=" + daysCount
				+ ", percentage=" + percentage + ", deleted=" + deleted + "]";
	}	

}
