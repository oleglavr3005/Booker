package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;

public final class HomePage extends CommonPage {
	//
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Business Logic
	// Functional
	
    public HomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new HomePage(driver);
    }

}
