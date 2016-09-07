package testService;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.epam.task.database.model.Order;
import com.epam.task.database.model.enums.OrderStatus;
import com.epam.task.database.service.OrderService;

import junit.framework.TestCase;

public class OrderServiceTest extends TestCase {

	private OrderService orderService = new OrderService();
	Order order = new Order(1, 1, 1, new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()), "ACTIVE", new Timestamp(new Date().getTime()), 100, "aaa", "111");
	
	@Test
	public void testGetAllOrders(){
		assertNotNull(orderService.getAllOrders());
	}
	
	@Test
	public void testGetOrderById(){
		assertNotNull(orderService.getOrderById(55));
	}

	@Test
	public void testUpdateOrder(){
		try{
			assertNotNull(orderService.updateOrder(order));
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void testInsertOrder(){
		try{
			assertNotNull(orderService.insertOrder(order));
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void testGetOrdersByUser(){
		assertNotNull(orderService.getOrdersByUser(1));
	}
	
	@Test
	public void testGetOrderByUserAndId(){
		assertNotNull(orderService.getOrderByUserAndId(4, 55));
	}
	
	@Test
	public void testGetOrdersByUserAndStatus(){
		assertNotNull(orderService.getOrdersByUserAndStatus(4, OrderStatus.ACTIVE));
	}
	
	@Test
	public void testGetOrdersByRoom(){
		assertNotNull(orderService.getOrdersByRoom(1));
	}
	
	@Test
	public void testBookAllByUser(){
		assertNotNull(orderService.bookAllByUser(1, "111", "aaa"));
	}
	
	@Test
	public void testBookOrder(){
		assertNotNull(orderService.bookOrder(55, "11", "aa"));
	}
	
	@Test
	public void testGetOrdersByHotel(){
		assertNotNull(orderService.getOrdersByHotel(1));
	}
}
