package com.epam.task.database.dto;

import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Room;
import com.epam.task.database.model.RoomPhoto;
import com.epam.task.database.service.RoomService;

public class RoomDto extends Room{

	private List<Integer> roomIds = new ArrayList<>();
	private List<RoomPhoto> allPhotos = new ArrayList<>();
	private String allRoomIds = "";
	private int amount = 0;
	private static int staticId = 1;
	
	public RoomDto(int hotelId, String type, int bedsCount, int doubleBedsCount,
			int price, boolean wifi, boolean shower, boolean condition,
			boolean balcony, boolean tv, String food, int daysCount, int percentage) {
		
		super(staticId++, hotelId, "0", type, bedsCount, doubleBedsCount, price, wifi, shower, condition,
				balcony, tv, food, daysCount, percentage, false);
	}
	
	public boolean addRoom(int roomId) {
		Room room = new RoomService().getRoomById(roomId);
		if(room == null) {
			return false;
		}
		List<RoomPhoto> roomPhotos = room.getPhotos();
		for(RoomPhoto roomPhoto : roomPhotos) {
			boolean contains = false;
			for(RoomPhoto photo : allPhotos) {
				if(photo.getImg().equals(roomPhoto.getImg())) {
					contains = true;
					break;
				}
			}
			if(!contains) {
				allPhotos.add(roomPhoto);
			}
		}
		if(allPhotos.isEmpty()) {
			allPhotos.add(new RoomPhoto(0, "no-image.png", "", 0, true));
		}
		boolean added = roomIds.add(roomId);
		if(added) {
			amount++;
			allRoomIds = createRoomIdsString(":");
			return true;
		}
		return false;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getAllRoomIds() {
		return allRoomIds;
	}
	
	public List<Integer> getRoomIds() {
		return roomIds;
	}
	
	private String createRoomIdsString(String spliterator) {
		StringBuilder resultString = new StringBuilder();
		for(Integer roomId : roomIds) {
			if(resultString.length() > 0) {
				resultString.append(spliterator);
			}
			resultString.append(roomId);
		}
		
		return resultString.toString();
	}
	
	public List<RoomPhoto> getAllPhotos() {
		return allPhotos;
	}
	
}
