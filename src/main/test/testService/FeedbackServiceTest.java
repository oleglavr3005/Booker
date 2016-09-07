package testService;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import com.epam.task.database.model.Feedback;
import com.epam.task.database.service.FeedbackService;

import junit.framework.TestCase;

public class FeedbackServiceTest extends TestCase{
	private FeedbackService feedbackService = new FeedbackService();
	Feedback feedback = new Feedback(1, 1, 1, 1, "aaa", "aaa", new Timestamp(new Date().getTime()));

	@Test
	public void testGetAllFeedbacks(){
		assertNotNull(feedbackService.getAllFeedbacks());
	}
	
	@Test
	public void testInsertFeedback(){
		assertNotNull(feedbackService.insertFeedback(feedback));
	}
	
	@Test
	public void testUpdateFeedback(){
		assertNotNull(feedbackService.updateFeedback(feedback));
	}
	
	@Test
	public void testGetAllFeedbacksByHotel(){
		assertNotNull(feedbackService.getAllFeedbacksByHotel(1));
	}
	
	@Test
	public void testGetFeedBackByUserAndHotel(){
		assertNotNull(feedbackService.getFeedBackByUserAndHotel(1, 1));
	}

}
