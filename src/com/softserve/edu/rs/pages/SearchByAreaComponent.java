package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchByAreaComponent implements ISearchable {
	private static final String SELECTOR_LATITUDE_DEGREES_1 = "#first_point .latitudeDegrees.form-control";
	private static final String SELECTOR_LATITUDE_MINUTES_1 = "#first_point .latitudeMinutes.form-control";
	private static final String SELECTOR_LATITUDE_SECONDS_1 = "#first_point .latitudeSeconds.form-control";
	private static final String SELECTOR_LONGITUDE_DEGREES_1 = "#first_point .longitudeDegrees.form-control";
	private static final String SELECTOR_LONGITUDE_MINUTES_1 = "#first_point .longitudeMinutes.form-control";
	private static final String SELECTOR_LONGITUDE_SECONDS_1 = "#first_point .longitudeSeconds.form-control";
	private static final String SELECTOR_LATITUDE_DEGREES_2 = "#second_point .latitudeDegrees.form-control";
	private static final String SELECTOR_LATITUDE_MINUTES_2 = "#second_point .latitudeMinutes.form-control";
	private static final String SELECTOR_LATITUDE_SECONDS_2 = "#second_point .latitudeSeconds.form-control";
	private static final String SELECTOR_LONGITUDE_DEGREES_2 = "#second_point .longitudeDegrees.form-control";
	private static final String SELECTOR_LONGITUDE_MINUTES_2 = "#second_point .longitudeMinutes.form-control";
	private static final String SELECTOR_LONGITUDE_SECONDS_2 = "#second_point .longitudeSeconds.form-control";
	
	private WebElement searchByAreaLatitudeDegrees1;
	private WebElement searchByAreaLatitudeMinutes1;
	private WebElement searchByAreaLatitudeSeconds1;
	private WebElement searchByAreaLongitudeDegrees1;
	private WebElement searchByAreaLongitudeMinutes1;
	private WebElement searchByAreaLongitudeSeconds1;
	private WebElement searchByAreaLatitudeDegrees2;
	private WebElement searchByAreaLatitudeMinutes2;
	private WebElement searchByAreaLatitudeSeconds2;
	private WebElement searchByAreaLongitudeDegrees2;
	private WebElement searchByAreaLongitudeMinutes2;
	private WebElement searchByAreaLongitudeSeconds2;

	public SearchByAreaComponent(WebDriver driver) {
		searchByAreaLatitudeDegrees1 = driver.findElement(By.cssSelector(SELECTOR_LATITUDE_DEGREES_1));
		searchByAreaLatitudeMinutes1 = driver.findElement(By.cssSelector(SELECTOR_LATITUDE_MINUTES_1));
		searchByAreaLatitudeSeconds1 = driver.findElement(By.cssSelector(SELECTOR_LATITUDE_SECONDS_1));
		searchByAreaLongitudeDegrees1 = driver
				.findElement(By.cssSelector(SELECTOR_LONGITUDE_DEGREES_1));
		searchByAreaLongitudeMinutes1 = driver
				.findElement(By.cssSelector(SELECTOR_LONGITUDE_MINUTES_1));
		searchByAreaLongitudeSeconds1 = driver
				.findElement(By.cssSelector(SELECTOR_LONGITUDE_SECONDS_1));
		searchByAreaLatitudeDegrees2 = driver
				.findElement(By.cssSelector(SELECTOR_LATITUDE_DEGREES_2));
		searchByAreaLatitudeMinutes2 = driver
				.findElement(By.cssSelector(SELECTOR_LATITUDE_MINUTES_2));
		searchByAreaLatitudeSeconds2 = driver
				.findElement(By.cssSelector(SELECTOR_LATITUDE_SECONDS_2));
		searchByAreaLongitudeDegrees2 = driver
				.findElement(By.cssSelector(SELECTOR_LONGITUDE_DEGREES_2));
		searchByAreaLongitudeMinutes2 = driver
				.findElement(By.cssSelector(SELECTOR_LONGITUDE_MINUTES_2));
		searchByAreaLongitudeSeconds2 = driver
				.findElement(By.cssSelector(SELECTOR_LONGITUDE_SECONDS_2));
	}

	public WebElement getSearchByAreaLatitudeDegrees1() {
		return searchByAreaLatitudeDegrees1;
	}

	public WebElement getSearchByAreaLatitudeMinutes1() {
		return searchByAreaLatitudeMinutes1;
	}

	public WebElement getSearchByAreaLatitudeSeconds1() {
		return searchByAreaLatitudeSeconds1;
	}

	public WebElement getSearchByAreaLongitudeDegrees1() {
		return searchByAreaLongitudeDegrees1;
	}

	public WebElement getSearchByAreaLongitudeMinutes1() {
		return searchByAreaLongitudeMinutes1;
	}

	public WebElement getSearchByAreaLongitudeSeconds1() {
		return searchByAreaLongitudeSeconds1;
	}

	public WebElement getSearchByAreaLatitudeDegrees2() {
		return searchByAreaLatitudeDegrees2;
	}

	public WebElement getSearchByAreaLatitudeMinutes2() {
		return searchByAreaLatitudeMinutes2;
	}

	public WebElement getSearchByAreaLatitudeSeconds2() {
		return searchByAreaLatitudeSeconds2;
	}

	public WebElement getSearchByAreaLongitudeDegrees2() {
		return searchByAreaLongitudeDegrees2;
	}

	public WebElement getSearchByAreaLongitudeMinutes2() {
		return searchByAreaLongitudeMinutes2;
	}

	public WebElement getSearchByAreaLongitudeSeconds2() {
		return searchByAreaLongitudeSeconds2;
	}

	public SearchByAreaComponent putAreaSearchCoordinate(int latitudeDegrees1, int latitudeMinutes1,
			double latitudeSeconds1, int longitudeDegrees1, int longitudeMinutes1, double longitudeSeconds1,
			int latitudeDegrees2, int latitudeMinutes2, double latitudeSeconds2, int longitudeDegrees2,
			int longitudeMinutes2, double longitudeSeconds2) {

		getSearchByAreaLatitudeDegrees1().clear();
		getSearchByAreaLatitudeDegrees1().sendKeys(Integer.toString(latitudeDegrees1));
		getSearchByAreaLatitudeMinutes1().clear();
		getSearchByAreaLatitudeMinutes1().sendKeys(Integer.toString(latitudeMinutes1));
		getSearchByAreaLatitudeSeconds1().clear();
		getSearchByAreaLatitudeSeconds1().sendKeys(Double.toString(latitudeSeconds1));
		getSearchByAreaLongitudeDegrees1().clear();
		getSearchByAreaLongitudeDegrees1().sendKeys(Integer.toString(longitudeDegrees1));
		getSearchByAreaLongitudeMinutes1().clear();
		getSearchByAreaLongitudeMinutes1().sendKeys(Integer.toString(longitudeMinutes1));
		getSearchByAreaLongitudeSeconds1().clear();
		getSearchByAreaLongitudeSeconds1().sendKeys(Double.toString(longitudeSeconds1));

		getSearchByAreaLatitudeDegrees2().clear();
		getSearchByAreaLatitudeDegrees2().sendKeys(Integer.toString(latitudeDegrees2));
		getSearchByAreaLatitudeMinutes2().clear();
		getSearchByAreaLatitudeMinutes2().sendKeys(Integer.toString(latitudeMinutes2));
		getSearchByAreaLatitudeSeconds2().clear();
		getSearchByAreaLatitudeSeconds2().sendKeys(Double.toString(latitudeSeconds2));
		getSearchByAreaLongitudeDegrees2().clear();
		getSearchByAreaLongitudeDegrees2().sendKeys(Integer.toString(longitudeDegrees2));
		getSearchByAreaLongitudeMinutes2().clear();
		getSearchByAreaLongitudeMinutes2().sendKeys(Integer.toString(longitudeMinutes2));
		getSearchByAreaLongitudeSeconds2().clear();
		getSearchByAreaLongitudeSeconds2().sendKeys(Double.toString(longitudeSeconds2));
		return this;
	}
}
