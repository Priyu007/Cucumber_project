package com.adactin.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	
	public static Properties ps;
	public ConfigurationReader() throws IOException {

	File f = new File("src\\test\\java\\com\\adactin\\helper\\Adactin.property");
	FileInputStream fis = new FileInputStream(f);
	 ps = new Properties();
	ps.load(fis);
		
}
	public String getBrowserName() {
		String browsername = ps.getProperty("BrowserName");
		return browsername;
	}
	
	public String geturl() {
		String url = ps.getProperty("Url");
		return url;
	}
	
	
}