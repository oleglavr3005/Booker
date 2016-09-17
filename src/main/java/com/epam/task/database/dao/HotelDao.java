package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.transformers.UniversalTransformer;

public class HotelDao {


	private Connection connection;
	
	private final String SELECT_ALL_NOT_DELETED_NOT_BANNED = "SELECT * FROM `hotel` h INNER JOIN `user` u ON h.manager_id = u.user_id WHERE h.is_deleted = false AND u.status NOT LIKE 'BANNED'";
	private final String SELECT_ALL_BY_MANAGER = "SELECT * FROM `hotel` WHERE manager_id = ?";
	private final String ORDER_BY_STARS_ASC = " ORDER BY stars ASC";
	private final String ORDER_BY_STARS_DESC = " ORDER BY stars DESC";
	private final String ORDER_BY_RATING_ASC = " ORDER BY rating ASC";
	private final String ORDER_BY_RATING_DESC = " ORDER BY rating DESC";
	private final String PAGINATION = " LIMIT ?, 5";
	
	private final String SELECT_ALL_SUITABLE = "SELECT DISTINCT h.* FROM hotel h INNER JOIN user u ON h.manager_id = u.user_id INNER JOIN room r ON h.hotel_id = r.hotel_id LEFT JOIN `order` o ON "
			+ "(o.room_id = r.room_id AND o.status NOT LIKE 'canceled' AND (o.end_date > ? AND o.start_date < ?) ) "
			+ "WHERE (h.name REGEXP ? OR h.location REGEXP ?) AND h.stars >= ? AND h.stars <= ? AND h.is_deleted = false AND "
			+ "? <= (SELECT SUM(double_beds_count)*2 + SUM(beds_count) FROM room r2 WHERE r2.hotel_id = r.hotel_id GROUP BY r2.hotel_id) AND "
			+ "r.price >= ? AND r.price <= ? AND r.is_deleted = false AND "
			+ "o.end_date IS NULL AND u.status NOT LIKE 'BANNED'";

	private final String TYPE_STANDART = "r.type LIKE 'STANDART'";
	private final String TYPE_LUX = "r.type LIKE 'LUX'";
	private final String TYPE_DELUX = "r.type LIKE 'DELUX'";
	
	private final String FOOD_NONE = "r.food LIKE 'NONE'";
	private final String FOOD_BREAKFAST = "r.food LIKE 'BREAKFAST'";
	private final String FOOD_TWICE = "r.food LIKE 'TWICE'";
	private final String FOOD_FULL = "r.food LIKE 'FULL'";
	
	private final String HAS_WIFI = " AND r.has_wifi = true";
	private final String HAS_SHOWER = " AND r.has_shower = true";
	private final String HAS_CONDITION = " AND r.has_condition = true";
	private final String HAS_BALCONY = " AND r.has_balcony = true";
	private final String HAS_TV = " AND r.has_tv = true";
	private final String NO_DEPOSIT = " AND r.days_count < 0";
	
	private final String HAS_PARKING = " AND h.has_parking = true";
	private final String HAS_POOL = " AND h.has_pool = true";
	private final String HAS_GYM = " AND h.has_gym = true";
	private final String HAS_SPA = " AND h.has_spa = true";
	private final String HAS_SERVICE = " AND h.has_service = true";
	private final String HAS_CLEANER = " AND h.has_cleaner = true";
	
	private final String INSERT_HOTEL = "INSERT INTO `hotel` (name, location, stars, `desc`,"
			+ " manager_id, x_coord, y_coord, rating,"
			+ " is_deleted, phone_number, has_parking, has_pool, has_gym, has_spa, has_service, has_cleaner) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SELECT_BY_ID = "SELECT * FROM `hotel` WHERE hotel_id = ?";
	
	
	private final String CHANGE_HOTEL_STATUS = "UPDATE `hotel` SET is_deleted = ? WHERE hotel_id = ?";
	private final String UPDATE_HOTEL = "UPDATE `hotel` SET name = ?,"
			+ " location = ?, stars = ?, `desc` = ?, manager_id = ?,"
			+ " x_coord = ?, y_coord = ?, rating = ?, is_deleted = ?, phone_number = ?,"
			+ " has_parking = ?, has_pool = ?, has_gym = ?, has_spa = ?, has_service = ?,"
			+ " has_cleaner = ? WHERE hotel_id = ?";
	private final String UPDATE_HOTEL_RATING = "UPDATE `hotel` SET rating = ? WHERE hotel_id = ?";
	public HotelDao(Connection connection){
		super();
		this.connection = connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public List<Hotel> getAllHotels(){
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_NOT_DELETED_NOT_BANNED);
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
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_NOT_DELETED_NOT_BANNED + ORDER_BY + PAGINATION)) {
			statement.setInt(1, (page-1)*5);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, Hotel.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public List<Hotel> getAllSuitableHotelsByPage(String name, int minStars, int maxStars, int people,	//main search
			boolean typeStandart, boolean typeLux, boolean typeDelux, 								//room type
			boolean foodNone, boolean foodBreakfast, boolean foodTwice, boolean foodFull, 			//food type
			int minPrice, int maxPrice,																//price
			boolean hasWiFi, boolean hasShower, boolean hasParking, boolean hasCondition, 			//additional
			boolean hasPool, boolean hasGym, boolean hasBalcony, boolean hasSpa, 
			boolean hasService, boolean hasCleaner, boolean hasTv, boolean noDeposit, 
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

		// ADDITIONAL
		if (hasWiFi) {
			SQL.append(HAS_WIFI);
		}
		if (hasShower) {
			SQL.append(HAS_SHOWER);
		}
		if (hasCondition) {
			SQL.append(HAS_CONDITION);
		}
		if (hasBalcony) {
			SQL.append(HAS_BALCONY);
		}
		if (noDeposit) {
			SQL.append(NO_DEPOSIT);
		}
		if (hasParking) {
			SQL.append(HAS_PARKING);
		}
		if (hasPool) {
			SQL.append(HAS_POOL);
		}
		if (hasGym) {
			SQL.append(HAS_GYM);
		}
		if (hasSpa) {
			SQL.append(HAS_SPA);
		}
		if (hasService) {
			SQL.append(HAS_SERVICE);
		}
		if (hasCleaner) {
			SQL.append(HAS_CLEANER);
		}
		if (hasTv) {
			SQL.append(HAS_TV);
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
			statement.setTimestamp(i++, startDate);
			statement.setTimestamp(i++, endDate);
			
			statement.setString(i++, ".*" + name + ".*");
			statement.setString(i++, ".*" + name + ".*");
			
			statement.setInt(i++, minStars);
			statement.setInt(i++, maxStars);
			
			statement.setInt(i++, people);
			
			statement.setInt(i++, minPrice);
			statement.setInt(i++, maxPrice);			
			
			statement.setInt(i, (page-1)*5);
			
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
		try (PreparedStatement statement = connection.prepareStatement(INSERT_HOTEL, Statement.RETURN_GENERATED_KEYS)) {
			int i = 1;
			statement.setString(i++, hotel.getName());
			statement.setString(i++, hotel.getLocation());
			statement.setInt(i++, hotel.getStars());
			statement.setString(i++, hotel.getDesc());
			statement.setInt(i++, hotel.getManagerId());
			statement.setDouble(i++, hotel.getXCoord());
			statement.setDouble(i++, hotel.getYCoord());
			statement.setDouble(i++, hotel.getRating());
			statement.setBoolean(i++, hotel.getIsDeleted());
			statement.setString(i++, hotel.getPhoneNumber());
			
			statement.setBoolean(i++, hotel.getParking());
			statement.setBoolean(i++, hotel.getPool());
			statement.setBoolean(i++, hotel.getGym());
			statement.setBoolean(i++, hotel.getSpa());
			statement.setBoolean(i++, hotel.getService());
			statement.setBoolean(i++, hotel.getCleaner());
			
			statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int removeHotel(int hotelId) {
		try (PreparedStatement statment = connection.prepareStatement(CHANGE_HOTEL_STATUS)) {
			statment.setBoolean(1, true);
			statment.setInt(2, hotelId);
			return statment.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int restoreHotel(int hotelId) {
		try (PreparedStatement statment = connection.prepareStatement(CHANGE_HOTEL_STATUS)) {
			statment.setBoolean(1, false);
			statment.setInt(2, hotelId);
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
			statement.setString(i++, hotel.getLocation());
			statement.setInt(i++, hotel.getStars());
			statement.setString(i++, hotel.getDesc());
			statement.setInt(i++, hotel.getManagerId());
			statement.setDouble(i++, hotel.getXCoord());
			statement.setDouble(i++, hotel.getYCoord());
			statement.setDouble(i++, hotel.getRating());
			statement.setBoolean(i++, hotel.getIsDeleted());
			statement.setString(i++, hotel.getPhoneNumber());
			
			statement.setBoolean(i++, hotel.getParking());
			statement.setBoolean(i++, hotel.getPool());
			statement.setBoolean(i++, hotel.getGym());
			statement.setBoolean(i++, hotel.getSpa());
			statement.setBoolean(i++, hotel.getService());
			statement.setBoolean(i++, hotel.getCleaner());

			statement.setInt(i, hotel.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int updateHotelRating(Hotel hotel) {
		try (PreparedStatement statement = connection.prepareStatement(UPDATE_HOTEL_RATING)) {
			int i = 1;
			statement.setDouble(i++, hotel.getRating());
			
			statement.setInt(i, hotel.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public List<Hotel> getAllSuitableHotels(String name, int minStars, int maxStars, int people, boolean typeStandart,
			boolean typeLux, boolean typeDelux, boolean foodNone, boolean foodBreakfast, boolean foodTwice,
			boolean foodFull, int minPrice, int maxPrice, boolean hasWiFi, boolean hasShower, boolean hasParking,
			boolean hasCondition, boolean hasPool, boolean hasGym, boolean hasBalcony, 
			boolean hasSpa, boolean hasService, boolean hasCleaner, boolean hasTv, boolean noDeposit,
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

		// ADDITIONAL
		if (hasWiFi) {
			SQL.append(HAS_WIFI);
		}
		if (hasShower) {
			SQL.append(HAS_SHOWER);
		}
		if (hasCondition) {
			SQL.append(HAS_CONDITION);
		}
		if (hasBalcony) {
			SQL.append(HAS_BALCONY);
		}
		if (noDeposit) {
			SQL.append(NO_DEPOSIT);
		}
		if (hasParking) {
			SQL.append(HAS_PARKING);
		}
		if (hasPool) {
			SQL.append(HAS_POOL);
		}
		if (hasGym) {
			SQL.append(HAS_GYM);
		}
		if (hasSpa) {
			SQL.append(HAS_SPA);
		}
		if (hasService) {
			SQL.append(HAS_SERVICE);
		}
		if (hasCleaner) {
			SQL.append(HAS_CLEANER);
		}
		if (hasTv) {
			SQL.append(HAS_TV);
		}
		
		try (PreparedStatement statement = connection.prepareStatement(SQL.toString())) {
			int i = 1;
			statement.setTimestamp(i++, startDate);
			statement.setTimestamp(i++, endDate);
			
			statement.setString(i++, ".*" + name + ".*");
			statement.setString(i++, ".*" + name + ".*");
			
			statement.setInt(i++, minStars);
			statement.setInt(i++, maxStars);
			
			statement.setInt(i++, people);
			
			statement.setInt(i++, minPrice);
			statement.setInt(i++, maxPrice);			
			
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, Hotel.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		
	}

	public List<Hotel> getAllHotelsByManager(int managerId) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BY_MANAGER)) {
			statement.setInt(1, managerId);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, Hotel.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public List<Hotel> getAllHotelsByManagerAndPage(int managerId, int page, String orderBy) {
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
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BY_MANAGER + ORDER_BY + PAGINATION)) {
			statement.setInt(1, managerId);
			statement.setInt(2, (page-1)*5);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, Hotel.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
