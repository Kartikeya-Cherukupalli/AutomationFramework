package com.amazon.base;

import java.io.IOException;

import com.amazon.utilities.JSONReaderUtility;
import com.amazon.utilities.XmlParserUtility;

//Class to handle Actions common across all the pages
@SuppressWarnings("rawtypes")
public abstract class BasePage<T> extends BaseActions {
	
	
	public BasePage() throws IOException
	{}
	
}
