package com.epam.task.database.service;

import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.User;



public class UserService {
	private DaoManager daoManager;
	
	public UserService() {
		super();
		daoManager = new DaoManager();
	}

	public List<User> getAllUsers() {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getAllUsers());
	}
	
	public User getUserById(int id) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getUserById(id));
	}
	
	public int insertUser(User user) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().insertUser(user));
	}
	
	public int updateUser(User user) {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().updateUser(user));
	}
	
	public static void main(String[] args) {
		UserService s = new UserService();
		for(int i = 0; i < 10000; i++){
		System.out.println(i + " " + s.getUserById(1));
		}
	}
}
