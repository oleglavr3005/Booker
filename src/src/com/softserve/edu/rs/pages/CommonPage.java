package src.com.softserve.edu.rs.pages;

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
		this.loginAccount=driver.findElement(By.cssSelector(".col-md-7 label"));
		this.logout=driver.findElement(By.xpath("//a[contains(@href,'/logout')]"));
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
