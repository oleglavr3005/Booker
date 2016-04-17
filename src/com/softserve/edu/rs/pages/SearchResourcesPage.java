package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResourcesPage extends RegistratorCommonPage {

	private WebElement searchByCoordinate;
	private WebElement searchByArea;
	private WebElement searchByParameters;
	private WebElement btnSearch;
	private WebElement btnSearchArea;
	private WebElement btnShowAll;
	private SearchResultsTable searchResultsTable;
	private WebElement searchResultDiv;
	private SearchByAreaComponent searchByAreaComponent;
	private SearchByParametersComponent searchByParametersComponent;
	private SearchByPointComponent searchByPointComponent;
	private JavascriptExecutor jsExecutor;
	
	
	public SearchResultsTable getSearchResultsTable() {

		return searchResultsTable;
	}

	

	public SearchByPointComponent getSearchByPointComponent() {
		return searchByPointComponent;
	}

	public SearchByAreaComponent getSearchByAreaComponent() {
		return searchByAreaComponent;
	}

	public SearchByParametersComponent getSearchByParametersComponent() {
		return searchByParametersComponent;
	}

	

	public SearchResourcesPage(WebDriver driver) {
		super(driver);
		searchByPointComponent = new SearchByPointComponent(driver);
		searchByAreaComponent = new SearchByAreaComponent(driver);
		searchByParametersComponent = new SearchByParametersComponent(driver);
		searchByCoordinate = driver.findElement(By.id("searchByPointButton"));
		searchByArea = driver.findElement(By.id("searchByAreaButton"));
		searchByParameters = driver.findElement(By.id("searchByParameterButton"));
		btnSearch = driver.findElement(By.id("searchOnMapButton"));
		btnSearchArea = driver.findElement(By.id("searchOnMapButton_area"));
		btnShowAll = driver.findElement(By.id("showAllResources"));
		jsExecutor = (JavascriptExecutor) driver;

	}

	public WebElement getSearchByCoordinate() {
		return searchByCoordinate;
	}

	public WebElement getSearchByArea() {
		return searchByArea;
	}

	public WebElement getSearchByParameters() {
		return searchByParameters;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getBtnSearchArea() {
		return btnSearchArea;
	}

	public WebElement getBtnShowAll() {
		return btnShowAll;
	}

	public JavascriptExecutor getJsExecutor() {
		return jsExecutor;
	}

	public SearchResourcesPage clickSearchByCoordinate() {
		getSearchByCoordinate().click();
		return this;
	}

	public SearchResourcesPage clickSearchByArea() {
		getSearchByArea().click();
		return this;
	}

	public SearchResourcesPage clickSearchByParameters() {
		getSearchByParameters().click();
		return this;
	}

	public SearchResourcesPage clickSearchButton() {
		getBtnSearch().click();
		return this;
	}

	public SearchResourcesPage clickSearchAreaButton() {
		getBtnSearchArea().click();
		return this;
	}

	public WebElement getSearchResultDiv() {
		return searchResultDiv;
	}

	public SearchResourcesPage initElementsAfterSuccessfulSearch() {
		searchResultsTable = new SearchResultsTable(driver);
		return this;
	}

	public SearchResourcesPage initElementsAfterUnsuccessfulSearch() {
		searchResultDiv = driver.findElement(By.id("searchResult"));
		return this;
	}

	public RegistratorHomePage gotoHomePage() {
		clickHomeItem();
		return new RegistratorHomePage(driver);
	}

	public SearchResourcesPage putPointSearchCoordinate(int latitudeDegrees, int latitudeMinutes,
			double latitudeSeconds, int longitudeDegrees, int longitudeMinutes, double longitudeSeconds) {
		searchByPointComponent.putPointSearchCoordinate(latitudeDegrees, latitudeMinutes, latitudeSeconds,
				longitudeDegrees, longitudeMinutes, longitudeSeconds);

		return this;
	}

	public SearchResourcesPage putAreaSearchCoordinate(int latitudeDegrees1, int latitudeMinutes1,
			double latitudeSeconds1, int longitudeDegrees1, int longitudeMinutes1, double longitudeSeconds1,
			int latitudeDegrees2, int latitudeMinutes2, double latitudeSeconds2, int longitudeDegrees2,
			int longitudeMinutes2, double longitudeSeconds2) {
		searchByAreaComponent.putAreaSearchCoordinate(latitudeDegrees1, latitudeMinutes1, latitudeSeconds1,
				longitudeDegrees1, longitudeMinutes1, longitudeSeconds1, latitudeDegrees2, latitudeMinutes2,
				latitudeSeconds2, longitudeDegrees2, longitudeMinutes2, longitudeSeconds2);
		return this;
	}

}
