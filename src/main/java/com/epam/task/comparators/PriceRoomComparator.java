package com.epam.task.comparators;

import java.util.Comparator;

import com.epam.task.database.model.Room;

public class PriceRoomComparator implements Comparator<Room>{

	@Override
	public int compare(Room o1, Room o2) {
		return o1.getPrice() - o2.getPrice();
	}

}
