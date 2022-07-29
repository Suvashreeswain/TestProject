package com.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;

public class InitData {
	public static String empDataFile = EmpDataFile();
	public static String platformName = PlatformName();

	public static String EmpDataFile() {
		if (System.getProperty("empDataFile") == null)
			return empDataFile = "QA";
		else
			return empDataFile = System.getProperty("empDataFile");
	}


	public static String PlatformName() 
	{
		String pfName = System.getProperty("platformValue");
		if(System.getProperty("platformName")==null)
			return platformName = "chrome" ;
		

	 else
			return platformName = System.getProperty("platformName");
	}
}