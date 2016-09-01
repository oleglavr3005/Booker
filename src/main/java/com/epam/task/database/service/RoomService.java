package com.epam.task.database.service;


import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Room;

public class RoomService {
	
	private DaoManager daoManager;

	public RoomService() {
		super();
		daoManager = new DaoManager();
	}

	public void getAllActiveRoomsForHotel(int id) {
		daoManager.executeVoidAndClose(() -> daoManager.getRoomDao().getAllActiveRoomsForHotel(id));
	}

	public void getAllRoomsForHotel(int id) {
		daoManager.executeVoidAndClose(() -> daoManager.getRoomDao().getAllRoomsForHotel(id));
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

}
