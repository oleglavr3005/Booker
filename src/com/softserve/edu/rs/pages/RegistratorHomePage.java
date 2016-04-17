package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistratorHomePage extends RegistratorCommonPage {

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
	}

	// Business Logic
	// Functional
	public SearchResourcesPage gotoResourcesSearchPage(){
		driver.findElement(By.cssSelector("a[href$='/searchOnMap']")).click();
		return new SearchResourcesPage(driver);
	}
	
    public RegistratorHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new RegistratorHomePage(driver);
    }

}
