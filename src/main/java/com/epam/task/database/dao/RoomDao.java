package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Room;
import com.epam.task.database.transformers.UniversalTransformer;

public class RoomDao {

	private Connection connection;

	// перевірити булеан
	private final String GET_ALL_ACIVE_ROOMS_FOR_HOTEL = "SELECT * FROM room WHERE hotel_id = ? AND is_deleted = 'false'";
	
	// перевірити булеан
	private final String GET_ALL_ROOMS_FOR_HOTEL = "SELECT * FROM room WHERE hotel_id = ?";

	private final String SQL_INSERT_ROOM = "INSERT INTO room "
			+ "(hotel_id, number, type, beds_count, double_beds_count, price, has_wifi, has_shower, has_parking,"
			+ " has_condition, has_pool, has_gym, has_balcony, food, days_count, percentage, is_deleted) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	private final String SQL_UPDATE_ROOM = "UPDATE room "
			+ "SET hotel_id= ?, number= ?, type= ?, beds_count= ?, double_beds_count= ?, price= ?, has_wifi= ?, "
			+ "has_shower= ?, has_parking= ?, has_condition= ?, has_pool= ?, has_gym= ? "
			+ "has_balcony= ?, food= ?, days_count= ?, percentage= ?, is_deleted= ? "
			+ "WHERE room_id= ?;";

	private final String SQL_CHANGE_ROOM_STATUS = "UPDATE room " 
			+ "SET is_deleted= ?"
			+ "WHERE id = ?;";

	public RoomDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public List<Room> getAllActiveRoomsForHotel(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(GET_ALL_ACIVE_ROOMS_FOR_HOTEL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			return UniversalTransformer.getCollectionFromRS(rs, Room.class);
		} catch (Exception e) {
			return new ArrayList<Room>();
		}
	}
	
	public List<Room> getAllRoomsForHotel(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(GET_ALL_ROOMS_FOR_HOTEL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			return UniversalTransformer.getCollectionFromRS(rs, Room.class);
		} catch (Exception e) {
			return new ArrayList<Room>();
		}
	}
	
	public int insertRoom(Room room) { 
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_INSERT_ROOM);) {
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
	
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateRoom(Room room) { 
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_UPDATE_ROOM);) {
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

	public int changeRoomStatus(Room room) { 
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_CHANGE_ROOM_STATUS);) {
			int i = 1;
			st.setBoolean(i++, room.getDeleted());
			
			st.setInt(i++, room.getId());
	
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
