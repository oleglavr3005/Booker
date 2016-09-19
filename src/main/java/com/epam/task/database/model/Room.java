package com.epam.task.database.model;

import java.util.Comparator;
import java.util.List;

import com.epam.task.database.model.enums.RoomFood;
import com.epam.task.database.model.enums.RoomType;
import com.epam.task.database.service.RoomPhotoService;
import com.epam.task.database.transformers.DataBaseField;

public class Room {
		
	public Room(int id, int hotelId, String number, String type, int bedsCount, int doubleBedsCount,
			int price, boolean wifi, boolean shower, boolean condition,
			boolean balcony, boolean tv, String food, int daysCount, int percentage, boolean deleted) {
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
		this.condition = condition;
		this.balcony = balcony;
		this.tv = tv;
		this.food = food == null ? null : RoomFood.valueOf(food);
		this.daysCount = daysCount;
		this.percentage = percentage;
		this.deleted = deleted;
		
		photos = new RoomPhotoService().getRoomPhotosByRoom(id);
		if(photos.size() == 0) {
			photos.add(new RoomPhoto(0, "no_room_pic.jpg", "", hotelId, true));
		} else {
			photos.sort(new Comparator<RoomPhoto>() {
				@Override
				public int compare(RoomPhoto o1, RoomPhoto o2) {
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

	@DataBaseField(fieldName = "has_condition")
	private boolean condition;

	@DataBaseField(fieldName = "has_balcony")
	private boolean balcony;
	
	@DataBaseField(fieldName = "has_tv")
	private boolean tv;
	
	@DataBaseField(fieldName = "food")
	private RoomFood food;

	@DataBaseField(fieldName = "days_count")	
	private int daysCount;
	
	@DataBaseField(fieldName = "percentage")
	private int percentage;

	@DataBaseField(fieldName = "is_deleted")
	private boolean deleted;
		
	private List<RoomPhoto> photos;

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

	public int getBedsCount() {
		return bedsCount;
	}

	public void setBedsCount(int bedsCount) {
		this.bedsCount = bedsCount;
	}

	public int getDoubleBedsCount() {
		return doubleBedsCount;
	}

	public void setDoubleBedsCount(int doubleBedsCount) {
		this.doubleBedsCount = doubleBedsCount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean getWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean getShower() {
		return shower;
	}

	public void setShower(boolean shower) {
		this.shower = shower;
	}

	public boolean getCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	public boolean getBalcony() {
		return balcony;
	}

	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}

	public RoomFood getFood() {
		return food;
	}
	
	public void setFood(String food) {
		this.food = food == null ? null : RoomFood.valueOf(food);
	}

	public int getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(int daysCount) {
		this.daysCount = daysCount;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public RoomPhoto getPhoto(){
		return photos.get(0);
	}
	
	public List<RoomPhoto> getPhotos() {
		return photos;
	}
	
	public void setPhotos(List<RoomPhoto> photos) {
		this.photos = photos;
	}

	
	public boolean getTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", hotelId=" + hotelId + ", number=" + number + ", type=" + type + ", bedsCount="
				+ bedsCount + ", doubleBedsCount=" + doubleBedsCount + ", price=" + price + ", wifi=" + wifi
				+ ", shower=" + shower + ", condition=" + condition + ", balcony=" + balcony + ", tv=" + tv + ", food="
				+ food + ", daysCount=" + daysCount + ", percentage=" + percentage + ", deleted=" + deleted
				+ ", photos=" + photos + "]";
	}

}
