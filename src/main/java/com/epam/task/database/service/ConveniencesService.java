package com.epam.task.database.service;

import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Conveniences;

public class ConveniencesService {
	private DaoManager daoManager;

	public ConveniencesService() {
		super();
		daoManager = new DaoManager();
	}
	
	public Conveniences getConveniencesForHotel(int id) {
		return daoManager.executeAndClose(() -> daoManager.getConveniencesDao().getConveniencesForHotel(id));
	}
	public List<Conveniences> getConveniencesForSomeHotels(int []arrayHotelId) {
		return daoManager.executeAndClose(() -> daoManager.getConveniencesDao().getConveniencesForSomeHotels(arrayHotelId));
	}
	public List<Conveniences> getConveniencesForSomeHotels(List<Hotel> hotelList) {
		return daoManager.executeAndClose(() -> daoManager.getConveniencesDao().getConveniencesForSomeHotels(hotelList));
	}
	
}
