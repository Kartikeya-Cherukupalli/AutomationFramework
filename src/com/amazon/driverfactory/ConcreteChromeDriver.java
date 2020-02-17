package com.amazon.driverfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConcreteChromeDriver extends abstractDriver{

	private WebDriver _webDriver;
	@Override
	public WebDriver ReturnDriver() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//com//amazon//resources//chromedriver.exe");
		_webDriver = new ChromeDriver();
		_webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return _webDriver;
	}

}
