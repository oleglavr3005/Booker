package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.—onveniences;
import com.epam.task.database.transformers.UniversalTransformer;

public class —onveniencesDao {
	private Connection connection;
	
	private final String GET_HOTELS_ROOM = "SELECT * FROM room WHERE hotel_id = ?";
	
	public —onveniencesDao(Connection connection) {
		super();
		this.connection = connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public —onveniences get—onveniencesForHotel(int hotelId) {
		try {
			PreparedStatement ps = connection.prepareStatement(GET_HOTELS_ROOM);
			ps.setInt(1, hotelId);
			ResultSet rs = ps.executeQuery();
			List<Room> roomList = UniversalTransformer.getCollectionFromRS(rs, Room.class);
			—onveniences conveniences = new —onveniences(false, false, false, false, false, false, false);
			for(Room room: roomList){
				if(room.getWifi() == true){
					conveniences.setWiFi(true);
				}
				if(room.getShower() == true){
					conveniences.setShower(true);
				}
				if(room.getParking() == true){
					conveniences.setParking(true);
				}
				if(room.getCondition() == true){
					conveniences.setCondition(true);
				}
				if(room.getPool() == true){
					conveniences.setPool(true);
				}
				if(room.getGym() == true){
					conveniences.setGym(true);
				}
				if(room.getBalcony() == true){
					conveniences.setBalcony(true);
				}
			}
			return conveniences;
		} catch (Exception e) {
			return new —onveniences(false, false, false, false, false, false, false);
		}
	}
	
	public List<—onveniences> get—onveniencesForSomeHotels (int []arrayHotelId){
		List<—onveniences> list = new ArrayList<>();
		—onveniences conveniences;
		for(int hotelId : arrayHotelId){
			conveniences = get—onveniencesForHotel(hotelId);
			list.add(conveniences);
		}
		return list;
	}
	public List<—onveniences> get—onveniencesForSomeHotels (List<Hotel> hotelList){
		List<—onveniences> list = new ArrayList<>();
		—onveniences conveniences;
		for(Hotel hotel : hotelList){
			conveniences = get—onveniencesForHotel(hotel.getId());
			list.add(conveniences);
		}
		return list;
	}
}
