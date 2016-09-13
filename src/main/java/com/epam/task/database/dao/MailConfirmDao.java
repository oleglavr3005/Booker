package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.task.database.model.MailConfirm;
import com.epam.task.database.transformers.UniversalTransformer;

public class MailConfirmDao {

	private Connection connection;
	
	private final String SELECT_BY_ID = "SELECT * FROM `mail_confirm` WHERE id = ?";
	private final String SELECT_BY_USER = "SELECT * FROM `mail_confirm` WHERE user_id = ?";
	
	public MailConfirmDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public MailConfirm getMailConfirmById(int id) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
			statement.setInt(1, id);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, MailConfirm.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public MailConfirm getMailConfirmByUser(int userId) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_USER)) {
			statement.setInt(1, userId);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, MailConfirm.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
