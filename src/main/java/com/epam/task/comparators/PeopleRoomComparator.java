package com.epam.task.comparators;

import java.util.Comparator;

import com.epam.task.database.model.Room;

public class PeopleRoomComparator implements Comparator<Room> {

	@Override
	public int compare(Room o1, Room o2) {
		int room1 = o1.getBedsCount() + o1.getDoubleBedsCount()*2;
		int room2 = o2.getBedsCount() + o2.getDoubleBedsCount()*2;
		return room1 - room2;
	}

}
