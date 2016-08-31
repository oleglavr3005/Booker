package com.epam.task.database.service;

import java.util.Collection;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.HotelPhoto;

public class HotelPhotoService {
	private DaoManager daoManager;
	
	public HotelPhotoService() {
		super();
		daoManager = new DaoManager();
	}
	
	public Collection<HotelPhoto> getAllHotelPhotos(){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().getAll());
	}
	
	public int insertHotelPhoto(HotelPhoto element){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().insertHotelPhoto(element));
	}
	
	public Collection<HotelPhoto> getHotelPhotosByHotel(int element){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().getHotelPhotosByHotel(element));
	}

	public HotelPhoto getHotelPhotoById(int element){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().getHotelPhotoById(element));
	}
	
	public int deleteHotelPhoto(int element){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().deleteHotelPhoto(element));
	}
}
