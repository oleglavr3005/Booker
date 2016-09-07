package testService;

import org.junit.Assert;
import org.junit.Test;

import com.epam.task.database.model.User;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.database.service.UserService;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase {

	private UserService userService = new UserService();
	
	@Test
	public void testGetAllUsers(){
		assertNotNull(userService.getAllUsers());
	}
	
	@Test
	public void testGetAllUsersWithEmailNotification(){
		assertNotNull(userService.getAllUsersWithEmailNotification());
	}
	
	@Test
	public void testGetAllUsersWithEmailNotificationInHotel(){
		assertNotNull(userService.getAllUsersWithEmailNotificationInHotel(0));
	}
	
	@Test 
	public void testGetAllUsersWithPhoneNotification(){
		assertNotNull(userService.getAllUsersWithPhoneNotification());
	}
	
	@Test
	public void testGetAllUsersWithPhoneNotificationInHotel(){
		assertNotNull(userService.getAllUsersWithPhoneNotificationInHotel(0));
	}
	
	@Test
	public void testGetUserById(){
		assertNotNull(userService.getUserById(1));
	}
	
	@Test
	public void testInsertUser(){
		try{
		User user = new User(); 
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setEmail("test@gmail.com");
		user.setType("USER");
		user.setStatus("PENDING");
		user.setPassword("test");
		
		assertNotNull(userService.insertUser(user));
		}catch(Exception e){
			Assert.fail();
		}
	}
	
	@Test 
	public void testUpdateUser(){
		try{
			User user = new User(); 
			user.setFirstName("Test");
			user.setLastName("Test");
			user.setEmail("test@gmail.com");
			user.setType("USER");
			user.setStatus("PENDING");
			user.setPassword("test");
			
			assertNotNull(userService.updateUser(user));
			}catch(Exception e){
				Assert.fail();
			}
	}
	
	@Test
	public void testGetUserByEmail(){
		assertNotNull(userService.getUserByEmail("test@mail.ru"));
	}
	
	@Test
	public void testGetUserByStatus(){
		assertNotNull(userService.getUserByStatus(UserStatus.ACTIVE));
	}
	
	@Test 
	public void testGetUserByType(){
		assertNotNull(userService.getUserByType(UserType.USER));
	}
}
