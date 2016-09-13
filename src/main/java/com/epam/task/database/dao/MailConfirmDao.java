package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.task.database.model.MailConfirm;
import com.epam.task.database.transformers.UniversalTransformer;

public class MailConfirmDao {

	private Connection connection;
	
	private final String SELECT_BY_ID = "SELECT * FROM `mail_confirm` WHERE confirm_id = ?";
	private final String SELECT_BY_USER = "SELECT * FROM `mail_confirm` WHERE user_id = ?";
	private final String SELECT_BY_CODE = "SELECT * FROM `mail_confirm` WHERE confirm_code LIKE ?";
	
	private final String INSERT = "INSERT INTO `mail_confirm` (user_id, e_mail, confirm_code) VALUES (?, ?, ?)";
	private final String REMOVE = "DELETE FROM `mail_confirm` WHERE confirm_id = ?";
	
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
	
	public MailConfirm getMailConfirmByCode(String code) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_CODE)) {
			statement.setString(1, code);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, MailConfirm.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int insertMailConfirm(MailConfirm mailConfirm) {
		try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
			int i = 1;
			statement.setInt(i++, mailConfirm.getUserId());
			statement.setString(i++, mailConfirm.getEmail());
			statement.setString(i++, mailConfirm.getConfirmCode());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int removeMailConfirm(int id) {
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(REMOVE)) {
			st.setInt(1, id);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
