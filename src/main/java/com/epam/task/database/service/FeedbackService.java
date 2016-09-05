package com.epam.task.database.service;

import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Feedback;

public class FeedbackService {
	private DaoManager daoManager;
	
	public FeedbackService() {
		super();
		daoManager = new DaoManager();
	}
	
	public List<Feedback> getAllFeedbacks(){
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
	
	public List<Feedback> getAllFeedbacksByHotel(int id){
		return daoManager.executeAndClose(() -> daoManager.getFeedbackDao().getAllFeedbackByHotel(id));
	}

	public Feedback getFeedBackByUserAndHotel(int userId, int hotelId) {
		return daoManager.executeAndClose(() -> daoManager.getFeedbackDao().getFeedBackByUserAndHotel(userId, hotelId));
	}
}
