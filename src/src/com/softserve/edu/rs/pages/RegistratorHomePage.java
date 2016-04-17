package src.com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;

public class RegistratorHomePage extends CommonPage {

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
	}

	// Business Logic
	// Functional
	
    public RegistratorHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new RegistratorHomePage(driver);
    }

}
