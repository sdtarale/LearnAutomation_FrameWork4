package com.Framework_4.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Framework_4.Base.BaseClass4;
import com.Framework_4.DataProviders.DataProviders4;
import com.Framework_4.Pages.DashBoard;
import com.Framework_4.Pages.LoginPage;

public class LoginTest_4 extends BaseClass4
{
	LoginPage login;
	DashBoard dash;
	public WebDriver driver;
	@BeforeMethod
	public void setDriver()
	{
		driver=getDriver();
	}
	@Test(description="Login Test" , dataProvider = "Login", dataProviderClass = DataProviders4.class)
	public void loginTest(String username, String password)
	{
		login=new LoginPage(driver);
		dash=new DashBoard(driver);
		login.loginApp(username, password);
		
		dash.getWelcomeButton().click();
		try
		{
			dash.getLogoutButton().click();
		}
		catch (Exception e) 
		{
			System.out.println("Failed to click logout button. Trying again");
			dash.getLogoutButton().click();
		}
		
		
	}

}
