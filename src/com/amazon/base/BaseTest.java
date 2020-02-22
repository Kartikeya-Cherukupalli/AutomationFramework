package com.amazon.base;

import java.io.File;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.amazon.utilities.DriverManager;
import com.amazon.utilities.JSONReaderUtility;
import com.amazon.utilities.LoggerUtility;
import com.amazon.utilities.XmlParserUtility;

public class BaseTest {
		
	
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void Setup(@Optional String browser, @Optional String url)
	{
		String callingClassName = this.getClass().getName();
		LaunchDriver(browser, url);
		JSONReaderUtility.SetJSONFile(new File(System.getProperty("user.dir")+"//src//com//amazon//objectrepository//JSONOR.json"));
		XmlParserUtility.SetFileName(System.getProperty("user.dir")+"//src//com//amazon//objectrepository//ObjectRepository.xml");
		LoggerUtility.SetLogger(callingClassName);
		DriverManager.GetDriver().get(url);
	}
	
	//sets the driver and starts the same
	public void LaunchDriver(String browser, String url)
	{
		DriverManager.StartDriver(browser, url);
	}	
	
	//Tear down the driver after the execution is completed
	@AfterMethod
	public void TearDown()
	{
		DriverManager.CloseDriver();
	}
	
	
}
