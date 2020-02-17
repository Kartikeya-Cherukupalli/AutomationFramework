package com.amazon.utilities;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XmlParserUtility {

	private static Document doc;
	private static String fileName;
	public XmlParserUtility() {
		// TODO Auto-generated constructor stub
	}
	
	public static void SetFileName(String filePath)
	{
		fileName = filePath;
	}
	
	public static String GetLocator(String locator)
	{
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read(fileName);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data= doc.selectSingleNode("//"+locator.replace(".", "/")).getText().trim();
		return data;
	}
	

}
