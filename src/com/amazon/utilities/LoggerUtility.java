package com.amazon.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public final class LoggerUtility {

	static Logger logger = null;
	private static ThreadLocal<Logger> loggerInstance = new ThreadLocal<Logger>();
	static final String Log4PropertiesFile =System.getProperty("user.dir")+ "//src//com//amazon//resources//log4j.properties";
	
	
	public static Logger logger()
	{
		return loggerInstance.get();
	}
	
	public static void SetLogger(String className)
	{
		logger = Logger.getLogger(className);
		InitializeLogger();		
		loggerInstance.set(logger);
	}
	
	public static void InitializeLogger()
	{
		Properties logProperties = new Properties();
		try {
			logProperties.load(new FileInputStream(Log4PropertiesFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PropertyConfigurator.configure(logProperties);		
	}

}
