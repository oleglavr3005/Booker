package com.epam.task.database.service;

import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.—onveniences;

public class —onveniencesService {
	private DaoManager daoManager;

	public —onveniencesService() {
		super();
		daoManager = new DaoManager();
	}
	
	public —onveniences get—onveniencesForHotel(int id) {
		return daoManager.executeAndClose(() -> daoManager.get—onveniencesDao().get—onveniencesForHotel(id));
	}
	public List<—onveniences> get—onveniencesForSomeHotels(int []arrayHotelId) {
		return daoManager.executeAndClose(() -> daoManager.get—onveniencesDao().get—onveniencesForSomeHotels(arrayHotelId));
	}
	public List<—onveniences> get—onveniencesForSomeHotels(List<Hotel> hotelList) {
		return daoManager.executeAndClose(() -> daoManager.get—onveniencesDao().get—onveniencesForSomeHotels(hotelList));
	}
	
}
