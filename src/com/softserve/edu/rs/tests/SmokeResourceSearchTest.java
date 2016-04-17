package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.Application;
import com.softserve.edu.rs.pages.RegistratorHomePage;
import com.softserve.edu.rs.pages.SearchResourcesPage;

public class SmokeResourceSearchTest {
	@DataProvider 
	public Object[][] users() {
		return new Object[][] { { UserRepository.get().getRegistrator() },
				
		};
	}

	@Test(dataProvider = "users")
	public void registratorLogin(IUser user) {
		// Preconditions.
		Application application = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefox());
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(UserRepository.get().getRegistrator());
		SearchResourcesPage spage = registratorHomePage.gotoResourcesSearchPage().clickSearchByCoordinate();
		Assert.assertTrue(spage.getSearchByPointComponent().getSearchByCoordinateLatitudeDegrees().isDisplayed());
		spage = spage.clickSearchByArea();
		Assert.assertTrue(spage.getSearchByAreaComponent().getSearchByAreaLatitudeDegrees1().isDisplayed());

		spage = spage.clickSearchByParameters();
		Assert.assertTrue(spage.getSearchByParametersComponent().getInputPerimeter().isDisplayed());
			application.quit();
		
		;
	}
}
