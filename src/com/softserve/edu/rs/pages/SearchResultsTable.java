package com.softserve.edu.rs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsTable {
	private WebElement tableOfResults;
	private WebElement dataTextInfo;
	private WebElement paginateInfo;
	private WebDriver driver;
	
	public SearchResultsTable(WebDriver driver){
		this.driver=driver;
		tableOfResults = (new WebDriverWait(driver, 10))
	            .until(ExpectedConditions.presenceOfElementLocated(By.id("datatable")));
		dataTextInfo =  (new WebDriverWait(driver, 10))
	            .until(ExpectedConditions.presenceOfElementLocated(By.id("datatable_info")));
		paginateInfo =  (new WebDriverWait(driver, 10))
	            .until(ExpectedConditions.presenceOfElementLocated(By.id("datatable_paginate")));
	}
	
	public WebElement getTableOfResults() {
		return tableOfResults;
	}

	public WebElement getDataTextInfo() {
		return dataTextInfo;
	}

	public WebElement getPaginateInfo() {
		return paginateInfo;
	}
	public List<WebElement> getSearchResultValues() {
		return driver.findElements(By.cssSelector("tbody td"));
	}

	public List<String> getSearchResultTextValues() {
		List<WebElement> elements = driver.findElements(By.cssSelector("tbody td"));
		List<String> result = new ArrayList<>();
		elements.forEach(x -> result.add(x.getText()));

		return result;

	}

	public List<String> getSearchResultIdValues() {
		List<WebElement> elements = driver.findElements(By.cssSelector(" td:nth-child(3)"));
		List<String> result = new ArrayList<>();
		elements.forEach(x -> result.add(x.getText()));

		return result;

	}

	public List<WebElement> getSearchResultRows() {
		return driver.findElements(By.cssSelector("tbody tr"));
	}

}
