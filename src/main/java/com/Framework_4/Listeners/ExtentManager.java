package com.Framework_4.Listeners;

import java.io.File;

import com.Framework_4.Utilities.Helpers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	static ExtentReports extent;
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			return createExtentInstance();
		}
		else
		{
			return extent;
		}
	}
	public static ExtentReports createExtentInstance()
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports_4/AutomationReport"+ Helpers.getCurrentDateTime()+ ".html"));
		reporter.config().setDocumentTitle("Framework4 Report");
		reporter.config().setReportName("Automation Test");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
				
	}
}
