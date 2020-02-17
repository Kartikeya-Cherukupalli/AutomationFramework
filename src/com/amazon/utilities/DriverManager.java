package com.amazon.utilities;

import org.openqa.selenium.WebDriver;

import com.amazon.driverfactory.InitializeDriver;
import com.amazon.driverfactory.abstractDriver;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> _webDriver = new ThreadLocal<WebDriver>();
	
	//Creates an instance of the webdriver and sets the webdriver for reuse
	public static WebDriver StartDriver(String browser, String url)
	{
		abstractDriver _abstractDriver = InitializeDriver.FetchDriverFactory(browser);
		WebDriver _driver =_abstractDriver.ReturnDriver();
		_webDriver.set(_driver);
		_webDriver.get().navigate().to(url);
		//_webDriver.get().manage().window().fullscreen();
		return _driver;
		
	}
	
	
	//Closes the web driver;
	public static void CloseDriver()
	{
		//GetDriver().close();
		GetDriver().quit();
	}	
	
	//Gets the webdriver
	public static WebDriver GetDriver()
	{
		return _webDriver.get();
	}
	
	//Sets the webdriver
	public static void SetDriver(WebDriver webDriver)
	{
		_webDriver.set(webDriver);
	}

}
