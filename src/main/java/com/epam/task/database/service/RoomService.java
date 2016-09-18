package com.epam.task.database.service;

import java.sql.Timestamp;
import java.util.List;
import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Room;

public class RoomService {

	private DaoManager daoManager;

	public RoomService() {
		super();
		daoManager = new DaoManager();
	}

	public List<Room> getAllActiveRoomsForHotelByPage(int id, int page) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getAllActiveRoomsForHotelByPage(id, page));
	}

	public List<Room> getAllRoomsForHotel(int hotelId) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getAllRoomsForHotel(hotelId));
	}
	
	public Room getRoomById(int id) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getRoomById(id));
	}

	public List<Room> getAllSuitableRoomsForHotelByPage(int id, int page, 
			boolean typeStandart, boolean typeLux, boolean typeDelux, 
			boolean foodNone, boolean foodBreakfast, boolean foodTwice, boolean foodFull,
			int minPrice, int maxPrice, int people,
			boolean hasWiFi, boolean hasShower, boolean hasParking, boolean hasCondition, 
			boolean hasPool, boolean hasGym, boolean hasBalcony, boolean hasSpa, 
			boolean hasService, boolean hasCleaner, boolean hasTv, boolean noDeposit,
			Timestamp startDate, Timestamp endDate, String compareBy) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getAllSuitableRoomsForHotelByPage(id, page, 
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull,
				minPrice, maxPrice, people,
				hasWiFi, hasShower, hasParking, hasCondition, 
				hasPool, hasGym, hasBalcony, hasSpa, 
				hasService, hasCleaner, hasTv, noDeposit,
				startDate, endDate, compareBy));
	}

	public List<Room> getAllRoomsForHotelByPage(int id, int page) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getAllRoomsForHotelByPage(id, page));
	}

	public Integer insertRoom(Room room) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().insertRoom(room));
	}

	public Integer updateRoom(Room room) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().updateRoom(room));
	}

	public Integer removeRoom(int id) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().removeRoom(id));
	}

	public Integer restoreRoom(int id) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().restoreRoom(id));
	}

	public int getMinPrice() {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getMinPrice());
	}

	public int getMaxPrice() {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getMaxPrice());
	}

	public static void main(String[] args) {
		RoomService service = new RoomService();
		service.testing();
	}
	
	private void testing(){
		RoomService service = new RoomService();
		System.out.println("Active");
		List<Room> rooms = service.getAllActiveRoomsForHotelByPage(1, 1);
		for (Room room : rooms) {
			System.out.println(room);
		}
		System.out.println("All");
		rooms = service.getAllRoomsForHotelByPage(1, 1);
		for (Room room : rooms) {
			System.out.println(room);
		}

//		System.out.println("remove");
//		service.removeRoom(1);
//
//		System.out.println("Active");
//		rooms = service.getAllActiveRoomsForHotel(1);
//		for (Room room : rooms) {
//			System.out.println(room);
//		}
//		System.out.println("All");
//		rooms = service.getAllRoomsForHotel(1);
//		for (Room room : rooms) {
//			System.out.println(room);
//		}
//
//		System.out.println("restore");
//		service.restoreRoom(1);
//
//		System.out.println("Active");
//		rooms = service.getAllActiveRoomsForHotel(1);
//		for (Room room : rooms) {
//			System.out.println(room);
//		}
//		System.out.println("All");
//		rooms = service.getAllRoomsForHotel(1);
//		for (Room room : rooms) {
//			System.out.println(room);
//		}
//		
//		System.out.println("Insert");
//		Room newRoom = new Room(3, 1, "12", "LUX", 1, 1, 123, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE,
//				Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, "FULL", 30, 10, Boolean.FALSE);
//		service.insertRoom(newRoom);
//
//		System.out.println("Active");
//		rooms = service.getAllActiveRoomsForHotel(1);
//		for (Room room : rooms) {
//			System.out.println(room);
//		}
//		
//		System.out.println("Update");
//		newRoom.setDeleted(Boolean.TRUE);
//		service.updateRoom(newRoom);
//
//		System.out.println("Active");
//		rooms = service.getAllActiveRoomsForHotel(1);
//		for (Room room : rooms) {
//			System.out.println(room);
//		}
//		System.out.println("All");
//		rooms = service.getAllRoomsForHotel(1);
//		for (Room room : rooms) {
//			System.out.println(room);
//		}
	}

	public boolean isRoomAvailable(int roomId, Timestamp startDate, Timestamp endDate) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().isRoomAvailable(roomId, startDate, endDate));
	}

	public List<Room> getSuitableRooms(int id, boolean typeStandart, boolean typeLux, boolean typeDelux,
			boolean foodNone, boolean foodBreakfast, boolean foodTwice, boolean foodFull, int minPrice, int maxPrice,
			int people, boolean hasWiFi, boolean hasShower, boolean hasParking, boolean hasCondition, boolean hasPool,
			boolean hasGym, boolean hasBalcony, boolean hasSpa, boolean hasService, boolean hasCleaner, boolean hasTv, 
			boolean noDeposit, Timestamp startDate, Timestamp endDate) {
		
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getSuitableRooms(id,
				typeStandart, typeLux, typeDelux, 
				foodNone, foodBreakfast, foodTwice, foodFull,
				minPrice, maxPrice, people,
				hasWiFi, hasShower, hasParking, hasCondition, 
				hasPool, hasGym, hasBalcony, hasSpa, hasService, hasCleaner, hasTv, noDeposit,
				startDate, endDate));
	}

}
