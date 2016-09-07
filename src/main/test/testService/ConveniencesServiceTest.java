package testService;

import org.junit.Test;

import com.epam.task.database.service.ConveniencesService;

import junit.framework.TestCase;

public class ConveniencesServiceTest extends TestCase{
	
	private ConveniencesService conveniencesService = new ConveniencesService();

	@Test
	public void testGetConveniencesForHotel(){
		assertNotNull(conveniencesService.getConveniencesForHotel(1));
	}
	
	

}
