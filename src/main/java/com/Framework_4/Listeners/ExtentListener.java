package com.Framework_4.Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Framework_4.Utilities.Helpers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;

import net.bytebuddy.implementation.bytecode.Throw;

public class ExtentListener implements ITestListener{
	ExtentReports extent=ExtentManager.getInstance();
	ThreadLocal<ExtentTest>  parentTest=new ThreadLocal<ExtentTest>();
	
	public synchronized void onFinish(ITestContext context) {
		System.out.println("Log INFO: Report is getting generated");
		extent.flush();
		System.out.println("Log INFO: Report is generated");
	}
	
	
	public synchronized void onTestStart(ITestResult result) {
		System.out.println("Log INFO: Test Started");
		ExtentTest child=extent.createTest(result.getMethod().getMethodName());
		parentTest.set(child);
	}

	public synchronized void onTestSuccess(ITestResult result) {
		parentTest.get().pass("Test Passed");
		
	}


	public synchronized void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		parentTest.get().fail("Test Failed"+result.getThrowable().getMessage(),
				MediaEntityBuilder.createScreenCaptureFromBase64String(Helpers.captureScreeshotBase64(driver)).build());
		
	
	}


	public synchronized void onTestSkipped(ITestResult result) {
		parentTest.get().skip(result.getThrowable().getMessage());
	}

	

}
