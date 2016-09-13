package com.epam.task.database.service;

import java.util.Collection;
import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.RoomPhoto;

public class RoomPhotoService {
	private DaoManager daoManager;

	public RoomPhotoService() {
		super();
		daoManager = new DaoManager();
	}

	public List<RoomPhoto> getAllRoomPhotos() {
		return daoManager.executeAndClose(() -> daoManager.getRoomPhotoDao().getAllRoomPhotos());
	}

	public int insertRoomPhoto(RoomPhoto element) {
		return daoManager.executeAndClose(() -> daoManager.getRoomPhotoDao().insertRoomPhoto(element));
	}

	public List<RoomPhoto> getRoomPhotosByRoom(int element) {
		return daoManager.executeAndClose(() -> daoManager.getRoomPhotoDao().getRoomPhotosByRoom(element));
	}

	public RoomPhoto getRoomPhotoById(int element) {
		return daoManager.executeAndClose(() -> daoManager.getRoomPhotoDao().getRoomPhotoById(element));
	}

	public int deleteRoomPhoto(int element) {
		return daoManager.executeAndClose(() -> daoManager.getRoomPhotoDao().deleteRoomPhoto(element));
	}
	public static void main(String[] args) {
		RoomPhotoService service = new RoomPhotoService();
		service.testing();
	}
	
	private void testing(){
		RoomPhotoService service = new RoomPhotoService();
		System.out.println("ByRoom");
		List<RoomPhoto> photos = service.getRoomPhotosByRoom(1);
		for (RoomPhoto photo : photos) {
			System.out.println(photo.getId());
		}
		System.out.println("All");
		photos = service.getAllRoomPhotos();
		for (RoomPhoto photo : photos) {
			System.out.println(photo.getId());
		}

		System.out.println("Insert");
		RoomPhoto newPhoto = new RoomPhoto(22,"1.hjpg","the",1,true);
		service.insertRoomPhoto(newPhoto);
		System.out.println("All");
		photos = service.getAllRoomPhotos();
		for (RoomPhoto photo : photos) {
			System.out.println(photo.getId());
		}
		
		System.out.println("delete");
		service.deleteRoomPhoto(3);

		System.out.println("All");
		photos = service.getAllRoomPhotos();
		for (RoomPhoto photo : photos) {
			System.out.println(photo.getId());
		}
	}
}
