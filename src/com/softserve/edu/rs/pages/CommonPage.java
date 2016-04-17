package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class CommonPage extends TopPage {
	//protected WebDriver driver;
	//
	private WebElement loginAccount;
	private WebElement logout;

	public CommonPage(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		//
		this.loginAccount=driver.findElement(By.cssSelector("html body div.container div.row div#header.col-md-12 div#header.container-fluid div.col-md-5 div.col-md-7 div.btn-group button.btn.btn-primary.btn-sm"));
	//	this.logout=driver.findElement(By.xpath("//a[contains(@href,'/logout')]"));
		this.loginAccount.click();				
		this.logout=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[1]/div/ul/li[4]/a"));
	}

	// Get Elements
	
	public WebElement getLoginAccount() {
		return this.loginAccount;
	}
	
	public WebElement getLogout() {
		return this.logout;
	}

	public String getLoginAccountText() {
		return this.loginAccount.getText();
	}
	
	// Set Data
	
	public void clickLogout() {
		getLogout().click();
	}

}
