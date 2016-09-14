package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Room;
import com.epam.task.database.transformers.UniversalTransformer;

public class RoomDao {

	private Connection connection;

	private final String GET_ALL_ACIVE_ROOMS_FOR_HOTEL = "SELECT * FROM room WHERE hotel_id = ? AND is_deleted = 'false'";
	
	private final String GET_ALL_SUITABLE_ROOMS_FOR_HOTEL = "SELECT DISTINCT r.* FROM room r LEFT JOIN `order` o ON "
			+ "(o.room_id = r.room_id AND o.status NOT LIKE 'canceled' AND (o.end_date > ? AND o.start_date < ?) ) "
			+ "WHERE r.hotel_id = ? AND r.price >= ? AND r.price <= ? AND r.is_deleted = false AND "
			+ "? <= (SELECT SUM(double_beds_count)*2 + SUM(beds_count) FROM room r2 WHERE r2.room_id = r.room_id GROUP BY r2.hotel_id) AND "
			+ "o.end_date IS NULL";

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

	private final String ORDER_BY_PRICE_ASC = " ORDER BY price ASC";
	private final String ORDER_BY_PRICE_DESC = " ORDER BY price DESC";
	private final String ORDER_BY_PEOPLE_ASC = " ORDER BY double_beds_count*2 + beds_count ASC";
	private final String ORDER_BY_PEOPLE_DESC = " ORDER BY double_beds_count*2 + beds_count DESC";
	
	private final String PAGINATION = " LIMIT ?, 5";
	
	private final String GET_ALL_ROOMS_FOR_HOTEL = "SELECT * FROM room WHERE hotel_id = ?";
	
	private final String GET_ROOM_BY_ID = "SELECT * FROM room WHERE room_id = ?";

	private final String SQL_INSERT_ROOM = "INSERT INTO room "
			+ "(hotel_id, number, type, beds_count, double_beds_count, price, has_wifi, has_shower, has_parking,"
			+ " has_condition, has_pool, has_gym, has_balcony, food, days_count, percentage, is_deleted) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	private final String SQL_UPDATE_ROOM = "UPDATE room "
			+ "SET hotel_id= ?, number= ?, type= ?, beds_count= ?, double_beds_count= ?, price= ?, has_wifi= ?, "
			+ "has_shower= ?, has_parking= ?, has_condition= ?, has_pool= ?, has_gym= ?, "
			+ "has_balcony= ?, food= ?, days_count= ?, percentage= ?, is_deleted= ? "
			+ "WHERE room_id= ?;";

	private final String SQL_CHANGE_ROOM_STATUS = "UPDATE room " 
			+ "SET is_deleted = ? "
			+ "WHERE room_id = ? ;";
	
	private final String GET_MIN_PRICE = "SELECT MIN(price) FROM room WHERE is_deleted = false";
	private final String GET_MAX_PRICE = "SELECT MAX(price) FROM room WHERE is_deleted = false";
	
	private final String GET_ROOM_BY_ID_IF_AVAILABLE = "SELECT DISTINCT r.* FROM room r LEFT JOIN `order` o ON "
			+ "(o.room_id = r.room_id AND o.status NOT LIKE 'canceled' AND (o.end_date > ? AND o.start_date < ?) ) WHERE r.room_id = ? AND "
			+ "o.end_date IS NULL";

	public RoomDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<Room> getAllRoomsForHotel(int hotelId) {
		try (PreparedStatement ps = connection.prepareStatement(GET_ALL_ROOMS_FOR_HOTEL)) {
			ps.setInt(1, hotelId);
			try (ResultSet rs = ps.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(rs, Room.class);
			}
		} catch (Exception e) {
			return new ArrayList<Room>();
		}
	}
	
	public List<Room> getAllActiveRoomsForHotel(int id, int page) {
		try (PreparedStatement ps = connection.prepareStatement(GET_ALL_ACIVE_ROOMS_FOR_HOTEL + PAGINATION)) {
			ps.setInt(1, id);
			ps.setInt(2, (page-1)*5);
			try (ResultSet rs = ps.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(rs, Room.class);
			}
		} catch (Exception e) {
			return new ArrayList<Room>();
		}
	}
	
	public List<Room> getAllSuitableRoomsForHotel(int id, int page, 
			boolean typeStandart, boolean typeLux, boolean typeDelux, 
			boolean foodNone, boolean foodBreakfast, boolean foodTwice, boolean foodFull,
			int minPrice, int maxPrice, int people,
			boolean hasWiFi, boolean hasShower, boolean hasParking, boolean hasCondition, 
			boolean hasPool, boolean hasGym, boolean hasBalcony, boolean noDeposit,
			Timestamp startDate, Timestamp endDate, String orderBy) {

		StringBuilder SQL = new StringBuilder(GET_ALL_SUITABLE_ROOMS_FOR_HOTEL);
		//ROOM TYPE
		if (typeStandart == true || typeLux == true || typeDelux == true) {
			SQL.append(" AND (");
			if (typeStandart == true) {
				SQL.append(TYPE_STANDART);
			}
			if (typeLux == true) {
				if (!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(TYPE_LUX);
			}
			if (typeDelux == true) {
				if (!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(TYPE_DELUX);
			}
			SQL.append(")");
		}

		// FOOD
		if (foodNone == true || foodBreakfast == true || foodTwice == true || foodFull == true) {
			SQL.append(" AND (");
			if (foodNone == true) {
				SQL.append(FOOD_NONE);
			}
			if (foodBreakfast == true) {
				if (!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_BREAKFAST);
			}
			if (foodTwice == true) {
				if (!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_TWICE);
			}
			if (foodFull == true) {
				if (!SQL.toString().endsWith("(")) {
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
		if (hasParking) {
			SQL.append(HAS_PARKING);
		}
		if (hasCondition) {
			SQL.append(HAS_CONDITION);
		}
		if (hasPool) {
			SQL.append(HAS_POOL);
		}
		if (hasGym) {
			SQL.append(HAS_GYM);
		}
		if (hasBalcony) {
			SQL.append(HAS_BALCONY);
		}
		if (noDeposit) {
			SQL.append(NO_DEPOSIT);
		}
		
		String ORDER_BY;
		if("compareByPriceAsc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_PRICE_ASC;
		} else if ("compareByPriceDesc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_PRICE_DESC;
			
		} else if ("compareByPeopleAsc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_PEOPLE_ASC;
		} else { //compareByPeopleDesc = default
			ORDER_BY = ORDER_BY_PEOPLE_DESC;
		}
		SQL.append(ORDER_BY);
		SQL.append(PAGINATION);
				
		try (PreparedStatement statement = connection.prepareStatement(SQL.toString())) {
			int i = 1;			
			statement.setTimestamp(i++, startDate);
			statement.setTimestamp(i++, endDate);
			
			statement.setInt(i++, id);
			
			statement.setInt(i++, minPrice);
			statement.setInt(i++, maxPrice);
			
			statement.setInt(i++, people);
			
			statement.setInt(i, (page-1)*5);
			
			try (ResultSet rs = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(rs, Room.class);
			}
		} catch (Exception e) {
			return new ArrayList<Room>();
		}
	}
	
	public List<Room> getAllRoomsForHotel(int id, int page) {
		try (PreparedStatement ps = connection.prepareStatement(GET_ALL_ROOMS_FOR_HOTEL + PAGINATION)) {
			ps.setInt(1, id);
			ps.setInt(2, (page-1)*5);
			try (ResultSet rs = ps.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(rs, Room.class);
			}			
		} catch (Exception e) {
			return new ArrayList<Room>();
		}
	}
	
	public Room getRoomById(int id) {
		try (PreparedStatement statement = connection.prepareStatement(GET_ROOM_BY_ID)) {
			statement.setInt(1, id);
			try (ResultSet rs = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(rs, Room.class);
			}			
		} catch (Exception e) {
			return null;
		}
	}
		
	public int insertRoom(Room room) { 
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_INSERT_ROOM, Statement.RETURN_GENERATED_KEYS)) {
			int i = 1;
			st.setInt(i++, room.getHotelId());
			st.setString(i++, room.getNumber());
			st.setString(i++, room.getType().toString());
			st.setInt(i++, room.getBedsCount());
			st.setInt(i++, room.getDoubleBedsCount());
			st.setInt(i++, room.getPrice());
			st.setBoolean(i++, room.getWifi());
			st.setBoolean(i++, room.getShower());
			st.setBoolean(i++, room.getParking());
			st.setBoolean(i++, room.getCondition());
			st.setBoolean(i++, room.getPool());
			st.setBoolean(i++, room.getGym());
			st.setBoolean(i++, room.getBalcony());
			st.setString(i++, room.getFood().toString());
			st.setInt(i++, room.getDaysCount());
			st.setInt(i++, room.getPercentage());
			st.setBoolean(i++, room.getDeleted());
			st.executeUpdate();
			
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateRoom(Room room) { 
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_UPDATE_ROOM)) {
			int i = 1;
			st.setInt(i++, room.getHotelId());
			st.setString(i++, room.getNumber());
			st.setString(i++, room.getType().toString());
			st.setInt(i++, room.getBedsCount());
			st.setInt(i++, room.getDoubleBedsCount());
			st.setInt(i++, room.getPrice());
			st.setBoolean(i++, room.getWifi());
			st.setBoolean(i++, room.getShower());
			st.setBoolean(i++, room.getParking());
			st.setBoolean(i++, room.getCondition());
			st.setBoolean(i++, room.getPool());
			st.setBoolean(i++, room.getGym());
			st.setBoolean(i++, room.getBalcony());
			st.setString(i++, room.getFood().toString());
			st.setInt(i++, room.getDaysCount());
			st.setInt(i++, room.getPercentage());
			st.setBoolean(i++, room.getDeleted());
			
			st.setInt(i++, room.getId());
	
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int removeRoom(int id) { 
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_CHANGE_ROOM_STATUS)) {
			int i = 1;
			st.setBoolean(i++, Boolean.TRUE);
			
			st.setInt(i++, id);
			
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int restoreRoom(int id) { 
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_CHANGE_ROOM_STATUS)) {
			int i = 1;
			st.setBoolean(i++, Boolean.FALSE);
			
			st.setInt(i++, id);
	
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getMinPrice(){
		try(PreparedStatement st = connection.prepareStatement(GET_MIN_PRICE);
				ResultSet result = st.executeQuery()){
			if(result.next()) {
				return result.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public int getMaxPrice(){
		try(PreparedStatement st = connection.prepareStatement(GET_MAX_PRICE);
				ResultSet result = st.executeQuery()){
			if(result.next()) {
				return result.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}

	public boolean isRoomAvailable(int roomId, Timestamp startDate, Timestamp endDate) {
		try (PreparedStatement st = connection.prepareStatement(GET_ROOM_BY_ID_IF_AVAILABLE)) {
			int i = 1;
			st.setTimestamp(i++, startDate);
			st.setTimestamp(i++, endDate);
			
			st.setInt(i++, roomId);
			try (ResultSet result = st.executeQuery()) {
				if (result.next()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Room> getSuitableRooms(int id, boolean typeStandart, boolean typeLux, boolean typeDelux,
			boolean foodNone, boolean foodBreakfast, boolean foodTwice, boolean foodFull, int minPrice, int maxPrice,
			int people, boolean hasWiFi, boolean hasShower, boolean hasParking, boolean hasCondition, boolean hasPool,
			boolean hasGym, boolean hasBalcony, boolean noDeposit, Timestamp startDate, Timestamp endDate) {
		
		StringBuilder SQL = new StringBuilder(GET_ALL_SUITABLE_ROOMS_FOR_HOTEL);
		//ROOM TYPE
		if (typeStandart == true || typeLux == true || typeDelux == true) {
			SQL.append(" AND (");
			if (typeStandart == true) {
				SQL.append(TYPE_STANDART);
			}
			if (typeLux == true) {
				if (!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(TYPE_LUX);
			}
			if (typeDelux == true) {
				if (!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(TYPE_DELUX);
			}
			SQL.append(")");
		}

		// FOOD
		if (foodNone == true || foodBreakfast == true || foodTwice == true || foodFull == true) {
			SQL.append(" AND (");
			if (foodNone == true) {
				SQL.append(FOOD_NONE);
			}
			if (foodBreakfast == true) {
				if (!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_BREAKFAST);
			}
			if (foodTwice == true) {
				if (!SQL.toString().endsWith("(")) {
					SQL.append(" OR ");
				}
				SQL.append(FOOD_TWICE);
			}
			if (foodFull == true) {
				if (!SQL.toString().endsWith("(")) {
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
		if (hasParking) {
			SQL.append(HAS_PARKING);
		}
		if (hasCondition) {
			SQL.append(HAS_CONDITION);
		}
		if (hasPool) {
			SQL.append(HAS_POOL);
		}
		if (hasGym) {
			SQL.append(HAS_GYM);
		}
		if (hasBalcony) {
			SQL.append(HAS_BALCONY);
		}
		if (noDeposit) {
			SQL.append(NO_DEPOSIT);
		}
				
		try (PreparedStatement statement = connection.prepareStatement(SQL.toString())) {
			int i = 1;
			statement.setTimestamp(i++, startDate);
			statement.setTimestamp(i++, endDate);
			
			statement.setInt(i++, id);
			
			statement.setInt(i++, minPrice);
			statement.setInt(i++, maxPrice);
			
			statement.setInt(i++, people);
			
			try (ResultSet rs = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(rs, Room.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
