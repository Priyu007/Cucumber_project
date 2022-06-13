package com.org.adactin.stepdefinition;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.adactin.helper.FileReaderManager;
import com.org.adactin.pom.LoginPage;
import com.org.adactin.pom.Searchpage;
import com.org.adactin.runner.Runner;
import com.org.automation.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class StepDefinition extends BaseClass {
	
	public static WebDriver driver = Runner.driver;
	public LoginPage lp;
	public Searchpage sp;
	
	
	@org.junit.Before
	 public void beforeHooks(Scenario scenario)
	 {
		 String name = scenario.getName();
		 System.out.println("ScenarioNmae :"+name);
	 }
	
	 @After
	 public void afterHooks(Scenario scenario) throws InterruptedException 
	 {
		 io.cucumber.java.Status status = scenario.getStatus();
		 System.out.println(" Scenario Status : "+status);
		 if (scenario.isFailed())
		 {
			 
			 screenshot(scenario.getName());
		 }
	 }

	
	@Given("^User launched the adactin application$")
	public void user_launched_the_adactin_application() throws Throwable {
		//driver = browsersetup();
		lp=new LoginPage(driver);
		//geturl("http://adactinhotelapp.com/");
		String url = FileReaderManager.getInstance().getcrInstance().geturl();
		geturl(url);
	}
	

	
	@When("user enter the below value as data for login")
	public void user_enter_the_below_value_as_data_for_login(io.cucumber.datatable.DataTable dataTable) {
	List<Map<String, String>> asMaps = dataTable.asMaps(String.class,String.class);
	String username = asMaps.get(0).get("username");
	String password = asMaps.get(0).get("password");
	 lp = new LoginPage(driver);
	 inputkey(lp.getName(), username);
	 inputkey(lp.getPswd(), password);
	
	}

//	@When("i give {int} as my input")
//	public void i_give_as_my_input(Integer value) {
//		System.out.println("the given value is "+value);
//	}
//	
	
//	@When("User enter {string} the username")
//	public void user_enter_the_username(String string) {
//		LoginPage lp = new LoginPage(driver);
//		inputkey(lp.getName(), string);
//	    
//	}
//	@When("User enter {string} the password")
//	public void user_enter_the_password(String string) {
//		LoginPage lp = new LoginPage(driver);
//		inputkey(lp.getPswd(), string);
//	   
//	}	
	
//	@When("^User enter the username$")
//	public void user_enter_the_username() throws Throwable {
//		inputkey(lp.getName(), "priyu7895");
//		}
//
//	@When("^User enter the password$")
//	public void user_enter_the_password() throws Throwable {
//	inputkey(lp.getPswd(), "priyanka7895");
//	}

	@Then("^User validate the username and password$")
	public void user_validate_the_username_and_password() throws Throwable {
	clickonelement(lp.getLogin());
	}
	
	@When("User select the location")
	public void user_select_the_location() {
		sp = new Searchpage(driver);
		dropdown(sp.getLocation(), "byValue", "London");
	}

	@When("User select the hotel")
	public void user_select_the_hotel() {
		dropdown(sp.getHotels(), "byValue", "Hotel Sunshine");
	}

	@When("User select the Roomtype")
	public void user_select_the_roomtype() {
		dropdown(sp.getRoomtype(), "byValue", "Super Deluxe");
	}

	@When("User select the NumberofRooms")
	public void user_select_the_numberof_rooms() {
		dropdown(sp.getNoofrooms(), "byValue", "1");
	}

	@When("User select the Checkindate")
	public void user_select_the_checkindate() {
		clearoption(sp.getCheckindate());
	   inputkey(sp.getCheckindate(), "01/06/2022");
	}

	@When("User select the Checkoutdate")
	public void user_select_the_checkoutdate() { 
		clearoption(sp.getCheckoutdate());
		   inputkey(sp.getCheckoutdate(), "05/06/2022");
	}

	@When("User select the Adultsperroom")
	public void user_select_the_adultsperroom() {
	   dropdown(sp.getAdultperroom(), "byValue", "2");
	}

	@When("User select the Childperroom")
	public void user_select_the_childperroom() {
	    dropdown(sp.getChildperroom(), "byValue", "0");
	}

	@And("User click the search button to search hotel details")
	public void user_click_the_search_button_to_search_hotel_details() {
		clickonelement(sp.getSearch());
		
	}

	@Then("User validate the search Hotel page.")
	public void user_validate_the_search_hotel_page() {
	   String s = "Adactin.com - Select Hotel";
	   String title = driver.getTitle();
	   if (s.equalsIgnoreCase(title)) {
		System.out.println("Validated");
	}
	   else {
		System.out.println("invalid");
	}
	}


}
