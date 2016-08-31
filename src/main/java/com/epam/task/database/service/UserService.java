package com.epam.task.database.service;

import java.util.Collection;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.User;

public class UserService {
	private DaoManager daoManager;

	public UserService() {
		super();
		daoManager = new DaoManager();
	}

	public Collection<User> getAllUsers() {
		return daoManager.executeAndClose(() -> daoManager.getUserDao().getAllUsers());
	}
	
	public void delete(User u) {
		daoManager.executeVoidAndClose(() -> daoManager.getUserDao().delete(u));
	}
}
