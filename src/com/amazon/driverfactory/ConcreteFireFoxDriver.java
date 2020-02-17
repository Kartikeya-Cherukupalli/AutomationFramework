package com.amazon.driverfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConcreteFireFoxDriver extends abstractDriver {
	
	private WebDriver _webDriver;
	
	public WebDriver ReturnDriver()
	{	
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//com//amazon//resources//geckodriver.exe");
		_webDriver = new FirefoxDriver();
		_webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return _webDriver;
	}

}
