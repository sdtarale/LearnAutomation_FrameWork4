package com.Framework_4.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	By UserNametextbox=By.name("username");
	By Passwordtextbox=By.name("password");
	By LoginButton=By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
	
	public void loginApp(String uname, String Pwd)
	{
		driver.findElement(UserNametextbox).sendKeys(uname);
		driver.findElement(Passwordtextbox).sendKeys(Pwd);
		driver.findElement(LoginButton).click();

	}
	
/*
	public WebElement getUsernameField()
	{
		return driver.findElement(UserNametextbox);
	}
	
	public WebElement getPasswordField()
	{
		return driver.findElement(Passwordtextbox);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(LoginButton);
	}
	*/
}
