package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchByParametersComponent implements ISearchable {
	private static final String SELECTOR_INPUT_PERIMETER="div[param_id='1'] .form-control.value";
	private static final String SELECTOR_INPUT_AREA="div[param_id='2'] .form-control.value";
	private Select listObjectSubclasses;
	private WebElement inputPerimeter;
	private WebElement inputArea;
	
	public SearchByParametersComponent(WebDriver driver) {
		listObjectSubclasses = new Select(driver.findElement(By.id("resourcesTypeSelect")));
		inputPerimeter = driver.findElement(By.cssSelector(SELECTOR_INPUT_PERIMETER));
		inputArea = driver.findElement(By.cssSelector(SELECTOR_INPUT_AREA));
	}
	public Select getListObjectSubclasses() {
		return listObjectSubclasses;
	}

	public WebElement getInputPerimeter() {
		return inputPerimeter;
	}

	public WebElement getInputArea() {
		return inputArea;
	}
}
