package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.task.database.model.Order;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.transformers.UniversalTransformer;

public class OrderDAO {

	private Connection connection;

	private final String SQL_GET_ALL_ORDERS = "SELECT * FROM order";
	private final String SQL_CREATE_ORDER = "INSERT INTO order (user_id, room_id, start_date, end_date, status, order_date, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_READ_ORDER_BY_ID = "SELECT * FROM order WHERE order_id = ?";
	private final String SQL_UPDATE_ORDER = "UPDATE order SET user_id = ?, room_id = ?, start_date = ?, end_date = ?, status = ?, order_date = ?, price = ?";
	private final String SQL_GET_ALL_ORDERS_BY_STATUS = "SELECT * FROM order WHERE status LIKE ?";
	private final String SQL_GET_ORDER_BY_USER_ID = "SELECT * FROM order WHERE user_id = ?";
	private final String SQL_GET_ORDER_BY_ROOM_ID = "SELECT * FROM order WHERE room_id = ?";

	public OrderDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_ORDERS);) {
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}

	public int insertOrder(Order order) { // he does create
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_CREATE_ORDER);) {
			st.setInt(1, order.getUserId());
			st.setInt(2, order.getRoomId());
			st.setTimestamp(3, order.getStartDate());
			st.setTimestamp(4, order.getEndDate());
			st.setString(5, order.getStartDate().toString());
			st.setTimestamp(6, order.getOrderDate());
			st.setInt(7, order.getPrice());
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Order getOrderById(int id) {
		Order order = null;
		try (PreparedStatement st = connection.prepareStatement(SQL_READ_ORDER_BY_ID);) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			order = UniversalTransformer.getObjectFromRS(rs, Order.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	public int updateOrder(Order order) {
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_UPDATE_ORDER);) {
			st.setInt(1, order.getUserId());
			st.setInt(2, order.getRoomId());
			st.setTimestamp(3, order.getStartDate());
			st.setTimestamp(4, order.getEndDate());
			st.setString(5, order.getStartDate().toString());
			st.setTimestamp(6, order.getOrderDate());
			st.setInt(7, order.getPrice());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Order> getOrdersByStatus(OrderStatus status) {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_ORDERS_BY_STATUS);) {
			statement.setString(1, status.toString());
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public List<Order> getOrdersByUser(int userId) {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ORDER_BY_USER_ID);) {
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public List<Order> getOrdersByRoom(int roomId) {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ORDER_BY_ROOM_ID);) {
			statement.setInt(1, roomId);
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
