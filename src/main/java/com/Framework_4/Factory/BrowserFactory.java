package com.Framework_4.Factory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	static WebDriver driver;
	public static WebDriver StartBrowser(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("Chrome")||BrowserName.equalsIgnoreCase("Google Chrome")||BrowserName.equalsIgnoreCase("GC"))
		{
			WebDriverManager.chromiumdriver().setup();
			ChromeOptions opt = new ChromeOptions();

			opt.setAcceptInsecureCerts(true);

			Map<String, Object> myMap = new HashMap<String, Object>();

			myMap.put("download.default_directory", System.getProperty("user.dir") + "/downloads/");

			opt.setExperimentalOption("prefs", myMap);

			driver = new ChromeDriver(opt);
		}
		else if(BrowserName.equalsIgnoreCase("Firefox")||BrowserName.equalsIgnoreCase("FF")||BrowserName.equalsIgnoreCase("Mozilla Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions opt = new FirefoxOptions();

			opt.setAcceptInsecureCerts(true);

			driver = new FirefoxDriver(opt);
		}
		else if(BrowserName.equalsIgnoreCase("Edge")||BrowserName.equalsIgnoreCase("Microsoft Edge"))
		{
			WebDriverManager.edgedriver().setup();

			EdgeOptions opt = new EdgeOptions();

			opt.setAcceptInsecureCerts(true);

			driver = new EdgeDriver(opt);
		}
		else {
			System.out.println("Sorry we do not support this browser");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		
		return driver;

	}
}
