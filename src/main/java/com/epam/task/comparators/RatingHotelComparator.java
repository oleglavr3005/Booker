package com.epam.task.comparators;

import java.util.Comparator;

import com.epam.task.database.model.Hotel;

public class RatingHotelComparator implements Comparator<Hotel>{

	@Override
	public int compare(Hotel o1, Hotel o2) {
		return (int) Math.ceil(o1.getRating() - o2.getRating());
	}

}
