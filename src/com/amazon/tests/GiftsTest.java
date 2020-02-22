package com.amazon.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.amazon.base.BaseTest;
import com.amazon.pages.GiftsPage;
import com.amazon.pages.HomePage;
import com.amazon.utilities.LoggerUtility;

public class GiftsTest extends BaseTest {

	@Test
	public void GiftsTestMethod()
	{
		try
		{
			LoggerUtility.logger().info("Starting Gifts Test Method");
			HomePage homePage = new HomePage().OpenPage();
	
			
			GiftsPage giftsPage = homePage.ClickGiftsLink();		
			giftsPage.ClickHotNewReleases();
			
			Thread.sleep(2000);		
			LoggerUtility.logger().info("ending Gifts Test Method");	
		}
		catch(Exception e1)
		{
			Assert.fail("Exceptions received while handling the test");
		}	
	}	

}
