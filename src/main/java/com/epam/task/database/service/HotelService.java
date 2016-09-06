package com.epam.task.database.service;

import java.sql.Timestamp;
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

	public List<Hotel> getAllHotelsByPage(int page, String compareBy) {
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().getAllHotelsByPage(page, compareBy));
	}
	
	public List<Hotel> getAllSuitableHotels(String name, int minStars, int maxStars, int people,	//main search
			boolean typeStandart, boolean typeLux, boolean typeDelux, 								//room type
			boolean foodNone, boolean foodBreakfast, boolean foodTwice, boolean foodFull, 			//food type
			int minPrice, int maxPrice,																//price
			boolean hasWiFi, boolean hasShower, boolean hasParking, boolean hasCondition, 			//additional
			boolean hasPool, boolean hasGym, boolean hasBalcony, boolean noDeposit, 
			Timestamp startDate, Timestamp endDate, int page, String compareBy) {
		
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().getAllSuitableHotels(
				name, minStars, maxStars, people, 
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull, 
				minPrice, maxPrice, 
				hasWiFi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, noDeposit, 
				startDate, endDate, page, compareBy));
	}
	
	public Hotel getHotelById(int id) {
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().getHotelById(id));
	}
	
	public int insertHotel(Hotel hotel) {
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().insertHotel(hotel));
	}
	
	public int removeHotel(Hotel hotel){
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().removeHotel(hotel));
	}
	
	public int updateHotel(Hotel hotel){
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().updateHotel(hotel));
	}

	public int getSuitableHotelsNumber(String name, int minStars, int maxStars, int people, boolean typeStandart,
			boolean typeLux, boolean typeDelux, boolean foodNone, boolean foodBreakfast, boolean foodTwice,
			boolean foodFull, int minPrice, int maxPrice, boolean hasWiFi, boolean hasShower, boolean hasParking,
			boolean hasCondition, boolean hasPool, boolean hasGym, boolean hasBalcony, boolean noDeposit,
			Timestamp startDate, Timestamp endDate) {
		
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().getSuitableHotelsNumber(
				name, minStars, maxStars, people, 
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull, 
				minPrice, maxPrice, 
				hasWiFi, hasShower, hasParking, hasCondition, hasPool, hasGym, hasBalcony, noDeposit, 
				startDate, endDate));
	}

	public List<Hotel> getAllHotelsByManager(int managerId) {
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().getAllHotelsByManager(managerId));
	}

	public List<Hotel> getAllHotelsByManagerAndPage(int managerId, int page, String orderBy) {
		return daoManager.executeAndClose(() -> daoManager.getHotelDao().getAllHotelsByManagerAndPage(managerId, page, orderBy));
	}
}
