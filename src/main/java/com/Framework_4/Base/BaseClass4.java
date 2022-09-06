package com.Framework_4.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Framework_4.DataProviders.ConfigUtility4;
import com.Framework_4.Factory.BrowserFactory;

public class BaseClass4 {
	
	static WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.StartBrowser(ConfigUtility4.getDataFromConfigFile("Browser"));
		driver.get(ConfigUtility4.getDataFromConfigFile("QA_URL"));
	}
	
	@AfterClass(description="Tear Down")
	public void tearDown()
	{
		driver.quit();
	}
}
