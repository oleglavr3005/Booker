package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.task.database.model.MailConfirm;
import com.epam.task.database.transformers.UniversalTransformer;

public class MailConfirmDao {

	private Connection connection;
	private static final Logger LOGGER = Logger.getLogger(MailConfirmDao.class);
	
	private final String SELECT_BY_ID = "SELECT * FROM `mail_confirm` WHERE confirm_id = ?";
	private final String SELECT_BY_USER = "SELECT * FROM `mail_confirm` WHERE user_id = ?";
	private final String SELECT_BY_CODE = "SELECT * FROM `mail_confirm` WHERE confirm_code LIKE ?";
	
	private final String INSERT = "INSERT INTO `mail_confirm` (user_id, e_mail, confirm_code) VALUES (?, ?, ?)";
	private final String REMOVE = "DELETE FROM `mail_confirm` WHERE confirm_id = ?";
	private final String UPDATE = "UPDATE `mail_confirm` SET user_id = ?, e_mail = ?, confirm_code = ? WHERE confirm_id = ?";
	
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
        	LOGGER.error("Cannot get mail confirm by id", e);
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
        	LOGGER.error("Cannot get mail confirm by user", e);
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
        	LOGGER.error("Cannot get mail confirm by code", e);
			return null;
		}
	}

	public int insertMailConfirm(MailConfirm mailConfirm) {
		try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
			int i = 1;
			statement.setInt(i++, mailConfirm.getUserId());
			statement.setString(i++, mailConfirm.getEmail());
			statement.setString(i++, mailConfirm.getConfirmCode());
			int result = statement.executeUpdate();
			if(result > 0) {
	        	LOGGER.info("Mail confirm inserted");
			}
			return result;
		} catch (SQLException e) {
        	LOGGER.error("Cannot insert mail confirm", e);
			return -1;
		}
	}

	public int removeMailConfirm(int id) {
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(REMOVE)) {
			st.setInt(1, id);
			result = st.executeUpdate();
			if(result > 0) {
	        	LOGGER.info("Mail confirm removed");
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot remove mail confirm", e);
		}
		return result;
	}

	public int updateMailConfirm(MailConfirm mailConfirm) {
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(UPDATE)) {
			st.setInt(1, mailConfirm.getUserId());
			st.setString(2, mailConfirm.getEmail());
			st.setString(3, mailConfirm.getConfirmCode());
			
			st.setInt(4, mailConfirm.getId());
			result = st.executeUpdate();
			if(result > 0) {
	        	LOGGER.info("Mail confirm updated");
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot update mail confirm", e);
		}
		return result;
	}
}
