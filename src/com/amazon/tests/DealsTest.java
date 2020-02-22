package com.amazon.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.base.BaseTest;
import com.amazon.pages.DealsPage;
import com.amazon.pages.HomePage;
import com.amazon.utilities.LoggerUtility;

public class DealsTest extends BaseTest {
		
	@Test(dataProvider= "GetData")
	public void DealsTestMethod(String searchParameter) throws InterruptedException, FileNotFoundException, IOException, ParseException
	{
		try
		{
			LoggerUtility.logger().info("Starting Deals Test Method");
			HomePage homePage = new HomePage().OpenPage();
	
			
			DealsPage dealsPage = homePage.ClickDealsLink();		
			dealsPage.ClickAllDealsLink();
			
			
			dealsPage.EnterTextInSearchBoxLink(searchParameter);
			dealsPage.ClickSearchButton();
			
			String text = dealsPage.SelectionResultsText();
			System.out.println(text);
			
			Assert.assertTrue("The provided search parameter is not being displayed in the results text "+ searchParameter,text.contains(searchParameter));
			
			Thread.sleep(2000);		
			LoggerUtility.logger().info("ending Deals Test Method");
		}
		catch(Exception e1)
		{
			Assert.fail("Exceptions received while handling the test");
		}
	
	}	
	
	
	@DataProvider(parallel=true)
	public Object[] GetData()
	{
		Object[] data = new Object[2];
		data[0]= "Appliances";
		data[1]= "Beauty";
		
		return data;
	}	
}
