package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Feedback;
import com.epam.task.database.transformers.UniversalTransformer;

public class FeedbackDao {
	private Connection connection;
	private static final Logger LOGGER = Logger.getLogger(FeedbackDao.class);
	
	private final String SELECT_ALL_FEEDBACK = "SELECT * FROM feedback";
	private final String INSERT_FEEDBACK = "INSERT INTO feedback (user_id, hotel_id, rating, title, comment, date) VALUES (?, ?, ?, ?, ?, ?)";
	private final String UPDATE_FEEDBACK = "UPDATE feedback SET user_id = ?, hotel_id = ?, rating = ?, comment = ?, title = ?, date = ? WHERE feedback_id = ?";
	private final String DELETE_FEEDBACK = "DELETE FROM feedback WHERE feedback_id = ?";
	private final String SELECT_ALL_FEEDBACK_BY_HOTEL = "SELECT * FROM feedback WHERE hotel_id = ?";
	private final String SELECT_ALL_FEEDBACK_BY_USER = "SELECT * FROM feedback WHERE user_id = ?";
	private final String SELECT_FEEDBACK_BY_ID = "SELECT * FROM feedback WHERE feedback_id = ?";
	private final String SELECT_FEEDBACK_BY_USER_AND_HOTEL = "SELECT * FROM feedback WHERE user_id = ? AND hotel_id = ?";

	private final String ORDER_BY_DATE_ASC = " ORDER BY date ASC";
	private final String ORDER_BY_DATE_DESC = " ORDER BY date DESC";
	
	private final String PAGINATION = " LIMIT ?, 5";
	
	public FeedbackDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<Feedback> getAllFeedbacks() {
		try (PreparedStatement statment = connection.prepareStatement(SELECT_ALL_FEEDBACK)) {
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getCollectionFromRS(rs, Feedback.class);
		} catch (Exception e) {
        	LOGGER.error("Cannot get all feedbacks", e);
			return new ArrayList<>();
		}
	}

	public int insertFeedback(Feedback element) {
		try (PreparedStatement statment = connection.prepareStatement(INSERT_FEEDBACK)) {
			statment.setInt(1, element.getUserId());
			statment.setInt(2, element.getHotelId());
			statment.setInt(3, element.getRating());
			statment.setString(4, element.getTitle());
			statment.setString(5, element.getComment());
			statment.setTimestamp(6, element.getDate());
			int result = statment.executeUpdate();
			if(result > 0) {
	        	LOGGER.info("New feedback inserted");
			}
			return result;
		} catch (Exception e) {
        	LOGGER.error("Cannot insert feedback", e);
			return -1;
		}
	}

	public int updateFeedback(Feedback element) {
		try (PreparedStatement statment = connection.prepareStatement(UPDATE_FEEDBACK)) {
			statment.setInt(1, element.getUserId());
			statment.setInt(2, element.getHotelId());
			statment.setInt(3, element.getRating());
			statment.setString(4, element.getTitle());
			statment.setString(5, element.getComment());
			statment.setTimestamp(6, element.getDate());
			statment.setInt(7, element.getId());
			int result = statment.executeUpdate();
			if(result > 0) {
	        	LOGGER.info("Feedback updated");
			}
			return result;
		} catch (Exception e) {
        	LOGGER.error("Cannot update feedback", e);
			return -1;
		}
	}

	public int deleteFeedback(int feedBackId) {
		try (PreparedStatement statment = connection.prepareStatement(DELETE_FEEDBACK)) {
			statment.setInt(1, feedBackId);
			int result = statment.executeUpdate();
			if(result > 0) {
	        	LOGGER.info("Feedback removed");
			}
			return result;
		} catch (Exception e) {
        	LOGGER.error("Cannot delete feedback", e);
			return -1;
		}
	}
	
	public List<Feedback> getAllFeedbackByHotel(int id){
		try (PreparedStatement statment = connection.prepareStatement(SELECT_ALL_FEEDBACK_BY_HOTEL)){
			statment.setInt(1, id);
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getCollectionFromRS(rs, Feedback.class);
		} catch(SQLException e){
        	LOGGER.error("Cannot get all feedbacks by hotel", e);
			return new ArrayList<>();
		}
	}

	public Feedback getFeedBackByUserAndHotel(int userId, int hotelId) {
		try (PreparedStatement statment = connection.prepareStatement(SELECT_FEEDBACK_BY_USER_AND_HOTEL)){
			statment.setInt(1, userId);
			statment.setInt(2, hotelId);
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getObjectFromRS(rs, Feedback.class);
		} catch(SQLException e){
        	LOGGER.error("Cannot get feedbacks by user and hotel", e);
			return null;
		}
	}

	public List<Feedback> getAllFeedbacksByUser(int id) {
		try (PreparedStatement statment = connection.prepareStatement(SELECT_ALL_FEEDBACK_BY_USER)){
			statment.setInt(1, id);
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getCollectionFromRS(rs, Feedback.class);
		} catch(SQLException e){
        	LOGGER.error("Cannot get all feedbacks by user", e);
			return new ArrayList<>();
		}
	}

	public Feedback getFeedbackById(int feedbackId) {
		try (PreparedStatement statment = connection.prepareStatement(SELECT_FEEDBACK_BY_ID)){
			statment.setInt(1, feedbackId);
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getObjectFromRS(rs, Feedback.class);
		} catch(SQLException e){
        	LOGGER.error("Cannot get feedback by id", e);
			return null;
		}
	}

	public List<Feedback> getAllFeedbacksByUserAndPage(int userId, int page, String orderBy) {
		String ORDER_BY;
		if("compareByDateAsc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_DATE_ASC;
		} else { //compareByDateDesc = default
			ORDER_BY = ORDER_BY_DATE_DESC;
		}
		
		try (PreparedStatement statment = connection.prepareStatement(SELECT_ALL_FEEDBACK_BY_USER + ORDER_BY + PAGINATION)){
			statment.setInt(1, userId);
			statment.setInt(2, (page-1)*5);
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getCollectionFromRS(rs, Feedback.class);
		} catch(SQLException e){
        	LOGGER.error("Cannot get all feedbacks by user and page", e);
			return new ArrayList<>();
		}
	}
}
