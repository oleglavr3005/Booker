package com.epam.task.database.service;

import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Hotel;

public class HotelService {
private DaoManager daoManager;
	
	public HotelService(){
		super();
		daoManager = new DaoManager();
	}
	
	public List<Hotel> getAllHotels() {
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().getAllHotels());
	}
	
	public Hotel getHotelById(int id) {
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().getHotelById(id));
	}
	
	public int insertHotel(Hotel hotel) {
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().insertHotel(hotel));
	}
	
	public int deleteHotel(Hotel hotel){
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().deleteHotel(hotel));
	}
	
	public int updateHotel(Hotel hotel){
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().updateHotel(hotel));
	}
}
