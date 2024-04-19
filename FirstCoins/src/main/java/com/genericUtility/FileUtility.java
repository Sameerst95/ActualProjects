package com.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Gokul
 */
public class FileUtility {

	/**
	 * This method is for reading the data from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {

		FileInputStream fis = new FileInputStream(IPathConstant.filePath);

		Properties prop = new Properties();
		prop.load(fis);

		return prop.getProperty(key);
	}
}
