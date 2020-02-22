package com.amazon.driverfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConcreteFireFoxDriver extends abstractDriver {
	
	private WebDriver _webDriver;
	
	public WebDriver ReturnDriver()
	{	
		WebDriverManager.firefoxdriver().setup();
		_webDriver = new FirefoxDriver();
		_webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return _webDriver;
	}

}
