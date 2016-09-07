package com.epam.task.database.service;

import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.util.MailSender;



public class UserService {
	private DaoManager daoManager;
	
	public UserService() {
		super();
		daoManager = new DaoManager();
	}

	public List<User> getAllUsers() {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getAllUsers());
	}

	public List<User> getAllUsersWithEmailNotification() {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getAllUsersWithEmailNotification());
	}

	public List<User> getAllUsersWithEmailNotificationInHotel(int hotelId) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getAllUsersWithEmailNotificationInHotel(hotelId));
	}

	public List<User> getAllUsersWithPhoneNotification() {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getAllUsersWithPhoneNotification());
	}

	public List<User> getAllUsersWithPhoneNotificationInHotel(int hotelId) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getAllUsersWithPhoneNotificationInHotel(hotelId));
	}
	
	public User getUserById(int id) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getUserById(id));
	}
	
	public int insertUser(User user) {
	//	if (UserValidator.validate(user)) {
			int value = daoManager.executeAndClose(() -> daoManager.getUserDao().insertUser(user));
			if (user.getSocialNetworkId() == null) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						sendConfirmation(user);
					}
				}).start();
			}
			return value;
	//	}

	}

	private void sendConfirmation(User user) {
		String subject = "Mail Confirmation";
		String link = "http://localhost:8080/booker/signup_confirmation?token=" + user.getConfirmCode();
		String text = "<body style='background-color: #fff'>" +

				"<div style='width: 100%; height:20px; background-color: #00000 position: relative color:white;'>Mail Confirmation"
				+ "<div style='top: 10px; background-color: white; padding:20px'>"
				+ "<div><h1 style='color: #00264d;'> Hello, " + user.getFirstName() + "</h1>"
				+ "<p>In order to confirm registration pls click here: </p>" + "</div><div id='one'><p>"
				+ link + "<p></div></div></div></body>";

		MailSender.send(subject, text, user.getEmail());
	}

	public void sendPass(User user, String pass) {
		String subject = "Password Restore";
		String text = "<body style='background-color: #fff'>" +
		
				"<div style='width: 100%; height:20px; background-color: #00000 position: relative color:white;'>Mail Confirmation"
				+ "<div style='top: 10px; background-color: white; padding:20px'>"
				+ "<div><h1 style='color: #00264d;'> Hello, " + user.getFirstName() + "</h1>"
				+ "<p>new pass: </p>"
				+ "</div><div id='one'><p>" + pass + "<p></div></div></div></body>";

		MailSender.send(subject, text, user.getEmail());
	}
	
	public int updateUser(User user) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().updateUser(user));
	}
	
	public User getUserByEmail(String email) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getUserByEmail(email));
	}

	public User getUserByConfirmCode(String code) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getUserByConfirmCode(code));
	}
	
	public List<User> getUsersByStatus(UserStatus status) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getUsersByStatus(status));
	}
	
	public List<User> getUsersByType(UserType type) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getUsersByType(type));
	}
	
	public static void main(String[] args) {
		UserService s = new UserService();
		for(int i = 0; i < 10; i++){
		System.out.println(i + " " + s.getUserById(1));
		}
	}

	public int updateUserStatus(int userId, UserStatus status) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().updateUserStatus(userId, status));
	}

	public int updateUserType(int userId, UserType type) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().updateUserType(userId, type));
	}
}
