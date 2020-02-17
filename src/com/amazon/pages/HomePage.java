package com.amazon.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.amazon.base.BasePage;
import com.amazon.utilities.LoggerUtility;

//CLass to handle the home page actions
public class HomePage extends BasePage<Object> {
		
	private By _dealsLink = By.linkText(FindLocatorUsingXml("Pages.Header.deals.link"));
	private By _giftsLink= By.linkText(FindLocatorUsingXml("Pages.Header.giftIdeas.link"));
	
	public HomePage() throws IOException
	{}
		
	//Return an instance of the Open Page
	@SuppressWarnings("unchecked")
	public HomePage OpenPage()
	{
		return (HomePage)GetInstance(HomePage.class);
	}
	
	//Click the Deals link and return an instance of the Deals Page
	@SuppressWarnings("unchecked")
	public DealsPage ClickDealsLink() throws Exception
	{
	
		if(_dealsLink!= null)
		{
		LoggerUtility.logger().info("Trying to click on Deals link");
		Click(_dealsLink);
		LoggerUtility.logger().info("Successfully clicked on Deals link");
		return (DealsPage)GetInstance(DealsPage.class);
		}
		else
		{
			LoggerUtility.logger().error("Unable to read the locator for dealslink");
			throw new Exception();
		}
		
		
	}	

	//Click the Gift Cards Link and return an instance of the Gift Cards Page
	@SuppressWarnings("unchecked")
	public GiftsPage ClickGiftsLink() throws Exception
	{
		if(_giftsLink!=null)
		{
		LoggerUtility.logger().info("Trying to click on Gift Cards Link");
		Click(_giftsLink);		
		LoggerUtility.logger().info("Successfully clicked on Gift Cards Link");
		return (GiftsPage)GetInstance(GiftsPage.class);
		}
		else
		{
		LoggerUtility.logger().error("Unable to read the locator for dealslink");
		throw new Exception();
		}
	}
	
	//Expected Condition to validate the loading of the page
	@Override
	public ExpectedCondition<?> GetPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOfElementLocated(_dealsLink);
	}

}
