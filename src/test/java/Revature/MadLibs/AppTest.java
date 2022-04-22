package Revature.MadLibs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.dao.UserDAO;
import com.revature.models.UserModel;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	UserDAO userDAO = new UserDAO();
	UserModel user = new UserModel("mock_username","12345");
	UserModel user2 = new UserModel();
	@Test
	public void createAndGetUser() {
		// create user
		userDAO.addUser(user);
		
		//get user
		user2 = userDAO.getUser("mock_username");
		
		// check db object exists
		assertTrue(userDAO.usernameExists(user.username));
		
		// check all values are correct
		assertEquals(user.username, user2.username);
		assertEquals(user.password, user2.password);
		

		// delete user.mer
		userDAO.deleteUser(user);

		// make sure no object is returned if you query username
		assertNull(userDAO.getUser(user.username));

		//same but with different methods
		assertFalse(userDAO.usernameExists("mock_username"));
		// empty user. for use by other tests
		user2 = null;

	}

	

}
