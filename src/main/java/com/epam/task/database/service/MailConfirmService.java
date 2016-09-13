package com.epam.task.database.service;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.MailConfirm;

public class MailConfirmService {

	private DaoManager daoManager;
	
	public MailConfirmService() {
		super();
		daoManager = new DaoManager();
	}
	
	public MailConfirm getMailConfirmById(int id) {
		return daoManager.executeAndClose(() -> daoManager.getMailConfirmDao().getMailConfirmById(id));
	}
	
	public MailConfirm getMailConfirmByUser(int userId) {
		return daoManager.executeAndClose(() -> daoManager.getMailConfirmDao().getMailConfirmByUser(userId));
	}
}
