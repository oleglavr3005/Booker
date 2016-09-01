package com.epam.task.database.model;

import java.sql.Timestamp;

import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.model.enums.RoomType;
import com.epam.task.database.transformers.DataBaseField;

public class Order {

	@DataBaseField(fieldName = "order_id")
	private int id;
	@DataBaseField(fieldName = "user_id")
	private int userId;
	@DataBaseField(fieldName = "room_id")
	private int roomId;
	@DataBaseField(fieldName = "start_date")
	private java.sql.Timestamp startDate;
	@DataBaseField(fieldName = "end_date")
	private java.sql.Timestamp endDate;
	@DataBaseField(fieldName = "status")
	private OrderStatus status; // change to enum
	@DataBaseField(fieldName = "order_date")
	private java.sql.Timestamp orderDate;
	@DataBaseField(fieldName = "price")
	private int price;

	public Order(int id, int userId, int roomId, Timestamp startDate, Timestamp endDate,String status,
			Timestamp orderDate, int price) {
		super();
		this.id = id;
		this.userId = userId;
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status =  status == null ? null : OrderStatus.valueOf(status);
		this.orderDate = orderDate;
		this.price = price;
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

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public java.sql.Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Timestamp startDate) {
		this.startDate = startDate;
	}

	public java.sql.Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(java.sql.Timestamp endDate) {
		this.endDate = endDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public java.sql.Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
