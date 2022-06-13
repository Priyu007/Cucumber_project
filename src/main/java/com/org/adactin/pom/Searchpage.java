package com.org.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {
	
	public static WebDriver driver;
	
	@FindBy(name = "location")
	private WebElement location;
	
	@FindBy(name = "hotels")
	private WebElement hotels;
	
	@FindBy(name = "room_type")
	private WebElement roomtype;
	
	@FindBy(id = "room_nos")
	private WebElement noofrooms;
	
	@FindBy(name = "datepick_in")
	private WebElement checkindate;
	
	@FindBy(name = "datepick_out")
	private WebElement checkoutdate;
	
	@FindBy(name = "adult_room")
	private WebElement adultperroom;
	
	@FindBy(name = "child_room")
	private WebElement childperroom;
	
	@FindBy(id = "Submit")
	private WebElement search;

	public Searchpage(WebDriver driver3) {
		this.driver = driver3;
		PageFactory.initElements(driver3, this);
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomtype() {
		return roomtype;
	}

	public WebElement getNoofrooms() {
		return noofrooms;
	}

	public WebElement getCheckindate() {
		return checkindate;
	}

	public WebElement getCheckoutdate() {
		return checkoutdate;
	}

	public WebElement getAdultperroom() {
		return adultperroom;
	}

	public WebElement getChildperroom() {
		return childperroom;
	}

	public WebElement getSearch() {
		return search;
	}

}
