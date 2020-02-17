package com.amazon.utilities;

import java.io.File;
import java.io.IOException;

import com.jayway.jsonpath.JsonPath;

public class JSONReaderUtility {

	
		
		private static File jsonFile;
				
		//Gets the locator for the passed json gile		
		public static String getLocator(String locator)
		{
			String locatorString = null;
			locator = "$."+locator;			
			try {
				locatorString= JsonPath.read(jsonFile, locator);
			} catch (IOException e) {
				LoggerUtility.logger.error("Error while trying to read the locator:"+ locator+ " from the path :"+ jsonFile.getAbsolutePath() );
			}
			return locatorString;
		}
		
		public static void SetJSONFile(File filePath)
		{
			jsonFile= filePath;
		}
}
