package com.Framework_4.DataProviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders4 {

	@DataProvider(name="Login")
	public Object[][] getLoginData() throws IOException
	{
		return ExcelUtility4.getDataFromExcel("Login_Data");
	}
	@DataProvider(name="AddUser")
	public Object[][] getUserData() throws IOException
	{
		return ExcelUtility4.getDataFromExcel("User");
	}
	
}
