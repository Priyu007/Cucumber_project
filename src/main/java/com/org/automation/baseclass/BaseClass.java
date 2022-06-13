package com.org.automation.baseclass;

import java.io.File;
import java.util.logging.FileHandler;

import javax.lang.model.element.Element;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	/**Url Launch **/
	
	public static void geturl(String url) {
		driver.get(url);
	}
	
	
	/** Input Value **/
	
	public static void inputkey(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	/**Click 
	 * @param element **/
	
	public static void clickonelement(WebElement element) {
		element.click();
	}
	
	/** Browser Launch 
	 * @return **/
	
	public static WebDriver browsersetup() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\bgpri\\eclipse-workspace\\Cucumber_Project\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static void dropdown (WebElement element, String options, String value) {
		Select s = new Select(element);
		if(options.equalsIgnoreCase("byIndex")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
		}
		else if (options.equalsIgnoreCase("byValue")) {
			s.selectByValue(value);
		}
		else if (options.equalsIgnoreCase("byText")) {
			s.selectByVisibleText(value);
		}
		else {
			System.out.println("Invalid Selection");
		}
	}
	
	public static void clearoption(WebElement element) {
		element.clear();
	}
	
	public static void screenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshot\\"+filename+".png");
		try {
			
			org.openqa.selenium.io.FileHandler.copy(scr, target);
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
}

