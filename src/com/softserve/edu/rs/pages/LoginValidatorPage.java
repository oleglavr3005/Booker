package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginValidatorPage extends LoginPage {
	public static final String START_VALIDATOR_MESSAGE = "You have entered wrong login or password.";
	//
	private WebElement validator;

	public LoginValidatorPage(WebDriver driver) {
		super(driver);
		this.validator = driver.findElement(By.xpath("//div[@style='color: red;']"));
	}

	// Get Elements

	public WebElement getValidator() {
		return this.validator;
	}

	public String getValidatorText() {
		return getValidator().getText();
	}

	public String getStartValidatorText() {
		return getValidatorText().substring(0, START_VALIDATOR_MESSAGE.length());
	}

}
