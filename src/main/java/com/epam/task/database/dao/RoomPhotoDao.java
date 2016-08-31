package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.RoomPhoto;
import com.epam.task.database.transformers.UniversalTransformer;

public class RoomPhotoDao {

	private Connection connection;

	private final String SQL_GET_ALL = "SELECT * FROM room_photo;";
	private final String SQL_CREATE_ROOM_PHOTO = "INSERT INTO room_photo (img, desc, room_id) VALUES (?, ?, ?);";
	private final String SQL_READ_ROOM_PHOTO_BY_ID = "SELECT * FROM room_photo WHERE room_photo_id = ?";
	private final String SQL_READ_PHOTOS_BY_ROOM = "SELECT * FROM room_photo WHERE room_id = ?";
	private final String SQL_DELETE_PHOTO_BY_ID = "DELETE FROM room_photo WHERE room_id = ?";
	
	public RoomPhotoDao(Connection connection) {
		super();
		this.connection = connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<RoomPhoto> getAll() {
		List<RoomPhoto> photos = null;
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL);) {
			ResultSet rs = statement.executeQuery();
			photos = (List<RoomPhoto>) UniversalTransformer.getCollectionFromRS(rs, RoomPhoto.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return photos;
	}

	public int insertRoomPhoto(RoomPhoto photo) { // he do create
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_CREATE_ROOM_PHOTO)) {
			st.setString(1, photo.getImg());
			st.setString(2, photo.getDesc());
			st.setInt(3, photo.getRoomId());
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public RoomPhoto getRoomPhotoById(int id) {
		RoomPhoto photo = null;
		try (PreparedStatement st = connection.prepareStatement(SQL_READ_ROOM_PHOTO_BY_ID);) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			photo = UniversalTransformer.getObjectFromRS(rs, RoomPhoto.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return photo;
	}

	public List<RoomPhoto> getRoomPhotosByRoom(int id) {
		List<RoomPhoto> photos = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_READ_PHOTOS_BY_ROOM);) {
			ResultSet rs = statement.executeQuery();
			photos = (List<RoomPhoto>) UniversalTransformer.getCollectionFromRS(rs, RoomPhoto.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return photos;
	}

	public int deleteRoomPhoto(int roomPhotoId) {
		try (PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PHOTO_BY_ID);) {
			statement.setInt(1, roomPhotoId);
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

}
