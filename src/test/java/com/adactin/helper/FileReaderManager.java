package com.adactin.helper;

import java.io.IOException;

public class FileReaderManager {

	private FileReaderManager() {
	
	}
	
	public static FileReaderManager getInstance() {
		FileReaderManager fm = new FileReaderManager();
		return fm;
	}
	
	public ConfigurationReader getcrInstance() throws IOException {
		ConfigurationReader cr = new ConfigurationReader();
		return cr;
	}
	
	
}
