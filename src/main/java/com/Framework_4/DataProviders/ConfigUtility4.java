package com.Framework_4.DataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility4 {
	
	static Properties pro;
	
	public static String getDataFromConfigFile(String value)
	{
		createProInstance();
		return pro.getProperty(value);
	}
	public static void createProInstance()
	{
		if(pro==null)
		{
		pro=new Properties();
		try {
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Configuration_4/Config.Properties")));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Could not find the file " +e.getMessage());
		}
		catch (IOException e) {
			System.out.println("File not loaded" +e.getMessage());
		}
		}
		else
		{
			System.out.println("Propery file is already loaded. Using the same");
		}
	}

}
