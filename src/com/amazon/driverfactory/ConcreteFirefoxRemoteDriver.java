package com.amazon.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ConcreteFirefoxRemoteDriver extends abstractDriver {

	@Override
	public WebDriver ReturnDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setBrowserName(BrowserType.FIREFOX);
		capabilities.setPlatform(Platform.ANY);
		
		WebDriver driver= null;
		
		try {
			
			driver = new RemoteWebDriver(new URL("http://192.168.2.4:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		}
		return driver;
	}

}
