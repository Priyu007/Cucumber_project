package com.org.adactin.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adactin.helper.FileReaderManager;
import com.org.automation.baseclass.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\org\\adactin\\feature", glue = "com\\org\\adactin\\stepdefinition",
				 monochrome = true,
				 dryRun = false,
				 plugin = {"html:Report/Cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class Runner {
	
	public static WebDriver driver;
		
	@BeforeClass
	public static void setup() throws IOException {
		//driver = BaseClass.browsersetup();
		String browserName = FileReaderManager.getInstance().getcrInstance().getBrowserName();
		 driver = BaseClass.browsersetup();
	}
	
	@AfterClass
	public static void teardown() {
		driver.close(); 
	}
}
