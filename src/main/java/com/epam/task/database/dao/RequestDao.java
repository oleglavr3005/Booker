package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Request;
import com.epam.task.database.model.enums.RequestStatus;
import com.epam.task.database.transformers.UniversalTransformer;

public class RequestDao {

	private Connection connection;
	
	private final String SELECT_ALL = "SELECT * FROM `request`";
	private final String SELECT_ALL_BY_STATUS = "SELECT * FROM `request` WHERE status LIKE ?";
	private final String SELECT_BY_ID = "SELECT * FROM `request` WHERE request_id = ?";
	private final String SELECT_BY_USER = "SELECT * FROM `request` WHERE user_id = ?";
	
	private final String INSERT_REQUEST = "INSERT INTO `request` (user_id, message, request_date, status) VALUES (?, ?, ?, ?)";
	private final String UPDATE_REQUEST = "UPDATE `request` SET user_id = ?, message = ?, request_date = ?, status = ? WHERE request_id = ?";
	private final String CHANGE_REQUEST_STATUS = "UPDATE `request` SET status = ? WHERE request_id = ?";
	
	public RequestDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<Request> getAllRequests() {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
					ResultSet result = statement.executeQuery()) {
			return UniversalTransformer.getCollectionFromRS(result, Request.class);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public List<Request> getAllRequestsByStatus(RequestStatus status) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BY_STATUS)) {
			statement.setString(1, status.toString());
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, Request.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public Request getRequestById(int id) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
			statement.setInt(1, id);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, Request.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Request getRequestByUserId(int userId) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_USER)) {
			statement.setInt(1, userId);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, Request.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int insertRequest(Request request) {
		try (PreparedStatement statement = connection.prepareStatement(INSERT_REQUEST)) {
			int i = 1;
			statement.setInt(i++, request.getUserId());
			statement.setString(i++, request.getMessage());
			statement.setTimestamp(i++, request.getRequestDate());
			statement.setString(i++, request.getStatus().toString());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int updateRequest(Request request) {
		try (PreparedStatement statement = connection.prepareStatement(UPDATE_REQUEST)) {
			int i = 1;
			statement.setInt(i++, request.getUserId());
			statement.setString(i++, request.getMessage());
			statement.setTimestamp(i++, request.getRequestDate());
			statement.setString(i++, request.getStatus().toString());
			
			statement.setInt(i++, request.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int updateRequestStatus(int requestId, RequestStatus status) {
		try (PreparedStatement statement = connection.prepareStatement(CHANGE_REQUEST_STATUS)) {
			int i = 1;
			statement.setString(i++, status.toString());
			statement.setInt(i++, requestId);
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
