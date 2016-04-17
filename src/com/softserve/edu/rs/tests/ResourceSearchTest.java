package com.softserve.edu.rs.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.Coordinate;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.Application;
import com.softserve.edu.rs.pages.RegistratorHomePage;
import com.softserve.edu.rs.pages.SearchResourcesPage;
import com.softserve.edu.rs.pages.TopPage.ChangeLanguageFields;

public class ResourceSearchTest {

	private static final String UNSUCCESSFUL_SEARCH_LABEL_UKR = "«а заданими параметрами ресурси не знайдено.";
	private static final String UNSUCCESSFUL_SEARCH_LABEL_RUS = "ѕо заданным параметрам ресурсы не найдены.";
	private static final String UNSUCCESSFUL_SEARCH_LABEL_ENG = "Resources not found.";
	private static final String[] RESOURCE_ID = { "123:44:35:445:34567:3457", "123:33:33:333:33333:2222" };
	private static Set<String> expectedIds;
	private Application application;
	private RegistratorHomePage registratorHomePage;
	private SearchResourcesPage resourcesSearchPage;
	private SearchResourcesPage spage;

	@BeforeClass(groups = { "main", "JScript" })
	public void oneTimeSetUp() {
		application = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefox());
		registratorHomePage = application.load().successRegistratorLogin(UserRepository.get().getRegistrator());
		registratorHomePage.changeLanguage(ChangeLanguageFields.UKRAINIAN);
		resourcesSearchPage = registratorHomePage.gotoResourcesSearchPage();
		expectedIds = new HashSet<String>(Arrays.asList(RESOURCE_ID));
	}

	@AfterClass(groups = { "main", "JScript" })
	public void oneTimeTearDown() {
		application.quitAll();
	}

	@DataProvider
	public Object[][] testCoordinates() {
		return DataTestRepository.get().getSearchByPointCoordinates();
	}

	public void startSteps(Coordinate latitude, Coordinate longitude) {
		spage = resourcesSearchPage.clickSearchByCoordinate()
				.putPointSearchCoordinate(latitude.getDegrees(), latitude.getMinutes(), latitude.getSeconds(),
						longitude.getDegrees(), longitude.getMinutes(), longitude.getSeconds())
				.clickSearchButton().initElementsAfterSuccessfulSearch();
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids));
	}

	@Test(groups = "main", dataProvider = "testCoordinates")
	public void testFound(Coordinate latitude, Coordinate longitude) {
		spage = resourcesSearchPage.clickSearchByCoordinate()
				.putPointSearchCoordinate(latitude.getDegrees(), latitude.getMinutes(), latitude.getSeconds(),
						longitude.getDegrees(), longitude.getMinutes(), longitude.getSeconds())
				.clickSearchButton().initElementsAfterSuccessfulSearch();
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids));
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size());
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), "Showing 1 to 2 of 2 entries");
	}

	@DataProvider
	public Object[][] testCoordinates_() {
		return DataTestRepository.get().getSearchByPointCoordinatesNotFound();
	}

	@Test(groups = "main", dataProvider = "testCoordinates_")
	public void testNotFound(Coordinate latitude, Coordinate longitude) {
		spage = resourcesSearchPage.clickSearchByCoordinate()
				.putPointSearchCoordinate(latitude.getDegrees(), latitude.getMinutes(), latitude.getSeconds(),
						longitude.getDegrees(), longitude.getMinutes(), longitude.getSeconds())
				.clickSearchButton().initElementsAfterUnsuccessfulSearch();

		assertEquals(spage.getSearchResultDiv().getText(), UNSUCCESSFUL_SEARCH_LABEL_UKR);
	}

	@DataProvider
	public Object[][] testAreaCoordinates() {
		return DataTestRepository.get().getSearchByAreaCoordinates();
	}

	@Test(groups = "main", dataProvider = "testAreaCoordinates")
	public void testAreaFound(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2,
			Coordinate longitude2) {
		spage = resourcesSearchPage.clickSearchByArea()
				.putAreaSearchCoordinate(latitude1.getDegrees(), latitude1.getMinutes(), latitude1.getSeconds(),
						longitude1.getDegrees(), longitude1.getMinutes(), longitude1.getSeconds(),
						latitude2.getDegrees(), latitude2.getMinutes(), latitude2.getSeconds(), longitude2.getDegrees(),
						longitude2.getMinutes(), longitude2.getSeconds())
				.clickSearchAreaButton().initElementsAfterSuccessfulSearch();
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids));
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size());
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), "Showing 1 to 2 of 2 entries");
	}

	@DataProvider
	public Object[][] testAreaCoordinates_() {
		return DataTestRepository.get().getSearchByAreaCoordinatesNotFound();
	}

	@Test(groups = "main", dataProvider = "testAreaCoordinates_")
	public void testAreaNotFound(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2,
			Coordinate longitude2) {
		spage = resourcesSearchPage.clickSearchByArea()
				.putAreaSearchCoordinate(latitude1.getDegrees(), latitude1.getMinutes(), latitude1.getSeconds(),
						longitude1.getDegrees(), longitude1.getMinutes(), longitude1.getSeconds(),
						latitude2.getDegrees(), latitude2.getMinutes(), latitude2.getSeconds(), longitude2.getDegrees(),
						longitude2.getMinutes(), longitude2.getSeconds())
				.clickSearchAreaButton().initElementsAfterUnsuccessfulSearch();
		assertEquals(spage.getSearchResultDiv().getText(), UNSUCCESSFUL_SEARCH_LABEL_UKR);
	}

	// tests with Javascript injection

	@Test(groups = "JScript", dataProvider = "testCoordinates")
	public void testOnMapByPointFound(Coordinate latitude, Coordinate longitude) {
		SearchResourcesPage spage = resourcesSearchPage;
		executeJS(spage, latitude, longitude);
		spage.initElementsAfterSuccessfulSearch();
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids));
		spage.initElementsAfterSuccessfulSearch();
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size());
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), "Showing 1 to 2 of 2 entries");
	}

	@Test(groups = "JScript", dataProvider = "testCoordinates_")
	public void testOnMapByPointNotFound(Coordinate latitude, Coordinate longitude) {
		SearchResourcesPage spage = resourcesSearchPage;
		executeJS(spage, latitude, longitude);
		spage.initElementsAfterUnsuccessfulSearch();
		assertEquals(spage.getSearchResultDiv().getText(), UNSUCCESSFUL_SEARCH_LABEL_UKR);
	}

	private void executeJS(SearchResourcesPage spage, Coordinate latitude, Coordinate longitude) {
		JavascriptExecutor js = (JavascriptExecutor) spage.getJsExecutor();
		js.executeScript("var myCenter=new google.maps.LatLng(" + latitude.toString() + "," + longitude.toString()
				+ ");" + "var marker=new google.maps.Marker({ position:myCenter,});"
				+ "marker.setMap(map);  map.setCenter(myCenter); " + "map.setZoom(9);" + " searchOnMapByPoint(marker)");
	}
}
