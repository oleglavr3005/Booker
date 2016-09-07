package testService;

import org.junit.Assert;
import org.junit.Test;

import com.epam.task.database.model.Hotel;
import com.epam.task.database.service.HotelService;

import junit.framework.TestCase;

public class HotelServiceTest extends TestCase {

	private HotelService hotelService = new HotelService();
	Hotel hotel = new Hotel(1, "Test", "Lviv", "Test", 1, "Desc", 
			1, 1.0, 1.0, 1.0, false, "111" );

	@Test
	public void testGetAllHotels(){
		assertNotNull(hotelService.getAllHotels());
	}
	
	@Test
	public void testGetHotelById(){
		assertNotNull(hotelService.getHotelById(1));
	}
	
	@Test
	public void testInsertHotel(){
		try{
			assertNotNull(hotelService.insertHotel(hotel)); 
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void testRemoveHotel(){
		try{
			assertNotNull(hotelService.removeHotel(hotel));
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void testUpdateHotel(){
		try{
			assertNotNull(hotelService.updateHotel(hotel));
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test
	public void testGetAllHotelsByManager(){
		assertNotNull(hotelService.getAllHotelsByManager(1));
	}
}
