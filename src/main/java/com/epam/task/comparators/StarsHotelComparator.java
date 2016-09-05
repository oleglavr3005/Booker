package com.epam.task.comparators;

import java.util.Comparator;

import com.epam.task.database.model.Hotel;

public class StarsHotelComparator implements Comparator<Hotel>{

	@Override
	public int compare(Hotel o1, Hotel o2) {
		return o1.getStars() - o2.getStars();
	}

}
