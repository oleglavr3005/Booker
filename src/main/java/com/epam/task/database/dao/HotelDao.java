package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.transformers.UniversalTransformer;

public class HotelDao {


	private Connection connection;
	
	private final String SELECT_ALL = "SELECT * FROM `hotel`";
	private final String INSERT_HOTEL = "INSERT INTO `hotel` (hotel_id, name, city, street, stars, desc,"
			+ " manager_id, x_coord, y_coord, rating,"
			+ " is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final String SELECT_BY_ID = SELECT_ALL + " WHERE hotel_id = ?";
	private final String DELETE_HOTEL = "INSERT hotel SET is_deleted=? WHERE hotel_id = ?";
	
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
	
	public int deleteHotel(Hotel hotel) {
		try (PreparedStatement statment = connection.prepareStatement(DELETE_HOTEL)) {
			statment.setInt(1, hotel.getId());
			return statment.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
