package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public static String getConfig(String key) throws IOException {
		
		Properties properties = new Properties();	
		
		File file = new File("config.properties");
		FileInputStream fileInputStram = new FileInputStream(file);
		properties.load(fileInputStram);		
		return properties.getProperty(key);
	}
}
