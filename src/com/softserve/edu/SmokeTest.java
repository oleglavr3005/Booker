package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {

	@Test
	public void adminLogin() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/resources/login");
		//driver.get("http://java.training.local:8080/registrator/login");
		//driver.get("http://registrator.herokuapp.com/login");
		//
		WebElement login = driver.findElement(By.id("login"));
		login.clear();
		login.sendKeys("admin_hahaha");
		Thread.sleep(2000);
		//driver.navigate().refresh();
		login.clear();
		login.sendKeys("admin");
		// driver.findElement(By.id("login")).clear();
		// driver.findElement(By.id("login")).sendKeys("admin");
		//
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		//
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		// driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		//
		// WebElement userLogin = driver.findElement(By.cssSelector("label"));
		WebElement userLogin = driver.findElement(By.cssSelector(".col-md-7 label"));
		Assert.assertEquals(userLogin.getText(), "admin");
		// Assert.assertEquals(driver.findElement(By.cssSelector("label")).getText(),"admin");
		//
		// driver.findElement(By.linkText("Вихід")).click();
		// driver.findElement(By.linkText("Sign out")).click();
		driver.findElement(By.cssSelector("a.btn.btn-primary.btn-sm")).click();
		//
		WebElement startLogo = driver.findElement(By.xpath("//div[@id='body']/div/img"));
		String nameLogoPath = startLogo.getAttribute("src");
		String nameLogo = nameLogoPath.substring(nameLogoPath.lastIndexOf('/') + 1);
		System.out.println("\t+++ nameLogo = " + nameLogo);
		// Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText(),"Увійти");
		Assert.assertEquals(nameLogo, "ukraine_logo.gif");
		driver.quit();
	}

}
