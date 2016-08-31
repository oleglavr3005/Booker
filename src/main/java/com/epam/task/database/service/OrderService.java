package com.epam.task.database.service;

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
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getAll());
	}

	public List<Order> getordersByStatus(OrderStatus status) {
		return daoManager.executeAndClose(() -> daoManager.getOrderDao().getOrdersByStatus(status));
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
}
