package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchByPointComponent implements ISearchable {
	private static final String SELECTOR_LATITUDE_DEGREES = "#searchByPointDiv .latitudeDegrees.form-control";
	private static final String SELECTOR_LATITUDE_MINUTES = "#searchByPointDiv .latitudeMinutes.form-control";
	private static final String SELECTOR_LATITUDE_SECONDS = "#searchByPointDiv .latitudeSeconds.form-control";
	private static final String SELECTOR_LONGITUDE_DEGREES = "#searchByPointDiv .longitudeDegrees.form-control";
	private static final String SELECTOR_LONGITUDE_MINUTES = "#searchByPointDiv .longitudeMinutes.form-control";
	private static final String SELECTOR_LONGITUDE_SECONDS = "#searchByPointDiv .longitudeSeconds.form-control";

	private WebElement searchByCoordinateLatitudeDegrees;
	private WebElement searchByCoordinateLatitudeMinutes;
	private WebElement searchByCoordinateLatitudeSeconds;
	private WebElement searchByCoordinateLongitudeDegrees;
	private WebElement searchByCoordinateLongitudeMinutes;
	private WebElement searchByCoordinateLongitudeSeconds;

	public SearchByPointComponent(WebDriver driver) {
		searchByCoordinateLatitudeDegrees = driver.findElement(By.cssSelector(SELECTOR_LATITUDE_DEGREES));
		searchByCoordinateLatitudeMinutes = driver.findElement(By.cssSelector(SELECTOR_LATITUDE_MINUTES));
		searchByCoordinateLatitudeSeconds = driver.findElement(By.cssSelector(SELECTOR_LATITUDE_SECONDS));
		searchByCoordinateLongitudeDegrees = driver.findElement(By.cssSelector(SELECTOR_LONGITUDE_DEGREES));
		searchByCoordinateLongitudeMinutes = driver.findElement(By.cssSelector(SELECTOR_LONGITUDE_MINUTES));
		searchByCoordinateLongitudeSeconds = driver.findElement(By.cssSelector(SELECTOR_LONGITUDE_SECONDS));
	}

	public WebElement getSearchByCoordinateLatitudeDegrees() {
		return searchByCoordinateLatitudeDegrees;
	}

	public WebElement getSearchByCoordinateLatitudeMinutes() {
		return searchByCoordinateLatitudeMinutes;
	}

	public WebElement getSearchByCoordinateLatitudeSeconds() {
		return searchByCoordinateLatitudeSeconds;
	}

	public WebElement getSearchByCoordinateLongitudeDegrees() {
		return searchByCoordinateLongitudeDegrees;
	}

	public WebElement getSearchByCoordinateLongitudeMinutes() {
		return searchByCoordinateLongitudeMinutes;
	}

	public WebElement getSearchByCoordinateLongitudeSeconds() {
		return searchByCoordinateLongitudeSeconds;
	}

	public SearchByPointComponent putPointSearchCoordinate(int latitudeDegrees, int latitudeMinutes,
			double latitudeSeconds, int longitudeDegrees, int longitudeMinutes, double longitudeSeconds) {

		getSearchByCoordinateLatitudeDegrees().clear();
		getSearchByCoordinateLatitudeDegrees().sendKeys(Integer.toString(latitudeDegrees));
		getSearchByCoordinateLatitudeMinutes().clear();
		getSearchByCoordinateLatitudeMinutes().sendKeys(Integer.toString(latitudeMinutes));
		getSearchByCoordinateLatitudeSeconds().clear();
		getSearchByCoordinateLatitudeSeconds().sendKeys(Double.toString(latitudeSeconds));
		getSearchByCoordinateLongitudeDegrees().clear();
		getSearchByCoordinateLongitudeDegrees().sendKeys(Integer.toString(longitudeDegrees));
		getSearchByCoordinateLongitudeMinutes().clear();
		getSearchByCoordinateLongitudeMinutes().sendKeys(Integer.toString(longitudeMinutes));
		getSearchByCoordinateLongitudeSeconds().clear();
		getSearchByCoordinateLongitudeSeconds().sendKeys(Double.toString(longitudeSeconds));

		return this;
	}
}
