package com.epam.task.database.service;

import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.HotelPhoto;

public class HotelPhotoService {
	private DaoManager daoManager;
	
	public HotelPhotoService() {
		super();
		daoManager = new DaoManager();
	}
	
	public List<HotelPhoto> getAllHotelPhotos(){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().getAllHotelPhotos());
	}
	
	public int insertHotelPhoto(HotelPhoto element){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().insertHotelPhoto(element));
	}
	
	public List<HotelPhoto> getHotelPhotosByHotel(int element){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().getHotelPhotosByHotel(element));
	}

	public HotelPhoto getHotelPhotoById(int element){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().getHotelPhotoById(element));
	}
	
	public int deleteHotelPhoto(int element){
		return daoManager.executeAndClose(() -> daoManager.getHotelPhotoDao().deleteHotelPhoto(element));
	}
	
	public static void main(String[] args) {
		HotelPhotoService service = new HotelPhotoService();
		service.testing();
	}
	
	private void testing(){
		HotelPhotoService service = new HotelPhotoService();
		System.out.println("ByHotel");
		List<HotelPhoto> photos = service.getHotelPhotosByHotel(1111);
		for (HotelPhoto photo : photos) {
			System.out.println(photo.getId());
		}
		System.out.println("All");
		photos = service.getAllHotelPhotos();
		for (HotelPhoto photo : photos) {
			System.out.println(photo.getId());
		}

		System.out.println("Insert");
		HotelPhoto newPhoto = new HotelPhoto(100,"1.hjpg","the",1);
		service.insertHotelPhoto(newPhoto);
		System.out.println("All");
		photos = service.getAllHotelPhotos();
		for (HotelPhoto photo : photos) {
			System.out.println(photo.getId());
		}
		
		System.out.println("delete");
		service.deleteHotelPhoto(3);

		System.out.println("All");
		photos = service.getAllHotelPhotos();
		for (HotelPhoto photo : photos) {
			System.out.println(photo.getId());
		}
	}

}
