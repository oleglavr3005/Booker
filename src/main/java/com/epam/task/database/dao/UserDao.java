package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public List<User> getAllUsers() throws SQLException{
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
					ResultSet result = statement.executeQuery()) {
			return UniversalTransformer.getCollectionFromRS(result, User.class);
		}
	}
	
	public User getUserById() throws SQLException {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
				ResultSet result = statement.executeQuery()) {
			return UniversalTransformer.getObjectFromRS(result, User.class);
		}
	}
	
	public int insertUser(User user) throws SQLException {
		try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getType().toString());
			statement.setBoolean(6, user.isBanned());
			statement.setString(7, user.getConfirmCode());
			statement.setString(8, user.getStatus().toString());
			statement.setString(9, user.getPhoneNumber());
			statement.setString(10, user.getImage());
			statement.setString(11, user.getSocialNetwork().toString());
			statement.setString(12, user.getSocialNetworkId());
			return statement.executeUpdate();
		}
	}
	
	public int updateUser(User user) throws SQLException {
		try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getType().toString());
			statement.setBoolean(6, user.isBanned());
			statement.setString(7, user.getConfirmCode());
			statement.setString(8, user.getStatus().toString());
			statement.setString(9, user.getPhoneNumber());
			statement.setString(10, user.getImage());
			statement.setString(11, user.getSocialNetwork().toString());
			statement.setString(12, user.getSocialNetworkId());

			statement.setInt(13, user.getId());
			return statement.executeUpdate();
		}
	}
}