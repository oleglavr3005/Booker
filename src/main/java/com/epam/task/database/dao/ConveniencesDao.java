package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.model.Room;
import com.epam.task.database.model.Conveniences;
import com.epam.task.database.transformers.UniversalTransformer;

public class ConveniencesDao {
	private Connection connection;
	
	private final String GET_HOTELS_ROOM = "SELECT * FROM room WHERE hotel_id = ?";
	
	public ConveniencesDao(Connection connection) {
		super();
		this.connection = connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public Conveniences getConveniencesForHotel(int hotelId) {
		try {
			PreparedStatement ps = connection.prepareStatement(GET_HOTELS_ROOM);
			ps.setInt(1, hotelId);
			ResultSet rs = ps.executeQuery();
			List<Room> roomList = UniversalTransformer.getCollectionFromRS(rs, Room.class);
			Conveniences conveniences = new Conveniences(false, false, false, false, false, false, false);
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
			return new Conveniences(false, false, false, false, false, false, false);
		}
	}
	
	public List<Conveniences> getConveniencesForSomeHotels (int []arrayHotelId){
		List<Conveniences> list = new ArrayList<>();
		Conveniences conveniences;
		for(int hotelId : arrayHotelId){
			conveniences = getConveniencesForHotel(hotelId);
			list.add(conveniences);
		}
		return list;
	}
	public List<Conveniences> getConveniencesForSomeHotels (List<Hotel> hotelList){
		List<Conveniences> list = new ArrayList<>();
		Conveniences conveniences;
		for(Hotel hotel : hotelList){
			conveniences = getConveniencesForHotel(hotel.getId());
			list.add(conveniences);
		}
		return list;
	}
}
