package com.epam.task.database.service;

import java.sql.Date;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Counter;

public class CounterService {

	private DaoManager daoManager;
	
	public CounterService() {
		super();
		daoManager = new DaoManager();
	}
	
	public int insertCounter(Counter counter){
		return daoManager.executeAndClose(() -> daoManager.getCounterDao().insertCounter(counter));
	}
	
	public int updateCounter(Counter counter){
		return daoManager.executeAndClose(() -> daoManager.getCounterDao().updateCounter(counter));
	}
	
	public Counter getCounterByHotel(int hotelId){
		return daoManager.executeAndClose(() -> daoManager.getCounterDao().getCounterByHotel(hotelId));
	}
	
	public Counter getCounterById(int id){
		return daoManager.executeAndClose(() -> daoManager.getCounterDao().getCounterById(id));
	}
	
	public Counter getCounterByHotelAndDate(int hotelId, Date date){
		return daoManager.executeAndClose(() -> daoManager.getCounterDao().getCounterByHotelAndDate(hotelId, date));
	}
}
