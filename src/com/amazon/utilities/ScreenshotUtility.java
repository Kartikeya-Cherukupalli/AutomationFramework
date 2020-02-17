package com.amazon.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class ScreenshotUtility {

	public ScreenshotUtility() {
		// TODO Auto-generated constructor stub
	}
	
	public static void TakeScreenShot(ITestResult testResult)
	{
		
		TakesScreenshot takeScreenShot = ((TakesScreenshot)DriverManager.GetDriver());
		File screenShotFile = takeScreenShot.getScreenshotAs(OutputType.FILE);	
		
		 DateFormat df = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
	       Date dateobj = new Date();
	       System.out.println(df.format(dateobj));
		
		String filePath = System.getProperty("user.dir")+"//test-output//"+testResult.getName()+"_"+df.format(dateobj)+".jpg";
		try {
			FileUtils.copyFile(screenShotFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
