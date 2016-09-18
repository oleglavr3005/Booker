package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Counter;
import com.epam.task.database.transformers.UniversalTransformer;

public class CounterDao {

	private Connection connection;
	private static final Logger LOGGER = Logger.getLogger(CounterDao.class);
	
	private final String INSERT_COUNTER = "INSERT INTO `visitor_counter` (hotel_id, date, `count`) VALUES (?, ?, ?)";
	private final String UPDATE_COUNTER = "UPDATE `visitor_counter` SET hotel_id = ?, date = ?, `count` = ? WHERE visitor_counter_id = ?";
	private final String SELECT_COUNTER_BY_HOTEL = "SELECT * FROM `visitor_counter` WHERE hotel_id = ?";
	private final String SELECT_COUNTER_BY_ID = "SELECT * FROM `visitor_counter` WHERE visitor_counter_id = ?";
	private final String SELECT_COUNTER_BY_HOTEL_AND_DATE = "SELECT * FROM `visitor_counter` WHERE hotel_id = ? AND date = ?";

	public CounterDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public int insertCounter(Counter counter) {
		try (PreparedStatement statment = connection.prepareStatement(INSERT_COUNTER)) {
			statment.setInt(1, counter.getHotelId());
			statment.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(counter.getDate()));
			statment.setInt(3, counter.getCount());
			int result = statment.executeUpdate();
			if(result > 0) {
	        	LOGGER.info("New counter inserted");
			}
			return result;
		} catch (Exception e) {
        	LOGGER.error("Cannot insert counter", e);
			return -1;
		}
	}

	public int updateCounter(Counter counter) {
		try (PreparedStatement statment = connection.prepareStatement(UPDATE_COUNTER)) {
			statment.setInt(1, counter.getHotelId());
			statment.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(counter.getDate()));
			statment.setInt(3, counter.getCount());

			statment.setInt(4, counter.getId());
			int result = statment.executeUpdate();
			if(result > 0) {
	        	LOGGER.info("Counter updated");
			}
			return result;
		} catch (Exception e) {
        	LOGGER.error("Cannot update counter", e);
			return -1;
		}
	}

	public List<Counter> getCountersByHotel(int hotelId) {
		try (PreparedStatement statment = connection.prepareStatement(SELECT_COUNTER_BY_HOTEL)){
			statment.setInt(1, hotelId);
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getCollectionFromRS(rs, Counter.class);
		} catch(SQLException e){
        	LOGGER.error("Cannot get counters by hotel", e);
			return new ArrayList<>();
		}
	}

	public Counter getCounterById(int id) {
		try (PreparedStatement statment = connection.prepareStatement(SELECT_COUNTER_BY_ID)){
			statment.setInt(1, id);
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getObjectFromRS(rs, Counter.class);
		} catch(SQLException e){
        	LOGGER.error("Cannot get counter by id", e);
			return null;
		}
	}

	public Counter getCounterByHotelAndDate(int hotelId, Timestamp date) {
		try (PreparedStatement statment = connection.prepareStatement(SELECT_COUNTER_BY_HOTEL_AND_DATE)){
			statment.setInt(1, hotelId);
			statment.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(date));
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getObjectFromRS(rs, Counter.class);
		} catch(SQLException e){
        	LOGGER.error("Cannot get counter by hotel and date", e);
			return null;
		}
	}
}
