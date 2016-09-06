package com.epam.task.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Order;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;

public class HotelUtil {

//	public static List<Hotel> getRecomendedHotelsForUser(int hotelId, int currentUserId) {
//		//get all orders by hotel
//		//get all user id's from this list (distinct, add to set)
//		//for every user get his orders and add to map (hotel id, times)
//		//sort map by value get first three elements
//		
//		OrderService orderService = new OrderService();
//		RoomService roomService = new RoomService();
//		HotelService hotelService = new HotelService();
//		
//		List<Order> orders = orderService.getOrdersByHotel(hotelId);		//all orders in this hotel
//		Set<Integer> userIds = new HashSet<>();
//		for (Order order : orders) {		//all users, who were in this hotel
//			userIds.add(order.getUserId());
//		}
//		System.out.println("Users visited this hotel: " + userIds);
//		
//		Map<Integer, Integer> hotelsVisited  = new HashMap<>();		//contains all visited hotels and how many times
//		for (Integer userId : userIds) {
//			if(userId != currentUserId) {
//				List<Order> userOrders = orderService.getOrdersByUser(userId); //get all user's orders
//				for (Order order : userOrders) {
//					int roomId = order.getRoomId();
//					int holelId = roomService.getRoomById(roomId).getHotelId();
//					if(hotelsVisited.containsKey(holelId)) {	//increment
//						hotelsVisited.put(holelId, hotelsVisited.get(hotelId) + 1);
//					} else {									//put
//						hotelsVisited.put(holelId, 1);
//					}
//				}
//			}
//		}
//		System.out.println("Hotels visited, how many times: " + hotelsVisited);
//		
//		hotelsVisited = MapUtil.sortByValue(hotelsVisited); //sort map by values
//		System.out.println("Hotels visited, how many times, sorted: " + hotelsVisited);
//		List<Hotel> result = new ArrayList<>();
//		int i = 0;
//		for (Integer resultHotelId : hotelsVisited.keySet()) {	//get first three elements
//			if (i < 3 && hotelId != resultHotelId) {
//				result.add(hotelService.getHotelById(resultHotelId));
//				i++;
//			} else {
//				break;
//			}
//		}		
//		System.out.println("First three or less hotels: " + result);
//		return result;
//	}

	
	public static List<Hotel> getRecomendedHotelsForUser(Set<Integer> hotelIds, int currentUserId) {
		//get all orders by hotel
		//get all user id's from this list (distinct, add to set)
		//for every user get his orders and add to map (hotel id, times)
		//sort map by value get first three elements
		
		Map<Integer, Integer> hotelsVisited  = new HashMap<>();		//contains all visited hotels and how many times
		
		OrderService orderService = new OrderService();
		RoomService roomService = new RoomService();
		HotelService hotelService = new HotelService();
		
		for (Integer hotelId : hotelIds) {
			List<Order> orders = orderService.getOrdersByHotel(hotelId);		//all orders in this hotel
			Set<Integer> userIds = new HashSet<>();
			for (Order order : orders) {		//all users, who were in this hotel
				userIds.add(order.getUserId());
			}
			System.out.println("Users visited this hotel: " + userIds);
			
			for (Integer userId : userIds) {
				if(userId != currentUserId) {
					List<Order> userOrders = orderService.getOrdersByUser(userId); //get all user's orders
					for (Order order : userOrders) {
						int roomId = order.getRoomId();
						int holelId = roomService.getRoomById(roomId).getHotelId();
						if(hotelsVisited.containsKey(holelId)) {	//increment
							hotelsVisited.put(holelId, hotelsVisited.get(hotelId) + 1);
						} else {									//put
							hotelsVisited.put(holelId, 1);
						}
					}
				}
			}
			System.out.println("Hotels visited, how many times: " + hotelsVisited);
		}
		
		hotelsVisited = MapUtil.sortByValue(hotelsVisited); //sort map by values
		System.out.println("Hotels visited, how many times, sorted: " + hotelsVisited);
		List<Hotel> result = new ArrayList<>();
		int i = 0;
		for (Integer resultHotelId : hotelsVisited.keySet()) {	//get first three elements
			if (i < 3 && !hotelIds.contains(resultHotelId)) {
				result.add(hotelService.getHotelById(resultHotelId));
				i++;
			} else {
				break;
			}
		}		
		System.out.println("First three or less hotels: " + result);
		return result;
	}
}
