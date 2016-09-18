package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.database.transformers.UniversalTransformer;

public class UserDao {

	private Connection connection;
	private static final Logger LOGGER = Logger.getLogger(UserDao.class);
	
	private final String SELECT_ALL = "SELECT * FROM `user`";
	private final String SELECT_ALL_NOT_ADMINS = SELECT_ALL + " WHERE type NOT LIKE 'ADMIN'";
	private final String SELECT_ALL_WITH_EMAIL_NOTIF = SELECT_ALL + " WHERE email_notif = true";
	private final String SELECT_ALL_WITH_EMAIL_NOTIF_IN_HOTEL = "SELECT DISTINCT u.* FROM `user` u INNER JOIN `order` o ON u.user_id = o.user_id INNER JOIN `room` r ON r.room_id = o.room_id WHERE r.id_hotel = ? AND u.email_notif = true";
	private final String SELECT_ALL_WITH_PHONE_NOTIF = SELECT_ALL + " WHERE phone_notif = true";
	private final String SELECT_ALL_WITH_PHONE_NOTIF_IN_HOTEL = "SELECT DISTINCT u.* FROM `user` u INNER JOIN `order` o ON u.user_id = o.user_id INNER JOIN `room` r ON r.room_id = o.room_id WHERE r.id_hotel = ? AND u.phone_notif = true";
	private final String SELECT_BY_ID = SELECT_ALL + " WHERE user_id = ?";
	private final String SELECT_BY_EMAIL = SELECT_ALL + " WHERE e_mail LIKE ?";
	private final String SELECT_BY_STATUS = SELECT_ALL + " WHERE status LIKE ?";
	private final String SELECT_BY_TYPE	 = SELECT_ALL + " WHERE type LIKE ?";
	private final String SELECT_BY_CODE = "SELECT * FROM user u WHERE u.confirm_code LIKE ?;";
	
	private final String INSERT = "INSERT INTO `user` (first_name, last_name, e_mail, password, type, confirm_code, status, phone_number, img, social_network, social_network_id, email_notif, phone_notif, language) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE `user` SET first_name = ?, last_name = ?, e_mail = ?, password = ?, type = ?, confirm_code = ?, status = ?, phone_number = ?, img = ?, social_network = ?, social_network_id = ?, email_notif = ?, phone_notif = ?, language = ? WHERE user_id = ?";
	private final String UPDATE_STATUS = "UPDATE `user` SET status = ? WHERE user_id = ?";
	private final String UPDATE_TYPE = "UPDATE `user` SET type = ? WHERE user_id = ?";

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
        	LOGGER.error("Cannot get all users", e);
			return new ArrayList<>();
		}
	}

	public List<User> getAllUsersWithEmailNotification() {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_WITH_EMAIL_NOTIF);
					ResultSet result = statement.executeQuery()) {
			return UniversalTransformer.getCollectionFromRS(result, User.class);
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all users with email notif", e);
			return new ArrayList<>();
		}
	}

	public List<User> getAllUsersWithEmailNotificationInHotel(int hotelId) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_WITH_EMAIL_NOTIF_IN_HOTEL)) {
			statement.setInt(1, hotelId);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, User.class);
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all users with email notif in hotel", e);
			return new ArrayList<>();
		}
	}

	public List<User> getAllUsersWithPhoneNotification() {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_WITH_PHONE_NOTIF);
					ResultSet result = statement.executeQuery()) {
			return UniversalTransformer.getCollectionFromRS(result, User.class);
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all users with phone notif", e);
			return new ArrayList<>();
		}
	}

	public List<User> getAllUsersWithPhoneNotificationInHotel(int hotelId) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_WITH_PHONE_NOTIF_IN_HOTEL)) {
			statement.setInt(1, hotelId);
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, User.class);
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all users with phone notif in hotel", e);
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
        	LOGGER.error("Cannot get user by id", e);
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
        	LOGGER.error("Cannot get user by email", e);
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
        	LOGGER.error("Cannot get user by confirm code", e);
			return null;
		}
	}

	public List<User> getUsersByStatus(UserStatus status) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_STATUS)) {
			statement.setString(1, status.toString());
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, User.class);
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all users by status", e);
			return new ArrayList<>();
		}
	}

	public List<User> getUsersByType(UserType type) {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_TYPE)) {
			statement.setString(1, type.toString());
			try (ResultSet result = statement.executeQuery()) {
				return UniversalTransformer.getCollectionFromRS(result, User.class);
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all users by type", e);
			return new ArrayList<>();
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
			statement.setString(i++, user.getConfirmCode());
			statement.setString(i++, user.getStatus().toString());
			statement.setString(i++, user.getPhoneNumber());
			statement.setString(i++, user.getImage());
			statement.setString(i++, user.getSocialNetwork().toString());			
			statement.setString(i++, user.getSocialNetworkId());
			statement.setBoolean(i++, user.getEmailNotif());
			statement.setBoolean(i++, user.getPhoneNotif());
			statement.setString(i++, user.getLanguage());
			int result = statement.executeUpdate();
			if(result > 0) {
				LOGGER.info("User inserted");
			}
			return result;
		} catch (SQLException e) {
        	LOGGER.error("Cannot insert user", e);
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
			statement.setString(i++, user.getConfirmCode());
			statement.setString(i++, user.getStatus().toString());
			statement.setString(i++, user.getPhoneNumber());
			statement.setString(i++, user.getImage());
			statement.setString(i++, user.getSocialNetwork().toString());
			statement.setString(i++, user.getSocialNetworkId());
			statement.setBoolean(i++, user.getEmailNotif());
			statement.setBoolean(i++, user.getPhoneNotif());
			statement.setString(i++, user.getLanguage());

			statement.setInt(i, user.getId());
			int result = statement.executeUpdate();
			if(result > 0) {
				LOGGER.info("User updated");
			}
			return result;
		} catch (SQLException e) {
        	LOGGER.error("Cannot update user", e);
			return -1;
		}
	}

	public int updateUserStatus(int userId, UserStatus status) {
		try (PreparedStatement statement = connection.prepareStatement(UPDATE_STATUS)) {
			statement.setString(1, status.toString());
			statement.setInt(2, userId);
			int result = statement.executeUpdate();
			if(result > 0) {
				LOGGER.info("User status updated");
			}
			return result;
		} catch (SQLException e) {
        	LOGGER.error("Cannot update user status", e);
			return -1;
		}
	}

	public int updateUserType(int userId, UserType type) {
		try (PreparedStatement statement = connection.prepareStatement(UPDATE_TYPE)) {
			statement.setString(1, type.toString());
			statement.setInt(2, userId);
			int result = statement.executeUpdate();
			if(result > 0) {
				LOGGER.info("User type updated");
			}
			return result;
		} catch (SQLException e) {
        	LOGGER.error("Cannot update type", e);
			return -1;
		}
	}

	public List<User> getAllNotAdmins() {
		try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_NOT_ADMINS);
				ResultSet result = statement.executeQuery()) {
		return UniversalTransformer.getCollectionFromRS(result, User.class);
	} catch (SQLException e) {
    	LOGGER.error("Cannot get all not-admin users", e);
		return new ArrayList<>();
	}
	}
}