package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.epam.task.database.model.Order;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.transformers.UniversalTransformer;

public class OrderDAO {

	private Connection connection;

	private final String SQL_GET_ALL_ORDERS = "SELECT * FROM `order`";
	private final String SQL_CREATE_ORDER = "INSERT INTO `order`(user_id, room_id, start_date, end_date, `status`, order_date, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_READ_ORDER_BY_ID = "SELECT * FROM `order` WHERE order_id = ?";
	private final String SQL_UPDATE_ORDER = "UPDATE `order` SET user_id = ?, room_id = ?, start_date = ?, end_date = ?, `status` = ?, order_date = ?, price = ? WHERE order_id = ?";
	private final String SQL_BOOK_ORDER_BY_ID = "UPDATE `order` SET `status` = 'ACTIVE' WHERE order_id = ?";
	private final String SQL_BOOK_ALL_ORDERS_BY_USER = "UPDATE `order` SET `status` = 'ACTIVE' WHERE user_id = ? AND `status` LIKE 'ORDER'";
	private final String SQL_REMOVE_ORDER = "DELETE FROM `order` WHERE order_id = ?";
	private final String SQL_REMOVE_ORDERS_BY_STATUS = "DELETE FROM `order` WHERE user_id = ? AND `status` LIKE ?";
	private final String SQL_GET_ALL_ORDERS_BY_USER_AND_STATUS = "SELECT * FROM `order` WHERE `status` LIKE ? AND user_id = ?";
	private final String SQL_GET_ORDER_BY_USER_ID = "SELECT * FROM `order` WHERE user_id = ?";
	private final String SQL_GET_ORDER_BY_USER_AND_ID = "SELECT * FROM `order` WHERE user_id = ? AND order_id = ?";
	private final String SQL_GET_ORDER_BY_ROOM_ID = "SELECT * FROM `order` WHERE room_id = ?";

	private final String SQL_CREATE_ORDER_EVENT = "CREATE EVENT eventname ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 1 MINUTE DO DELETE FROM `order` WHERE order_id = ? AND `status` LIKE 'ORDER'";
	
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
		try (PreparedStatement st = connection.prepareStatement(SQL_CREATE_ORDER, Statement.RETURN_GENERATED_KEYS)) {
			st.setInt(1, order.getUserId());
			st.setInt(2, order.getRoomId());
			st.setTimestamp(3, order.getStartDate());
			st.setTimestamp(4, order.getEndDate());
			st.setString(5, order.getStatus().toString());
			st.setTimestamp(6, order.getOrderDate());
			st.setInt(7, order.getPrice());
			result = st.executeUpdate();
			
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			int orderId = rs.getInt(1);
			try (PreparedStatement st1 = connection.prepareStatement(SQL_CREATE_ORDER_EVENT.replaceAll("eventname", "ev" + new Date().getTime()))) {
				st1.setInt(1, orderId);
				st1.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return result;
	}

	public int removeOrder(int id) { // he does create
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_REMOVE_ORDER)) {
			st.setInt(1, id);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Order getOrderById(int id) {
		Order order = null;
		try (PreparedStatement st = connection.prepareStatement(SQL_READ_ORDER_BY_ID)) {
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
		try (PreparedStatement st = connection.prepareStatement(SQL_UPDATE_ORDER)) {
			st.setInt(1, order.getUserId());
			st.setInt(2, order.getRoomId());
			st.setTimestamp(3, order.getStartDate());
			st.setTimestamp(4, order.getEndDate());
			st.setString(5, order.getStatus().toString());
			st.setTimestamp(6, order.getOrderDate());
			st.setInt(7, order.getPrice());
			st.setInt(8, order.getId());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Order> getOrdersByUserAndStatus(int userId, OrderStatus status) {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_ORDERS_BY_USER_AND_STATUS)) {
			statement.setString(1, status.toString());
			statement.setInt(2, userId);
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public List<Order> getOrdersByUser(int userId) {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ORDER_BY_USER_ID)) {
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public Order getOrderByUserAndId(int userId, int orderId) {
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ORDER_BY_USER_AND_ID);) {
			statement.setInt(1, userId);
			statement.setInt(2, orderId);
			ResultSet rs = statement.executeQuery();
			return UniversalTransformer.getObjectFromRS(rs, Order.class);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
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

	public int removeAllOrdersByStatus(int userId, OrderStatus order) {
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_REMOVE_ORDERS_BY_STATUS)) {
			st.setInt(1, userId);
			st.setString(2, order.toString());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int bookAllByUser(int userId) {
		try (PreparedStatement st = connection.prepareStatement(SQL_BOOK_ALL_ORDERS_BY_USER)) {
			st.setInt(1, userId);
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int bookOrder(int orderId) {
		try (PreparedStatement st = connection.prepareStatement(SQL_BOOK_ORDER_BY_ID)) {
			st.setInt(1, orderId);
			return st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
