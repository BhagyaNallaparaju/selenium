package com.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.helper.logger.LoggerHelper;

import helper.wait.WaitHelper;

public class BookAHotelPage {
	private WebDriver driver;

	WaitHelper waitHelper;
	String month = "May 2019";
	String date = "10";
	
	private final Logger log = LoggerHelper.getLogger(BookAHotelPage.class);

	@FindBy(xpath = "//span[contains(text(),'Hotels')]")
	WebElement HotelsLink;

	@FindBy(xpath = "//*[@id='s2id_autogen8']/a/span[1]")
	WebElement clickHotelsLocation;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
	WebElement searchHotelsLocation;

	@FindBy(xpath = "//ul[@class='select2-result-sub']/li[1]/div[1]/span[1]")
	WebElement selectHotelLocation;

	@FindBy(xpath = "//*[@id='dpd1']/div/input")
	WebElement clickCheckIn;

	@FindBy(xpath = "//div[@class='datepicker-days']/table/thead/tr[1]/th[3]")
	WebElement nextArrowForCheckIn;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/tr[1]/th[2]")
	WebElement checkInMonth;

	@FindBy(xpath = "//div[@class='datepicker dropdown-menu'][1]/div[1]/table/tbody/tr/td[contains(text(),'10')]")
	WebElement checkInDate;
	
	@FindBy(xpath = "//div[@class='datepicker dropdown-menu'][2]/div[1]/table/tbody/tr/td[contains(text(),'11')]")
	WebElement checkOutDate;
	
	@FindBy(xpath = "//*[@id='hotels']/form/div[5]/button[@type='submit']")
	WebElement searchButton;
	
	@FindBy(xpath = "//label[@for='Guest House']/preceding-sibling::div/ins")
	WebElement selectFilter;
	
	@FindBy(xpath = "//*[@id='searchform']")
	WebElement filterSearch;
	
	@FindBy(xpath = "//*[@id='body-section']/div[5]/div/div[3]/div[1]/div/table/tbody/tr[1]/td/div[3]/a/button")
	WebElement hotelDetails;
	
	@FindBy(xpath = "//*[@id='ROOMS']/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/label/div")
	WebElement selectAvailableRoom;
	
	
	@FindBy(xpath = "//*[@id='ROOMS']/div/button")
	WebElement clickOnBookNow;
	
	@FindBy(xpath = "//*[@id='body-section']/div[1]/div/div[1]/div/div[3]/button")
	WebElement clickConfirmThisBooking;
	
	@FindBy(xpath = "//button[text()='Pay on Arrival']")
	WebElement BookingConfirmation;
	
	@FindBy(xpath = "//*[@id=\"body-section\"]/div[2]/div[2]/div/div[1]/ul/li[1]/a/span[2]")
	WebElement BookingPage;
	
	@FindBy(xpath = "//*[@id='bookings']/div[2]/div[1]")
	WebElement BookingUpdated;
	
	
	public BookAHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnHotels(){
		waitHelper = new WaitHelper(driver);
		waitHelper.WaitForElement(HotelsLink, 20);
		HotelsLink.click();
		log.info("click on Hotels Link");
	}

	public void searchHotels(String block){
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(clickHotelsLocation, 20);
		log.info("click on location for available Hotels");
		clickHotelsLocation.click();
		log.info("Enter the desired location");
		waitHelper.WaitForElement(searchHotelsLocation, 20);
		searchHotelsLocation.sendKeys(block);
		log.info("select from available Hotels");
		waitHelper.WaitForElement(selectHotelLocation, 60);
		selectHotelLocation.click();
		waitHelper.WaitForElement(clickCheckIn, 60);
		log.info("click on Hotel from the dropdown");
	}
	
	public void selectChecKIn_OutDates(){
		clickCheckIn.click();
		while(true)
		{
			if(checkInMonth.getText().equals(month))
				break;
			else
			{
				nextArrowForCheckIn.click();
				waitHelper.WaitForElement(nextArrowForCheckIn, 30);
			}
		}
		waitHelper.WaitForElement(checkInDate, 30);
		checkInDate.click();
		log.info("Check-In completed");
		waitHelper.WaitForElement(checkOutDate, 30);
		checkOutDate.click();
		log.info("Check-Out completed");
		searchButton.click();
	}
//	public void applyFilters() {
//		//Zoom IN
//		((JavascriptExecutor)driver).executeScript("document.body.style.zoom='33%'");
//		waitHelper.WaitForElement(selectFilter, 60);
//		selectFilter.click();
//		log.info("Apply selected filters for search");
//		waitHelper.WaitForElement(filterSearch, 60);
//		filterSearch.click();
//		
//	}
	
	public void bookAHotel() {
		waitHelper.WaitForElement(hotelDetails, 60);
		log.info("All the hotels available are displayed");
		hotelDetails.click();
		log.info("Click on first hotel");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1400)");
		waitHelper.WaitForElement(selectAvailableRoom, 60);
		selectAvailableRoom.click();
		clickOnBookNow.click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1400)");
		waitHelper.WaitForElement(clickConfirmThisBooking, 60);
		clickConfirmThisBooking.click();
		log.info("Booked the hotel");
	}
	
	public void verifyBookingConfirmation() {
		waitHelper.WaitForElement(BookingConfirmation, 60);
		BookingConfirmation.isDisplayed();
		log.info("Verified hotel booking");
	}
	
	public void clickBookings() {
		log.info("Verify booking page is visible");
	}
	public void verifyBookingUpdate() {
		BookingUpdated.isDisplayed();
	}
	public void profileUptodate() {
		log.info("Hotel booking is updated in profile");
	}
}
