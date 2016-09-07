package testService;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.epam.task.database.model.Request;
import com.epam.task.database.model.enums.RequestStatus;
import com.epam.task.database.service.RequestService;

import junit.framework.TestCase;

public class RequestServiceTest extends TestCase{

	private RequestService requestService = new RequestService();
	Request request = new Request(2, 3, "aaaa", new Timestamp(new Date().getTime()), "PENDING");
	
	@Test
	public void testGetAllRequests(){
		assertNotNull(requestService.getAllRequests());
	}
	
	@Test 
	public void testGetAllRequestsByStatus(){
		assertNotNull(requestService.getAllRequestsByStatus(RequestStatus.PENDING));
	}

	@Test
	public void testGetRequestById(){
		assertNotNull(requestService.getRequestById(1));
	}
	
	@Test
	public void testGetRequestByUserId(){
		assertNotNull(requestService.getRequestByUserId(4));
	}
	
	@Test
	public void testInsertRequest(){
		try {
			assertNotNull(requestService.insertRequest(request));
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test 
	public void testUpdateRequestStatus(){
		assertNotNull(requestService.updateRequestStatus(2, RequestStatus.DECLINED));
	}
}
