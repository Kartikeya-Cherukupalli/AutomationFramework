package com.amazon.driverfactory;

public class InitializeDriver {
	
	public static abstractDriver FetchDriverFactory(String browser)
	{
		switch(browser)
		{
		case "chrome":
			return new ConcreteChromeDriver();
		case "chromeRemote":
			return new ConcreteChromeRemoteDriver();
		case "firefoxRemote":
			return new ConcreteFirefoxRemoteDriver();
		case "firefox":
			return new ConcreteFireFoxDriver();		
		default:
			return new ConcreteChromeDriver();
		}
	}
}
