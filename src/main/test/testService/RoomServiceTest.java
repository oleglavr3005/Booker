package testService;


import org.junit.Assert;
import org.junit.Test;

import com.epam.task.database.model.Room;
import com.epam.task.database.service.RoomService;

import junit.framework.TestCase;

public class RoomServiceTest extends TestCase {

	private RoomService roomService = new RoomService();
	Room room = new Room(13, 1, "1", "LUX", 1, 1, 100, true, false, true, false, false, false, false, "FULL", 0, 0, false);
	@Test
	public void testGetAllRoomsForHotel(){
		assertNotNull(roomService.getAllRoomsForHotel(1));
	}
	
	@Test
	public void testGetRoomById(){
		assertNotNull(roomService.getRoomById(1));
	}
	
	@Test
	public void testInsertRoom(){
		try{
			assertNotNull(roomService.insertRoom(room));
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void testUpdateRoom(){
		try{
			assertNotNull(roomService.updateRoom(room));
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void testGetMinPrice(){
		assertNotNull(roomService.getMinPrice());
	}
	
	@Test
	public void testGetMaxPrice(){
		assertNotNull(roomService.getMaxPrice());
	}
	
}
