package com.Framework_4.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoard {

	WebDriver driver;
	
	public DashBoard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By WelcomeButton=By.className("oxd-userdropdown-tab");
	By LogoutButton=By.linkText("Logout");
	
	public WebElement getWelcomeButton()
	{
		return driver.findElement(WelcomeButton);
	}
	public WebElement getLogoutButton()
	{
		return driver.findElement(LogoutButton);
	}
	
}
