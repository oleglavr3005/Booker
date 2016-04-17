package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class RegistratorCommonPage extends CommonPage {
	public RegistratorCommonPage(WebDriver driver) {
		super(driver);
		 registratorHome=driver.findElement(By.cssSelector(".glyphicon.glyphicon-home"));
		 resourcesSearch=driver.findElement(By.cssSelector("a[href$='/searchOnMap']"));
		 objectSubclasses=driver.findElement(By.cssSelector("a[href$='/show-res-types']"));
		 procurations=driver.findElement(By.cssSelector("a[href$='#']"));
		 addNewResource=driver.findElement(By.cssSelector("a[href$='/new']"));
	}
	private WebElement registratorHome;
	private WebElement resourcesSearch;
	private WebElement objectSubclasses;
	private WebElement procurations;
	private WebElement addNewResource;
	
	public WebElement getResourcesSearch() {
		return resourcesSearch;
	}

	public WebElement getObjectSubclasses() {
		return objectSubclasses;
	}


	public WebElement getRegistratorHome() {
		return registratorHome;
	}

	public WebElement getProcurations() {
		return procurations;
	}

	public WebElement getAddNewResource() {
		return addNewResource;
	}
	
	public void clickHomeItem(){
		getRegistratorHome().click();
	}
	
	public RegistratorCommonPage clickResourceSearchItem(){
		getResourcesSearch().click();
	    return this;
	}
	
	public void clickObjectSubclassesItem(){
		getObjectSubclasses().click();
	}
	
	public void clickProcurationsItem(){
		getProcurations().click();
	}
	
	public void clickAddNewResourceItem(){
		getAddNewResource().click();
	}
	
}
