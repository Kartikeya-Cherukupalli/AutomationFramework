package com.amazon.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.amazon.base.BaseTest;
import com.amazon.pages.GiftsPage;
import com.amazon.pages.HomePage;

public class GiftsTest extends BaseTest {

	@Test
	public void GiftsTestMethod() throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		try
		{
			logger().info("Starting logger Method");
			HomePage homePage = new HomePage().OpenPage();
	
			
			GiftsPage giftsPage = homePage.ClickGiftsLink();		
			giftsPage.ClickHotNewReleases();
			
			Thread.sleep(2000);		
			logger().info("ending logger Method");	
		}
		catch(Exception e1)
		{
			Assert.fail("Exceptions received while handling the test");
		}	
	}	

}
