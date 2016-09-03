package com.epam.task.database.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.RoomService;

public class OrderDto extends Order {
	
	private Hotel hotel;
	private Room room;
	
	public OrderDto(Order order){
		this(order.getId(), order.getUserId(), order.getRoomId(), order.getStartDate(), order.getEndDate(), order.getStatus().toString(),
				order.getOrderDate(), order.getPrice(), order.getComment());
	}

	public OrderDto(int id, int userId, int roomId, Timestamp startDate, Timestamp endDate, String status,
			Timestamp orderDate, int price, String comment) {
		super(id, userId, roomId, startDate, endDate, status, orderDate, price, comment);
		room = new RoomService().getRoomById(roomId);
		hotel = new HotelService().getHotelById(room.getHotelId());
	}
	
	public static List<OrderDto> listConverter(List<Order> orders){
		List<OrderDto> newList = new ArrayList<>();
		for (Order order : orders){
			newList.add(new OrderDto(order));
		}
		return newList;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public Room getRoom() {
		return room;
	}

}
