package com.amazon.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.utilities.DriverManager;
import com.amazon.utilities.JSONReaderUtility;
import com.amazon.utilities.LoggerUtility;
import com.amazon.utilities.XmlParserUtility;

//Class to handle common base actions
public abstract class BaseActions<T> {

		//Create an instance for the passed page class
		public T GetInstance(Class<T> pageClass)
		{
			T pageInstance = null;
			pageInstance = PageFactory.initElements(DriverManager.GetDriver(), pageClass);
			ExpectedCondition<?> waitCondition =((BasePage<?>) pageInstance).GetPageLoadCondition();
			waitFor(waitCondition, null);
			return pageInstance;		
		}	
		
		//Waits for the condition to be satisfied and the element be visible
		public void waitFor(ExpectedCondition<?> condition, Integer timeOutInSeconds)
		{			
			timeOutInSeconds= timeOutInSeconds != null? timeOutInSeconds : 30;
			WebDriverWait webDriverWait = new WebDriverWait(DriverManager.GetDriver(), 10);
			webDriverWait.until(condition);			
		}
		
		public abstract ExpectedCondition<?> GetPageLoadCondition();
		
		//Make multiple attempts to wait for the visibility of the Element
		private void waitFor(By byLocatorPath, Integer... timeOut)
		{
			int attempts =0;
			
			while(attempts <3)
			{
				try
				{
					waitFor(ExpectedConditions.visibilityOfElementLocated(byLocatorPath), 
							timeOut.length >0 ? timeOut[0]: null);
					break;
				}
				catch(StaleElementReferenceException e1)
				{}
				attempts++;
			}
		}
		
		//Wait for the Element to be visible and then find the Element and return the same
		private WebElement find(By byLocatorPath)
		{
			try {
			waitFor(byLocatorPath, 10);
			WebElement webElement = DriverManager.GetDriver().findElement(byLocatorPath);
			return webElement;
			}
			catch(NoSuchElementException e1)
			{
				LoggerUtility.logger().error("Element not found with the specified path:"+ byLocatorPath);
				throw e1;
			}
			catch(StaleElementReferenceException e1)
			{
				LoggerUtility.logger().error("Element no longer visible or found with the specified path:"+ byLocatorPath);
				throw e1;
			}
		}
		
		//find the element and perform click action on element specified using the byLocatorPath
		protected void Click(By byLocatorPath)
		{
			LoggerUtility.logger().info("Trying to click on element with the locator path:"+ byLocatorPath);
			find(byLocatorPath).click();
			LoggerUtility.logger().info("Successfully clicked on element with the locator path:"+ byLocatorPath);
		}
		
		//find the element and Perform Send Keys action with the provided text on the element specified using the byLocatorPath
		protected void TypeText(By byLocatorPath, String text)
		{
			LoggerUtility.logger().info("Trying to send text to element with the locator path:"+ byLocatorPath);
			find(byLocatorPath).sendKeys(text);
			LoggerUtility.logger().info("Successfully sent text to element with the locator path:"+ byLocatorPath);
		}
		
		//get the text for the webelement identified using the byLocator
		protected String GetText(By byLocatorPath)
		{
			LoggerUtility.logger().info("Trying to get text for element with the locator path:"+ byLocatorPath);
			return find(byLocatorPath).getText();
		}
		
		//Find locator using JSON Utility
		public String FindLocator(String locatorPath)
		{
			String locator = null;
			locator= JSONReaderUtility.getLocator(locatorPath);
			return locator;
		}
		
		//FInd locator using XML utility
		public String FindLocatorUsingXml(String locatorPath)
		{
			String locator = null;
			locator= XmlParserUtility.GetLocator(locatorPath);
			return locator;
		}
}
