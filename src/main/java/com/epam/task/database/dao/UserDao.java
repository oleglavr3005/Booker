package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.database.transformers.UniversalTransformer;

public class UserDao {

	private Connection connection;
	
	private final String SELECT_ALL = "SELECT * FROM `user`";
	private final String SELECT_BY_ID = SELECT_ALL + " WHERE user_id = ?";
	private final String SELECT_BY_EMAIL = SELECT_ALL + " WHERE e_mail LIKE ?";
	private final String SELECT_BY_STATUS = SELECT_ALL + " WHERE status LIKE ?";
	private final String SELECT_BY_TYPE	 = SELECT_ALL + " WHERE type LIKE ?";
	private final String SELECT_BY_CODE = "SELECT * FROM user u WHERE u.confirm_code LIKE ?;";
	
	private final String INSERT = "INSERT INTO `user` (first_name, last_name, e_mail, password, type, is_banned, confirm_code, status, phone_number, img, social_network, social_network_id, email_notif, phone_notif, language) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE `user` SET first_name = ?, last_name = ?, e_mail = ?, password = ?, type = ?, is_banned = ?, confirm_code = ?, status = ?, phone_number = ?, img = ?, social_network = ?, social_network_id = ?, email_notif = ?, phone_notif = ?, language = ? WHERE user_id = ?";

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
	
	public User getUserByEmail(String email) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMAIL)) {
			statement.setString(1, email);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, User.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User getUserByConfirmCode(String code) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_CODE)) {
			statement.setString(1, code);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, User.class);
			}
		} catch (Exception e) {
			return null;
		}
	}

	public User getUserByStatus(UserStatus status) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_STATUS)) {
			statement.setString(1, status.toString());
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getObjectFromRS(result, User.class);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getUserByType(UserType type) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_TYPE)) {
			statement.setString(1, type.toString());
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
			statement.setString(i++, user.getSocialNetworkId());
			statement.setBoolean(i++, user.hasEmailNotif());
			statement.setBoolean(i++, user.hasPhoneNotif());
			statement.setString(i++, user.getLanguage());
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
			statement.setBoolean(i++, user.hasEmailNotif());
			statement.setBoolean(i++, user.hasPhoneNotif());
			statement.setString(i++, user.getLanguage());

			statement.setInt(i, user.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}