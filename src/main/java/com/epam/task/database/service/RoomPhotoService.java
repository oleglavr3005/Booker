package com.epam.task.database.service;

import java.util.Collection;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.RoomPhoto;

public class RoomPhotoService {
	private DaoManager daoManager;

	public RoomPhotoService() {
		super();
		daoManager = new DaoManager();
	}

	public Collection<RoomPhoto> getAllRoomPhotos() {
		return daoManager.executeAndClose(() -> daoManager.getRoomPhotoDao().getAllRoomPhotos());
	}

	public int insertRoomPhoto(RoomPhoto element) {
		return daoManager.executeAndClose(() -> daoManager.getRoomPhotoDao().insertRoomPhoto(element));
	}

	public Collection<RoomPhoto> getRoomPhotosByHotel(int element) {
		return daoManager.executeAndClose(() -> daoManager.getRoomPhotoDao().getRoomPhotosByRoom(element));
	}

	public RoomPhoto getRoomPhotoById(int element) {
		return daoManager.executeAndClose(() -> daoManager.getRoomPhotoDao().getRoomPhotoById(element));
	}

	public int deleteHotelPhoto(int element) {
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().deleteHotelPhoto(element));
	}

}
