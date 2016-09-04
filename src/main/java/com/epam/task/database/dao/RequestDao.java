package com.epam.task.database.dao;

import java.sql.Connection;

public class RequestDao {

	private Connection connection;
	
	private final String SELECT_ALL = "SELECT * FROM `request`";
	private final String SELECT_BY_ID = "SELECT * FROM `request` WHERE request_id = ?";
	private final String SELECT_BY_USER = "SELECT * FROM `request` WHERE user_id = ?";
	private final String SELECT_BY_STATUS = "SELECT * FROM `request` WHERE status LIKE ?";
	
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

}
