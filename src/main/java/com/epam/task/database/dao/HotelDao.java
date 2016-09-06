package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Order;
import com.epam.task.database.model.Room;
import com.epam.task.database.service.HotelService;
import com.epam.task.database.service.OrderService;
import com.epam.task.database.service.RoomService;
import com.epam.task.database.transformers.UniversalTransformer;
import com.epam.task.util.MapUtil;

public class HotelDao {


	private Connection connection;
	
	private final String SELECT_ALL_NOT_DELETED = "SELECT * FROM `hotel` WHERE is_deleted = false";
	private final String ORDER_BY_STARS_ASC = " ORDER BY stars ASC";
	private final String ORDER_BY_STARS_DESC = " ORDER BY stars DESC";
	private final String ORDER_BY_RATING_ASC = " ORDER BY rating ASC";
	private final String ORDER_BY_RATING_DESC = " ORDER BY rating DESC";
	private final String PAGINATION = " LIMIT ?, 3";
	
	private final String SELECT_ALL_SUITABLE = "SELECT DISTINCT h.* FROM hotel h INNER JOIN room r ON h.hotel_id = r.hotel_id LEFT JOIN `order` o ON o.room_id = r.room_id "
			+ "WHERE (h.name REGEXP ? OR h.city REGEXP ? OR h.street REGEXP ?) AND h.stars >= ? AND h.stars <= ? AND h.is_deleted = false AND "
			+ "? <= (SELECT SUM(double_beds_count)*2 + SUM(beds_count) FROM room r2 WHERE r2.hotel_id = r.hotel_id GROUP BY r2.hotel_id) AND "
			+ "r.price >= ? AND r.price <= ? AND r.is_deleted = false AND "
			+ "(o.end_date IS NULL OR o.end_date <= ? OR o.start_date >= ? OR o.status LIKE 'canceled')";

	private final String TYPE_STANDART = "r.type LIKE 'STANDART'";
	private final String TYPE_LUX = "r.type LIKE 'LUX'";
	private final String TYPE_DELUX = "r.type LIKE 'DELUX'";
	
	private final String FOOD_NONE = "r.food LIKE 'NONE'";
	private final String FOOD_BREAKFAST = "r.food LIKE 'BREAKFAST'";
	private final String FOOD_TWICE = "r.food LIKE 'TWICE'";
	private final String FOOD_FULL = "r.food LIKE 'FULL'";
	
	private final String HAS_WIFI = " AND r.has_wifi = true";
	private final String HAS_SHOWER = " AND r.has_shower = true";
	private final String HAS_PARKING = " AND r.has_parking = true";
	private final String HAS_CONDITION = " AND r.has_condition = true";
	private final String HAS_POOL = " AND r.has_pool = true";
	private final String HAS_GYM = " AND r.has_gym = true";
	private final String HAS_BALCONY = " AND r.has_balcony = true";
	private final String NO_DEPOSIT = " AND r.days_count < 0";
	
	private final String INSERT_HOTEL = "INSERT INTO `hotel` (name, city, street, stars, `desc`,"
			+ " manager_id, x_coord, y_coord, rating,"
			+ " is_deleted, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SELECT_BY_ID = "SELECT * FROM `hotel` WHERE hotel_id = ?";
	private final String CHANGE_HOTEL_STATUS = "UPDATE `hotel` SET is_deleted = ? WHERE hotel_id = ?";
	private final String UPDATE_HOTEL = "UPDATE `hotel` SET name = ?,"
			+ " city = ?, street = ?, stars = ?, desc = ?, manager_id = ?,"
			+ " x_coord = ?, y_coord = ?, rating = ?, is_deleted = ?, phone_number = ? WHERE hotel_id = ?";
	
	public HotelDao(Connection connection){
		super();
		this.connection = connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public List<Hotel> getAllHotels(){
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_NOT_DELETED);
				ResultSet result = statement.executeQuery()) {
			return UniversalTransformer.getCollectionFromRS(result, Hotel.class);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public List<Hotel> getAllHotelsByPage(int page, String orderBy) {
		String ORDER_BY;
		if("compareByStarsAsc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_STARS_ASC;
		} else if ("compareByStarsDesc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_STARS_DESC;
			
		} else if ("compareByRatingAsc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_RATING_ASC;
		} else { //compareByRatingDesc = default
			ORDER_BY = ORDER_BY_RATING_DESC;
		}
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_NOT_DELETED + ORDER_BY + PAGINATION)) {
			statement.setInt(1, (page-1)*3);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, Hotel.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public List<Hotel> getAllSuitableHotels(String name, int minStars, int maxStars, int people,	//main search
			boolean typeStandart, boolean typeLux, boolean typeDelux, 								//room type
			boolean foodNone, boolean foodBreakfast, boolean foodTwice, boolean foodFull, 			//food type
			int minPrice, int maxPrice,																//price
			boolean hasWiFi, boolean hasShower, boolean hasParking, boolean hasCondition, 			//additional
			boolean hasPool, boolean hasGym, boolean hasBalcony, boolean noDeposit, 
			Timestamp startDate, Timestamp endDate, int page, String orderBy){												//dates
		
		StringBuilder SQL = new StringBuilder(SELECT_ALL_SUITABLE);
		//ROOM TYPE
		if(typeStandart == true || typeLux == true || typeDelux == true) {
			SQL.append(" AND (");
			if(typeStandart == true) {
				SQL.append(TYPE_STANDART);
			}
			if(typeLux == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(TYPE_LUX);
			}
			if(typeDelux == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(TYPE_DELUX);
			}
			SQL.append(")");
		}
		
		//FOOD
		if(foodNone == true || foodBreakfast == true || foodTwice == true || foodFull == true) {
			SQL.append(" AND (");
			if(foodNone == true) {
				SQL.append(FOOD_NONE);
			}
			if(foodBreakfast == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_BREAKFAST);
			}
			if(foodTwice == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_TWICE);
			}
			if(foodFull == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_FULL);
			}
			SQL.append(")");
		}
		
		//ADDITIONAL
		if(hasWiFi) {
			SQL.append(HAS_WIFI);
		}
		if(hasShower) {
			SQL.append(HAS_SHOWER);
		}
		if(hasParking) {
			SQL.append(HAS_PARKING);
		}
		if(hasCondition) {
			SQL.append(HAS_CONDITION);
		}
		if(hasPool) {
			SQL.append(HAS_POOL);
		}
		if(hasGym) {
			SQL.append(HAS_GYM);
		}
		if(hasBalcony) {
			SQL.append(HAS_BALCONY);
		}
		if(noDeposit) {
			SQL.append(NO_DEPOSIT);
		}
		
		String ORDER_BY;
		if("compareByStarsAsc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_STARS_ASC;
		} else if ("compareByStarsDesc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_STARS_DESC;
			
		} else if ("compareByRatingAsc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_RATING_ASC;
		} else { //compareByRatingDesc = default
			ORDER_BY = ORDER_BY_RATING_DESC;
		}
		SQL.append(ORDER_BY);
		SQL.append(PAGINATION);
		try (PreparedStatement statement = connection.prepareStatement(SQL.toString())) {
			int i = 1;
			statement.setString(i++, ".*" + name + ".*");
			statement.setString(i++, ".*" + name + ".*");
			statement.setString(i++, ".*" + name + ".*");
			
			statement.setInt(i++, minStars);
			statement.setInt(i++, maxStars);
			
			statement.setInt(i++, people);
			
			statement.setInt(i++, minPrice);
			statement.setInt(i++, maxPrice);
			
			statement.setTimestamp(i++, startDate);
			statement.setTimestamp(i++, endDate);
			
			statement.setInt(i, (page-1)*3);
			
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, Hotel.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public Hotel getHotelById(int id) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
			statement.setInt(1, id);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, Hotel.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int insertHotel(Hotel hotel){
		try (PreparedStatement statement = connection.prepareStatement(INSERT_HOTEL)) {
			int i = 1;
			statement.setString(i++, hotel.getName());
			statement.setString(i++, hotel.getCity());
			statement.setString(i++, hotel.getStreet());
			statement.setInt(i++, hotel.getStars());
			statement.setString(i++, hotel.getDesc());
			statement.setInt(i++, hotel.getManagerId());
			statement.setDouble(i++, hotel.getXCoord());
			statement.setDouble(i++, hotel.getYCoord());
			statement.setDouble(i++, hotel.getRating());
			statement.setBoolean(i++, hotel.isDeleted());
			statement.setString(i++, hotel.getPhoneNumber());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int removeHotel(Hotel hotel) {
		try (PreparedStatement statment = connection.prepareStatement(CHANGE_HOTEL_STATUS)) {
			statment.setBoolean(1, true);
			statment.setInt(2, hotel.getId());
			return statment.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int restoreHotel(Hotel hotel) {
		try (PreparedStatement statment = connection.prepareStatement(CHANGE_HOTEL_STATUS)) {
			statment.setBoolean(1, false);
			statment.setInt(2, hotel.getId());
			return statment.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int updateHotel(Hotel hotel) {
		try (PreparedStatement statement = connection.prepareStatement(UPDATE_HOTEL)) {
			int i = 1;
			statement.setString(i++, hotel.getName());
			statement.setString(i++, hotel.getCity());
			statement.setString(i++, hotel.getStreet());
			statement.setInt(i++, hotel.getStars());
			statement.setString(i++, hotel.getDesc());
			statement.setInt(i++, hotel.getManagerId());
			statement.setDouble(i++, hotel.getXCoord());
			statement.setDouble(i++, hotel.getYCoord());
			statement.setDouble(i++, hotel.getRating());
			statement.setBoolean(i++, hotel.isDeleted());
			statement.setString(i++, hotel.getPhoneNumber());

			statement.setInt(i, hotel.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int getSuitableHotelsNumber(String name, int minStars, int maxStars, int people, boolean typeStandart,
			boolean typeLux, boolean typeDelux, boolean foodNone, boolean foodBreakfast, boolean foodTwice,
			boolean foodFull, int minPrice, int maxPrice, boolean hasWiFi, boolean hasShower, boolean hasParking,
			boolean hasCondition, boolean hasPool, boolean hasGym, boolean hasBalcony, boolean noDeposit,
			Timestamp startDate, Timestamp endDate) {

		StringBuilder SQL = new StringBuilder(SELECT_ALL_SUITABLE);
		//ROOM TYPE
		if(typeStandart == true || typeLux == true || typeDelux == true) {
			SQL.append(" AND (");
			if(typeStandart == true) {
				SQL.append(TYPE_STANDART);
			}
			if(typeLux == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(TYPE_LUX);
			}
			if(typeDelux == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(TYPE_DELUX);
			}
			SQL.append(")");
		}
		
		//FOOD
		if(foodNone == true || foodBreakfast == true || foodTwice == true || foodFull == true) {
			SQL.append(" AND (");
			if(foodNone == true) {
				SQL.append(FOOD_NONE);
			}
			if(foodBreakfast == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_BREAKFAST);
			}
			if(foodTwice == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_TWICE);
			}
			if(foodFull == true) {
				if(!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_FULL);
			}
			SQL.append(")");
		}
		
		//ADDITIONAL
		if(hasWiFi) {
			SQL.append(HAS_WIFI);
		}
		if(hasShower) {
			SQL.append(HAS_SHOWER);
		}
		if(hasParking) {
			SQL.append(HAS_PARKING);
		}
		if(hasCondition) {
			SQL.append(HAS_CONDITION);
		}
		if(hasPool) {
			SQL.append(HAS_POOL);
		}
		if(hasGym) {
			SQL.append(HAS_GYM);
		}
		if(hasBalcony) {
			SQL.append(HAS_BALCONY);
		}
		if(noDeposit) {
			SQL.append(NO_DEPOSIT);
		}
		
		try (PreparedStatement statement = connection.prepareStatement(SQL.toString())) {
			int i = 1;
			statement.setString(i++, ".*" + name + ".*");
			statement.setString(i++, ".*" + name + ".*");
			statement.setString(i++, ".*" + name + ".*");
			
			statement.setInt(i++, minStars);
			statement.setInt(i++, maxStars);
			
			statement.setInt(i++, people);
			
			statement.setInt(i++, minPrice);
			statement.setInt(i++, maxPrice);
			
			statement.setTimestamp(i++, startDate);
			statement.setTimestamp(i++, endDate);
			
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, Hotel.class).size();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	public List<Hotel> getRecomendedHotels(int hotelId) {
		//get all orders by hotel
		//get all user id's from this list (distinct, add to set)
		//for every user get his orders and add to map (hotel id, times)
		//sort map by value get first three elements
		
		List<Order> orders = new OrderService().getOrdersByHotel(hotelId);		//all orders in this hotel
		Set<Integer> userIds = new HashSet<>();
		for (Order order : orders) {		//all users, who were in this hotel
			userIds.add(order.getUserId());
		}
		System.out.println("Users visited this hotel: " + userIds);
		
		Map<Integer, Integer> hotelsVisited  = new HashMap<>();		//contains all visited hotels and how many times
		for (Integer userId : userIds) {
			List<Order> userOrders = new OrderService().getOrdersByUser(userId); //get all user's orders
			for (Order order : userOrders) {
				int roomId = order.getRoomId();
				int holelId = new RoomService().getRoomById(roomId).getHotelId();
				if(hotelsVisited.containsKey(holelId)) {	//increment
					hotelsVisited.put(holelId, hotelsVisited.get(hotelId) + 1);
				} else {									//put
					hotelsVisited.put(holelId, 1);
				}
			}
		}
		System.out.println("Hotels visited, how many times: " + hotelsVisited);
		
		hotelsVisited = MapUtil.sortByValue(hotelsVisited); //sort map by values
		System.out.println("Hotels visited, how many times, sorted: " + hotelsVisited);
		List<Hotel> result = new ArrayList<>();
		int i = 0;
		for (Integer resultHotelId : hotelsVisited.keySet()) {	//get first three elements
			if (i < 3) {
				result.add(new HotelService().getHotelById(resultHotelId));
				i++;
			} else {
				break;
			}
		}		
		System.out.println("First three or less hotels: " + result);
		return result;
	}
}
