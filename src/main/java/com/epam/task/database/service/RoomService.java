package com.epam.task.database.service;


import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.enums.RoomFood;
import com.epam.task.database.model.enums.RoomType;

public class RoomService {

	private DaoManager daoManager;

	public RoomService() {
		super();
		daoManager = new DaoManager();
	}

	public List<Room> getAllActiveRoomsForHotel(int id) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getAllActiveRoomsForHotel(id));
	}

	public List<Room> getAllRoomsForHotel(int id) {
		return daoManager.executeAndClose(() -> daoManager.getRoomDao().getAllRoomsForHotel(id));
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

	public static void main(String[] args) {
		RoomService service = new RoomService();
		service.testing();
	}
	
	private void testing(){
		RoomService service = new RoomService();
		System.out.println("Active");
		List<Room> rooms = service.getAllActiveRoomsForHotel(1);
		for (Room room : rooms) {
			System.out.println(room);
		}
		System.out.println("All");
		rooms = service.getAllRoomsForHotel(1);
		for (Room room : rooms) {
			System.out.println(room);
		}

		System.out.println("remove");
		service.removeRoom(1);

		System.out.println("Active");
		rooms = service.getAllActiveRoomsForHotel(1);
		for (Room room : rooms) {
			System.out.println(room);
		}
		System.out.println("All");
		rooms = service.getAllRoomsForHotel(1);
		for (Room room : rooms) {
			System.out.println(room);
		}

		System.out.println("restore");
		service.restoreRoom(1);

		System.out.println("Active");
		rooms = service.getAllActiveRoomsForHotel(1);
		for (Room room : rooms) {
			System.out.println(room);
		}
		System.out.println("All");
		rooms = service.getAllRoomsForHotel(1);
		for (Room room : rooms) {
			System.out.println(room);
		}
		
		System.out.println("Insert");
		Room newRoom = new Room(3, 1, "12", "LUX", 1, 1, 123, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE,
				Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, "FULL", 30, 10, Boolean.FALSE);
		service.insertRoom(newRoom);

		System.out.println("Active");
		rooms = service.getAllActiveRoomsForHotel(1);
		for (Room room : rooms) {
			System.out.println(room);
		}
		
		System.out.println("Update");
		newRoom.setDeleted(Boolean.TRUE);
		service.updateRoom(newRoom);

		System.out.println("Active");
		rooms = service.getAllActiveRoomsForHotel(1);
		for (Room room : rooms) {
			System.out.println(room);
		}
		System.out.println("All");
		rooms = service.getAllRoomsForHotel(1);
		for (Room room : rooms) {
			System.out.println(room);
		}
	}

}
