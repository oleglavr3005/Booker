package com.epam.task.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.task.database.model.Order;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.transformers.UniversalTransformer;

public class OrderDAO {

	private Connection connection;
	private static final Logger LOGGER = Logger.getLogger(OrderDAO.class);

	private final String SQL_GET_ALL_ORDERS = "SELECT * FROM `order`";
	private final String SQL_CREATE_ORDER = "INSERT INTO `order`(user_id, room_id, start_date, end_date, `status`, order_date, price, card_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_READ_ORDER_BY_ID = "SELECT * FROM `order` WHERE order_id = ?";
	private final String SQL_UPDATE_ORDER = "UPDATE `order` SET user_id = ?, room_id = ?, start_date = ?, end_date = ?, `status` = ?, order_date = ?, price = ?, card_number = ? WHERE order_id = ?";
	private final String SQL_BOOK_ORDER_BY_ID = "UPDATE `order` SET `status` = 'ACTIVE', card_number = ?, comment = ? WHERE order_id = ?";
	private final String SQL_BOOK_ALL_ORDERS_BY_USER = "UPDATE `order` SET `status` = 'ACTIVE', card_number = ?, comment = ? WHERE user_id = ? AND `status` LIKE 'ORDER'";
	private final String SQL_REMOVE_ORDER = "DELETE FROM `order` WHERE order_id = ?";
	private final String SQL_REMOVE_ORDERS_BY_STATUS = "DELETE FROM `order` WHERE user_id = ? AND `status` LIKE ?";
	private final String SQL_GET_ALL_ORDERS_BY_USER_AND_STATUS = "SELECT * FROM `order` WHERE `status` LIKE ? AND user_id = ?";
	private final String SQL_GET_ALL_ORDERS_BY_HOTEL_AND_STATUS = "SELECT o.* FROM `order` o INNER JOIN `room` r ON o.room_id = r.room_id WHERE o.`status` LIKE ? AND r.hotel_id = ?";
	private final String SQL_GET_ORDER_BY_USER_ID = "SELECT * FROM `order` WHERE user_id = ?";
	private final String SQL_GET_ORDER_BY_USER_AND_ID = "SELECT * FROM `order` WHERE user_id = ? AND order_id = ?";
	private final String SQL_GET_ORDER_BY_ROOM_ID = "SELECT * FROM `order` WHERE room_id = ?";
	private final String SQL_GET_ORDER_BY_HOTEL_ID = "SELECT o.* FROM `order` o INNER JOIN `room` r ON o.room_id = r.room_id WHERE r.hotel_id = ?";
	private final String SQL_GET_FINISHED_ORDERS_BY_USER_AND_HOTEL = "SELECT o.* FROM `order` o INNER JOIN `room` r ON o.room_id = r.room_id WHERE o.user_id = ? AND r.hotel_id = ? AND o.end_date < ?";
	
	private final String PAGINATION = " LIMIT ?, 5";
	private final String ORDER_BY_PRICE_ASC = " ORDER BY price ASC";
	private final String ORDER_BY_PRICE_DESC = " ORDER BY price DESC";
	private final String ORDER_BY_DATE_ASC = " ORDER BY start_date ASC";
	private final String ORDER_BY_DATE_DESC = " ORDER BY start_date DESC";

	private final String SQL_ENABLE_EVENTS = "SET GLOBAL event_scheduler=ON";
	private final String SQL_CREATE_ORDER_EVENT = "CREATE EVENT eventname ON SCHEDULE AT CURRENT_TIMESTAMP + INTERVAL 30 MINUTE DO DELETE FROM `order` WHERE order_id = ? AND `status` LIKE 'ORDER'";
	
	public OrderDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_ORDERS)) {
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all orders", e);
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
			st.setString(8, order.getCardNumber());
			result = st.executeUpdate();
			if(result > 0) {
				LOGGER.info("Order inserted");
			}
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			int orderId = rs.getInt(1);
			try(PreparedStatement st1 = connection.prepareStatement(SQL_ENABLE_EVENTS)) {
				st1.executeUpdate();
			}
			try (PreparedStatement st1 = connection.prepareStatement(SQL_CREATE_ORDER_EVENT.replaceAll("eventname", "ev" + new Date().getTime()))) {
				st1.setInt(1, orderId);
				st1.executeUpdate();
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot insert order", e);
			return -1;
		}
		return result;
	}

	public int removeOrder(int id) { // he does create
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_REMOVE_ORDER)) {
			st.setInt(1, id);
			result = st.executeUpdate();
			if(result > 0) {
				LOGGER.info("Order removed");
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot remove order", e);
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
        	LOGGER.error("Cannot get order by id", e);
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
			st.setString(8, order.getCardNumber());
			st.setInt(9, order.getId());
			result = st.executeUpdate();
			if(result > 0) {
				LOGGER.info("Order updated");
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot update order", e);
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
        	LOGGER.error("Cannot get all orders by user and status", e);
		}
		return orders;
	}

	public List<Order> getOrdersByUserAndStatusAndPage(int userId, OrderStatus status, int page, String orderBy) {
		List<Order> orders = new ArrayList<>();
		String ORDER_BY;
		if("compareByPriceAsc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_PRICE_ASC;
		} else if ("compareByPriceDesc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_PRICE_DESC;
			
		} else if ("compareByDateAsc".equals(orderBy)) {
			ORDER_BY = ORDER_BY_DATE_ASC;
		} else { //compareByDateDesc = default
			ORDER_BY = ORDER_BY_DATE_DESC;
		}
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_ORDERS_BY_USER_AND_STATUS + ORDER_BY + PAGINATION)) {
			statement.setString(1, status.toString());
			statement.setInt(2, userId);
			statement.setInt(3, (page-1)*5);
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all orders by user and status and page", e);
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
        	LOGGER.error("Cannot get all orders by user", e);
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
        	LOGGER.error("Cannot get order by user and id", e);
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
        	LOGGER.error("Cannot get all orders by room", e);
		}
		return orders;
	}

	public int removeAllOrdersByStatus(int userId, OrderStatus order) {
		int result = 0;
		try (PreparedStatement st = connection.prepareStatement(SQL_REMOVE_ORDERS_BY_STATUS)) {
			st.setInt(1, userId);
			st.setString(2, order.toString());
			result = st.executeUpdate();
			if(result > 0) {
				LOGGER.info("Orders by status removed");
			}
		} catch (SQLException e) {
        	LOGGER.error("Cannot remove all orders by status", e);
		}
		return result;
	}

	public int bookAllByUser(int userId, String cardNumber, String comment) {
		try (PreparedStatement st = connection.prepareStatement(SQL_BOOK_ALL_ORDERS_BY_USER)) {
			st.setString(1, cardNumber);
			st.setString(2, comment);
			st.setInt(3, userId);
			int result = st.executeUpdate();
			if(result > 0) {
				LOGGER.info("Orders by user booked");
			}
			return result;
		} catch (SQLException e) {
        	LOGGER.error("Cannot book (update) all orders by user", e);
			return -1;
		}
	}

	public int bookOrder(int orderId, String cardNumber, String comment) {
		try (PreparedStatement st = connection.prepareStatement(SQL_BOOK_ORDER_BY_ID)) {
			st.setString(1, cardNumber);
			st.setString(2, comment);
			st.setInt(3, orderId);
			int result = st.executeUpdate();
			if(result > 0) {
				LOGGER.info("Order booked");
			}
			return result;
		} catch (SQLException e) {
        	LOGGER.error("Cannot book (update) order", e);
			return -1;
		}
	}

	public List<Order> getOrdersByHotel(int hotelId) {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ORDER_BY_HOTEL_ID)) {
			statement.setInt(1, hotelId);
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all orders by hotel", e);
		}
		return orders;
	}

	public List<Order> getFinishedOrdersByUserAndHotel(int userId, int hotelId) {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_FINISHED_ORDERS_BY_USER_AND_HOTEL)) {
			statement.setInt(1, userId);
			statement.setInt(2, hotelId);
			statement.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all finished orders by user and hotel", e);
		}
		return orders;
	}

	public List<Order> getOrdersByHotelAndStatus(int hotelId, OrderStatus status) {
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_ORDERS_BY_HOTEL_AND_STATUS)) {
			statement.setString(1, status.toString());
			statement.setInt(2, hotelId);
			ResultSet rs = statement.executeQuery();
			orders = UniversalTransformer.getCollectionFromRS(rs, Order.class);
		} catch (SQLException e) {
        	LOGGER.error("Cannot get all orders by hotel and status", e);
		}
		return orders;
	}
}
