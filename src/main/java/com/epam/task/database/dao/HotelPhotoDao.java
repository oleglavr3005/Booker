package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.HotelPhoto;
import com.epam.task.database.transformers.UniversalTransformer;

public class HotelPhotoDao {

	private Connection connection;

	private final String SQL_GET_ALL = "SELECT * FROM hotel_photo";
	private final String SQL_CREATE_HOTEL_PHOTO = "INSERT INTO hotel_photo (img, `desc`, hotel_id, is_main) VALUES (?, ?, ?, ?)";
	private final String SQL_READ_HOTEL_PHOTO_BY_ID = "SELECT * FROM hotel_photo WHERE hotel_photo_id = ?";
	private final String SQL_READ_PHOTOS_BY_HOTEL = "SELECT * FROM hotel_photo WHERE hotel_id = ?";
	private final String SQL_DELETE_PHOTO_BY_ID = "DELETE FROM hotel_photo WHERE hotel_photo_id = ?";
	
	private final String UPDATE = "UPDATE `hotel_photo` SET img = ?, desc = ?, hotel_id = ?, is_main = ? WHERE hotel_photo_id = ?";

	// private final String SQL_UPDATE_HOTEL_PHOTO = "";

	public HotelPhotoDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<HotelPhoto> getAllHotelPhotos() {
		List<HotelPhoto> photos = new ArrayList<>();;
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL);) {
			ResultSet rs = statement.executeQuery();
			photos = (List<HotelPhoto>) UniversalTransformer.getCollectionFromRS(rs, HotelPhoto.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return photos;
	}

	public int insertHotelPhoto(HotelPhoto photo) { // he do create
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_CREATE_HOTEL_PHOTO)) {
			st.setString(1, photo.getImg());
			st.setString(2, photo.getDesc());
			st.setInt(3, photo.getHotelId());
			st.setBoolean(4, photo.isMain());
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public HotelPhoto getHotelPhotoById(int id) {
		HotelPhoto photo = null;
		try (PreparedStatement st = connection.prepareStatement(SQL_READ_HOTEL_PHOTO_BY_ID);) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			photo = UniversalTransformer.getObjectFromRS(rs, HotelPhoto.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return photo;
	}

	public List<HotelPhoto> getHotelPhotosByHotel(int id) {
		List<HotelPhoto> photos = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_READ_PHOTOS_BY_HOTEL);) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			photos = (List<HotelPhoto>) UniversalTransformer.getCollectionFromRS(rs, HotelPhoto.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return photos;
	}

	public int deleteHotelPhoto(int hotelPhotoId) {
		try (PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PHOTO_BY_ID);) {
			statement.setInt(1, hotelPhotoId);
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int updateHotelPhoto(HotelPhoto photo) {
		try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
			int i = 1;
			statement.setString(i++, photo.getImg());
			statement.setString(i++, photo.getDesc());
			statement.setInt(i++, photo.getHotelId());
			statement.setBoolean(i++, photo.isMain());

			statement.setInt(i, photo.getId());
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
