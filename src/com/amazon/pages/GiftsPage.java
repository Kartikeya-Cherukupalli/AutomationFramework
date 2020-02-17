package com.amazon.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.amazon.base.BasePage;
import com.amazon.utilities.LoggerUtility;

//Class to handle gifts page actions
public class GiftsPage extends BasePage<Object> {
	
	public GiftsPage() throws FileNotFoundException, IOException, ParseException {
		super();
		// TODO Auto-generated constructor stub
	}

	private By _hotNewReleasesLinkLocator = By.linkText(FindLocator("Pages.GiftsPage.HotNewReleasesLink.link"));
	private By _headerElementLocator=  By.xpath(FindLocator("Pages.GiftsPage.Header.xpath"));
	
	
	
	@Override
	public ExpectedCondition<?> GetPageLoadCondition() {		
			return ExpectedConditions.visibilityOfElementLocated(_headerElementLocator);		
	}
	
	public void ClickHotNewReleases() throws Exception
	{
		if(_hotNewReleasesLinkLocator!= null)
		{
			LoggerUtility.logger().info("Clicking on Hot New Releases link");
			Click(_hotNewReleasesLinkLocator);
			LoggerUtility.logger().info("Successfully clicked on hot new releases link");
		}
		else
		{
			LoggerUtility.logger().error("Locator returned as null for hotNewReleasesLocator");
			throw new Exception();
		}	
		
	}

}
