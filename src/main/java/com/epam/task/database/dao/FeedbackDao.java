package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.task.database.model.Feedback;
import com.epam.task.database.transformers.UniversalTransformer;

public class FeedbackDao {
	private Connection connection;
	private final String SELECT_ALL_FEEDBACK = "SELECT * FROM feedback";
	private final String INSERT_FEEDBACK = "INSERT INTO feedback (user_id, hotel_id, rating, title, comment, date) VALUES (?, ?, ?, ?, ?, ?)";
	private final String UPDATE_FEEDBACK = "UPDATE feedback SET user_id = ?, hotel_id = ?, rating = ?, comment = ?, title = ?, date = ? WHERE feedback_id = ?";
	private final String DELETE_FEEDBACK = "DELETE FROM feedback WHERE feedback_id = ?";
	private final String SELECT_ALL_FEEDBACK_BY_HOTEL = "SELECT * FROM feedback WHERE hotel_id = ?;";
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
			e.printStackTrace();
			return null;
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
			return statment.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
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
			return statment.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int deleteFeedback(Feedback element) {
		try (PreparedStatement statment = connection.prepareStatement(DELETE_FEEDBACK)) {
			statment.setInt(1, element.getId());
			return statment.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<Feedback> getAllFeedbackByHotel(int id){
		try (PreparedStatement statment = connection.prepareStatement(SELECT_ALL_FEEDBACK_BY_HOTEL)){
			statment.setInt(1, id);
			ResultSet rs = statment.executeQuery();
			return UniversalTransformer.getCollectionFromRS(rs, Feedback.class);
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
