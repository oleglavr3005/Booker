package com.epam.task.database.service;

import java.util.Collection;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Feedback;

public class FeedbackService {
	private DaoManager daoManager;
	
	public FeedbackService() {
		super();
		daoManager = new DaoManager();
	}
	
	public Collection<Feedback> getAllFeedbacks(){
		return daoManager.executeAndClose(() -> daoManager.getFeedbackDao().getAllFeedbacks());
	}
	
	public int insertFeedback(Feedback element){
		return daoManager.executeAndClose(() -> daoManager.getFeedbackDao().insertFeedback(element));
	}
	
	public int updateFeedback(Feedback element){
		return daoManager.executeAndClose(() -> daoManager.getFeedbackDao().updateFeedback(element));
	}
	
	public int deleteFeedback(Feedback element){
		return daoManager.executeAndClose(() -> daoManager.getFeedbackDao().deleteFeedback(element));
	}
}
