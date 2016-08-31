package com.epam.task.database.dao;

import java.sql.Connection;

public class RoomDao {

	private Connection connection;
	
	public RoomDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}


}
