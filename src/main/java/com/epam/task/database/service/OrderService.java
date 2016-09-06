package com.epam.task.database.service;

import java.sql.Timestamp;
import java.util.List;

import com.epam.task.database.dao.manager.DaoManager;
import com.epam.task.database.model.Order;
import com.epam.task.database.model.enums.OrderStatus;

public class OrderService {

	private DaoManager daoManager;

	public OrderService() {
		super();
		daoManager = new DaoManager();
	}

	public List<Order> getAllOrders() {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getAllOrders());
	}

	public Order getOrderById(int id) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getOrderById(id));
	}

	public int updateOrder(Order order) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().updateOrder(order));
	}

	public int insertOrder(Order order) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().insertOrder(order));
	}

	public List<Order> getOrdersByUser(int userId) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getOrdersByUser(userId));
	}

	public Order getOrderByUserAndId(int userId, int orderId) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getOrderByUserAndId(userId, orderId));
	}

	public List<Order> getOrdersByUserAndStatus(int userId, OrderStatus status) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getOrdersByUserAndStatus(userId, status));
	}

	public List<Order> getOrdersByUserAndStatusAndPage(int userId, OrderStatus status, int page, String compareBy) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getOrdersByUserAndStatusAndPage(userId, status, page, compareBy));
	}

	public List<Order> getOrdersByRoom(int roomId) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getOrdersByRoom(roomId));
	}

	public static void main(String[] args) {
		OrderService service = new OrderService();
		service.testing();
	}

	private void testing() {
		OrderService service = new OrderService();
		System.out.println("ById");
		Order order = service.getOrderById(1);
		System.out.println(order.getId());
		System.out.println("ByStatus");
		List<Order> photos = service.getOrdersByUserAndStatus(1, OrderStatus.ACTIVE);
		for (Order photo : photos) {
			System.out.println(photo.getId());
		}
		System.out.println("All");
		photos = service.getAllOrders();
		for (Order photo : photos) {
			System.out.println(photo.getId());
		}

		System.out.println("Insert");
		Order newPhoto = new Order(8, 2, 1, new Timestamp(7000000), new Timestamp(8070000), "ACTIVE",
				new Timestamp(6070000), 2000, "", "");
		service.insertOrder(newPhoto);
		System.out.println("All");
		photos = service.getAllOrders();
		for (Order photo : photos) {
			System.out.println(photo.getId());
		}

		System.out.println("ByUser");
		photos = service.getOrdersByUser(1);
		for (Order photo : photos) {
			System.out.println(photo.getId());
		}
		System.out.println("ByRoom");
		photos = service.getOrdersByRoom(2);
		for (Order photo : photos) {
			System.out.println(photo.getId());
		}
		System.out.println("All");
		photos = service.getAllOrders();
		for (Order photo : photos) {
			System.out.println(photo.getId());
		}

		// System.out.println("update");
		// service.updateOrder(new Order(8,1,2,new Timestamp(1000000),new
		// Timestamp(1070000),"ACTIVE",new Timestamp(1070000),2000));

		System.out.println("All");
		photos = service.getAllOrders();
		for (Order photo : photos) {
			System.out.println(photo.getId());
		}

	}

	public int removeOrder(int orderId) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().removeOrder(orderId));
		
	}

	public int removeAllOrdersByStatus(int userId, OrderStatus order) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().removeAllOrdersByStatus(userId, order));
	}

	public int bookAllByUser(int userId, String cardNumber, String comment) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().bookAllByUser(userId, cardNumber, comment));
	}

	public int bookOrder(int orderId, String cardNumber, String comment) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().bookOrder(orderId, cardNumber, comment));
	}

	public List<Order> getOrdersByHotel(int hotelId) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getOrdersByHotel(hotelId));
	}
}
