package com.amazon.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.amazon.base.BasePage;
import com.amazon.utilities.LoggerUtility;

public class DealsPage extends BasePage<Object>{
	
	private By _pageHeader= By.xpath(FindLocator("Pages.DealsPage.Header.xpath"));
	private By _dealOfDayLink = By.linkText(FindLocator("Pages.DealsPage.DealOfDay.link"));
	private By _selectionResultsLink = By.xpath(FindLocator("Pages.DealsPage.SelectionResults.xpath"));
	private By _allDealsLocator = By.xpath(FindLocator("Pages.DealsPage.AllDeals.xpath"));
	private By _searchBoxLocator = By.xpath(FindLocator("Pages.DealsPage.SearchBox.xpath"));
	private By _searchButton = By.xpath(FindLocator("Pages.DealsPage.SearchButton.xpath"));

	//Class to handle deals page actions
	public DealsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
		
	@Override
	public ExpectedCondition<?> GetPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOfElementLocated(_pageHeader);
	}
	
	public void ClickAllDealsLink() throws Exception
	{
		if(_allDealsLocator!= null)
		{
			Click(_allDealsLocator);
		}
		else
		{
			LoggerUtility.logger().error("Locator returned as null for allDealsLocator");
			throw new Exception();
		}
		
	}
	
	public void ClickDealOfDay() throws Exception
	{
		if(_dealOfDayLink!= null)
		{
			//LoggerUtility.logger().info("Clicking on Deals of the day link");
			Click(_dealOfDayLink);
			//LoggerUtility.logger().info("Successfully clicked on deals of the day link");
		}
		else
		{
			LoggerUtility.logger().error("Locator returned as null for dealOfDayLocator");
			throw new Exception();
		}
	}
	
	
	public void ClickSearchButton() throws Exception
	{
		if(_searchButton!= null)
		{
			//LoggerUtility.logger().info("Clicking on Search button");
			Click(_searchButton);
			//LoggerUtility.logger().info("Successfully Clicked on Search button");
		}
		else
		{
			LoggerUtility.logger().error("Locator returned as null for searchButton");
			throw new Exception();
		}
	}
	
	public String SelectionResultsText() throws Exception
	{
		if(_selectionResultsLink!= null)
		{
			//LoggerUtility.logger().info("Fetching text from search results");
			return GetText(_selectionResultsLink);			
		}
		else
		{
			LoggerUtility.logger().error("Locator returned as null for allDealsLocator");
			throw new Exception();
		}
		
	}
	
	public void EnterTextInSearchBoxLink(String text) throws Exception
	{
		if(_searchBoxLocator!= null)
		{
			//LoggerUtility.logger().info("Entering text in the search box");
			TypeText(_searchBoxLocator, text);
			//LoggerUtility.logger().info("Successfully entered text in the search box");
		}
		else
		{
			LoggerUtility.logger().error("Locator returned as null for searchBoxLocator");
			throw new Exception();
		}
		
	}
}
