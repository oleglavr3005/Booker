package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.User;
import com.epam.task.database.transformers.UniversalTransformer;

public class UserDao {

	private Connection connection;
	
	private final String SELECT_ALL = "SELECT * FROM `user`";
	private final String SELECT_BY_ID = SELECT_ALL + " WHERE user_id = ?";
	//private final String SQL_DELETE_USER = "DELETE FROM user " + "WHERE id = ?;";
	
	private final String INSERT = "INSERT INTO `user` (first_name, last_name, e_mail, password, type, is_banned, confirm_code, status, phone_number, img, social_network, social_network_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE `user` SET first_name = ?, last_name = ?, e_mail = ?, password = ?, type = ?, is_banned = ?, confirm_code = ?, status = ?, phone_number = ?, img = ?, social_network = ?, social_network_id = ? WHERE user_id = ?";

	public UserDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<User> getAllUsers() {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
					ResultSet result = statement.executeQuery()) {
			return UniversalTransformer.getCollectionFromRS(result, User.class);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public User getUserById(int id) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
			statement.setInt(1, id);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, User.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int insertUser(User user) {
		try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
			int i = 1;
			statement.setString(i++, user.getFirstName());
			statement.setString(i++, user.getLastName());
			statement.setString(i++, user.getEmail());
			statement.setString(i++, user.getPassword());
			statement.setString(i++, user.getType().toString());
			statement.setBoolean(i++, user.isBanned());
			statement.setString(i++, user.getConfirmCode());
			statement.setString(i++, user.getStatus().toString());
			statement.setString(i++, user.getPhoneNumber());
			statement.setString(i++, user.getImage());
			statement.setString(i++, user.getSocialNetwork().toString());
			statement.setString(i, user.getSocialNetworkId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int updateUser(User user) {
		try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
			int i = 1;
			statement.setString(i++, user.getFirstName());
			statement.setString(i++, user.getLastName());
			statement.setString(i++, user.getEmail());
			statement.setString(i++, user.getPassword());
			statement.setString(i++, user.getType().toString());
			statement.setBoolean(i++, user.isBanned());
			statement.setString(i++, user.getConfirmCode());
			statement.setString(i++, user.getStatus().toString());
			statement.setString(i++, user.getPhoneNumber());
			statement.setString(i++, user.getImage());
			statement.setString(i++, user.getSocialNetwork().toString());
			statement.setString(i++, user.getSocialNetworkId());

			statement.setInt(i, user.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}