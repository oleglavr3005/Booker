package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage extends CommonPage {
    //
    private WebElement listAllusers;
    private WebElement registeredUsers;

    public AdminHomePage(WebDriver driver) {
        super(driver);
        //
        this.listAllusers = driver.findElement(By.cssSelector("a.not-active"));
        this.registeredUsers = driver.findElement(By.xpath("//a[contains(@href,'/get-all-users')]"));
    }

    // Get Elements
    
    public WebElement getListAllusers() {
        return this.listAllusers;
    }

    public WebElement getRegisteredUsers() {
        return this.registeredUsers;
    }

    // Set Data
    
    public void clickListAllusers() {
    	getListAllusers().click();
    }
    
    public void clickRegisteredUsers() {
    	clickListAllusers();
    	getRegisteredUsers().click();
    }

    // Business Logic
	// Functional
	
    public AdminHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new AdminHomePage(driver);
    }

    public LoginPage logout() {
    	clickLogout();
        // Return a new page object representing the destination.
        return new LoginPage(driver);
    }
    
    public RegisteredUsersHomePage gotoRegisteredUsers() {
    	clickRegisteredUsers();
        return new RegisteredUsersHomePage(driver);
    }

}
