package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.transformers.UniversalTransformer;

public class HotelDao {


	private Connection connection;
	
	private final String SELECT_ALL = "SELECT * FROM `hotel`";
	private final String SELECT_ALL_SUITABLE = "SELECT DISTINCT h.* FROM hotel h INNER JOIN room r ON h.hotel_id = r.hotel_id LEFT JOIN `order` o ON o.room_id = r.room_id "
			+ "WHERE (h.name REGEXP ? OR h.city REGEXP ? OR h.street REGEXP ?) AND h.stars >= ? AND h.stars <= ? AND h.is_deleted = false AND "
			+ "? <= (SELECT SUM(double_beds_count)*2 + SUM(beds_count) FROM room r2 WHERE r2.room_id = r.room_id GROUP BY r2.hotel_id) AND "
			+ "r.price >= ? AND r.price <= ? AND r.is_deleted = false AND "
			+ "(o.end_date <= ? OR o.start_date >= ? OR o.status LIKE 'canceled')";

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

	
	private final String INSERT_HOTEL = "INSERT INTO `hotel` (hotel_id, name, city, street, stars, desc,"
			+ " manager_id, x_coord, y_coord, rating,"
			+ " is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final String SELECT_BY_ID = SELECT_ALL + " WHERE hotel_id = ?";
	private final String CHANGE_HOTEL_STATUS = "UPDATE `hotel` SET is_deleted = ? WHERE hotel_id = ?";
	private final String UPDATE_HOTEL = "UPDATE `hotel` SET hotel_id = ?, name = ?,"
			+ " city = ?, street = ?, stars = ?, desc = ?, manager_id = ?,"
			+ " x_coord = ?, y_coord = ?, rating = ?, WHERE hotel_id = ?";
	
	public HotelDao(Connection connection){
		super();
		this.connection = connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public List<Hotel> getAllHotels(){
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
				ResultSet result = statement.executeQuery()) {
			return UniversalTransformer.getCollectionFromRS(result, Hotel.class);
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
			Timestamp startDate, Timestamp endDate){												//dates
		
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
			statement.setTimestamp(i, endDate);
			
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
			statement.setInt(i++, hotel.getId());
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
			statment.setBoolean(1, true);
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
			statement.setInt(i++, hotel.getId());
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

			statement.setInt(i, hotel.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
