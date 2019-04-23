package com.PageObject;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.helper.logger.LoggerHelper;

import helper.wait.WaitHelper;

public class MonksPalaceHotelPage {
	private WebDriver driver;
	WaitHelper waitHelper;
	String hotel_Name = "Monks palace";
	String descriptionForHotel = "Monks Palace Hotel Hilversum is located in the Arts and Heritage District, within 3 km (0.2 mi) of the Hilversum National Museum, Hilversum Art Museum, and Hilversum Management University.Specially for Monks";
	String descForHotelRoom = "Spacious Living Room with seperate bathroom";
	String locationData = "Hilv";
	String russiaTranslateHotelDesc = "Отель Monks Palace Hilversum расположен в районе искусств и наследия, в 3 км от Национального музея Хилверсюма, Художественного музея Хилверсюма и Университета Хилверсюма. Специально для монахов.";
	String hoteldes = "/html/body/p";
	String PriceText = "100";
	String minStayText = "2";
	String ExtraBedChargesText = "20";

	private final Logger log = LoggerHelper.getLogger(MonksPalaceHotelPage.class);

	@FindBy(xpath = "//form[@class='form-signin form-horizontal wow fadeIn animated animated']//input[@placeholder='Email']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//*[@id='social-sidebar-menu']/li/a/strong[contains(text(),'Dashboard')]")
	WebElement viewAdminDashBoard;

	@FindBy(xpath = "//*[@id='social-sidebar-menu']/li[7]/a")
	WebElement selectHotels;

	@FindBy(xpath = "//*[@id='Hotels']/li[1]/a")
	WebElement clickHotelsLink;

	@FindBy(xpath = "//*[@id='content']/div/form/button")
	WebElement clickAdd;

	@FindBy(xpath = "//*[@id='GENERAL']/div[3]/div/input")
	WebElement hotelName;

	@FindBy(xpath = "//*[@id='cke_1_contents']/iframe")
	WebElement iFrame;

	@FindBy(xpath = "//*[@id='s2id_searching']/a/span[1]")
	WebElement Location;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li/div")
	WebElement selectLocation;

	@FindBy(xpath = "//*[@id='select2-drop']/div/input")
	WebElement enterLocation;

	@FindBy(xpath = "//*[@id='content']/form/div/ul/li[2]/a")
	WebElement clickFacilities;

	@FindBy(xpath = "//*[text()=' Airport Transport']/div/ins")
	WebElement checkboxAirportTransport;

	@FindBy(xpath = "//*[text()=' Elevator']/div/ins")
	WebElement checkboxElevator;

	@FindBy(xpath = "//*[@id='content']/form/div/ul/li[4]/a")
	WebElement clickPolicy;

	@FindBy(xpath = "//*[@id='s2id_autogen5']")
	WebElement clickPaymentOptions;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[7]/div")
	WebElement clickPayOnArrival;

	@FindBy(xpath = "//*[@id='content']/form/div/ul/li[6]/a")
	WebElement clickTranlate;

	@FindBy(xpath = "//*[@id='TRANSLATE']/div[6]/div[2]/div[1]/div/input")
	WebElement russiaHotelName;

	@FindBy(xpath = "//*[@id='cke_7_contents']/iframe")
	WebElement iFrameRussia;

	@FindBy(xpath = "//*[@id='add']")
	WebElement clickSubmit;

	@FindBy(xpath = "//*[@id='content']/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]")
	WebElement getAddedHotel;

	@FindBy(xpath = "//*[@id='Hotels']/li[2]/a")
	WebElement clickRooms;

	@FindBy(xpath = "//*[@id='s2id_autogen1']/a/span[1]")
	WebElement clickRoomType;

	@FindBy(xpath = "//*[@id='select2-drop']/ul/li[2]/div")
	WebElement selectRoomType;

	@FindBy(xpath = "//*[@id='GENERAL']/div[6]/div/input")
	WebElement price;

	@FindBy(xpath = "//*[@id='GENERAL']/div[7]/div/input")
	WebElement quantity;

	@FindBy(xpath = "//*[@id='content']/form/div/ul/li[2]/a")
	WebElement clickAminities;

	@FindBy(xpath = "//*[@id='AMENITIES']/div/div/div[37]/label")
	WebElement selectPrivateBathRoom;

	@FindBy(xpath = "//*[@id='content']/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[4]")
	WebElement getAddedRoom;

	@FindBy(xpath = "//*[@id='GENERAL']/div[8]/div/input")
	WebElement minStay;

	@FindBy(xpath = "//*[@id='GENERAL']/div[9]/div/input")
	WebElement maxAdults;

	@FindBy(xpath = "//*[@id='GENERAL']/div[10]/div/input")
	WebElement maxChild;

	@FindBy(xpath = "//*[@id='GENERAL']/div[11]/div/input")
	WebElement noOfBeds;

	@FindBy(xpath = "//*[@id='GENERAL']/div[12]/div/input")
	WebElement extraBedCharges;

	@FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/ul/li/a")
	WebElement language;

	@FindBy(xpath = "//nav[@class='navbar navbar-default']//a[@id='ru']")
	WebElement selectRussia;

	@FindBy(xpath = "//*[@id='OVERVIEW']/div[5]/div/div/div[2]/div/div[1]/p[2]")
	WebElement textDesc;

	@FindBy(xpath = "//*[@id='body-section']/div[5]/div/div[3]/div[1]/div/table/tbody/tr[1]/td/div[3]/a/button")
	WebElement hotelDetailss;

	public MonksPalaceHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserNameAndPassword(String adminUserName, String adminPassword) {
		waitHelper = new WaitHelper(driver);
		waitHelper.WaitForElement(userName, 60);
		log.info("entering admin username...." + adminUserName);
		userName.click();
		userName.sendKeys(adminUserName);
		log.info("entering admin password...." + adminPassword);
		password.sendKeys(adminPassword);
	}

	public void clickLogInButton() {
		log.info("click LogIn Button");
		loginButton.click();
	}

	public void verifyAdminLogInSuccessful() {
		log.info("Verify Admin Page LogIn successful");
		waitHelper.WaitForElement(viewAdminDashBoard, 60);
		viewAdminDashBoard.isDisplayed();
	}

	public void clickHotelsLinkAndAddHotel() {
		log.info("select Hotels");
		waitHelper.WaitForElement(selectHotels, 60);
		selectHotels.click();
		log.info("select Hotels from dropdown");
		waitHelper.WaitForElement(clickHotelsLink, 60);
		clickHotelsLink.click();
		waitHelper.WaitForElement(clickAdd, 60);
		log.info("click Add button to add the hotels");
		clickAdd.click();
	}

	public void addDetails() {
		log.info("Enter hotel name Monks palace");
		hotelName.sendKeys(hotel_Name);
		log.info("Switch to IFrame");
		waitHelper.WaitForElement(iFrame, 60);
		
		// switch to Iframe
		driver.switchTo().frame(iFrame);
		log.info("IFrame located");
		
		WebElement hoteldescr = driver.findElements(By.xpath(hoteldes)).get(0);
		log.info("click on hotel descrption: ");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(hoteldescr);
		actions.click();
		actions.sendKeys(descriptionForHotel);
		actions.build().perform();
		log.info("Entered hotelDescription for Monks palace");
		
		log.info("Switch to default Content");
		driver.switchTo().defaultContent();

		log.info("select on Location of the hotel: ");
		Location.click();
		enterLocation.sendKeys(locationData);
		waitHelper.WaitForElement(selectLocation, 60);
		selectLocation.click();

		// select facilities
		log.info("click on facilities tab ");
		waitHelper.WaitForElement(clickFacilities, 60);
		clickFacilities.click();
		checkboxAirportTransport.click();
		checkboxElevator.click();

		// select paymentOptions
		log.info("select paymentOptions from policy tab ");
		waitHelper.WaitForElement(clickPolicy, 60);
		clickPolicy.click();
		clickPaymentOptions.click();
		clickPayOnArrival.click();
		clickTranlate.click();

		// select Translate
		log.info("select french description of hotel from Translate tab");
		clickTranlate.click();
		log.info("Enter hotelName in french");
		russiaHotelName.sendKeys(hotel_Name);

		log.info("Switch to IFrame");
		waitHelper.WaitForElement(iFrameRussia, 60);
		driver.switchTo().frame(iFrameRussia);

		log.info("IFrame located");
		List<WebElement> a = driver.findElements(By.xpath(hoteldes));
		WebElement russiaHoteldescr = a.get(a.size() - 1);
		log.info("click on hotel descrption: ");
		Actions actionsFD = new Actions(driver);
		actionsFD.moveToElement(russiaHoteldescr);
		actionsFD.click();
		actionsFD.sendKeys(russiaTranslateHotelDesc);
		log.info("Entered hotelDescription for Monks palace in Russia language");
		actionsFD.build().perform();
		log.info("Switch to default Content");
		driver.switchTo().defaultContent();

	}

	public void submitAndVerify() {
		// Submit all the details and Verify
		clickSubmit.click();
		waitHelper.WaitForElement(viewAdminDashBoard, 60);
		viewAdminDashBoard.isDisplayed();
		waitHelper.WaitForElement(getAddedHotel, 60);
		String hotelNameAdded = getAddedHotel.getText();
		if (hotelNameAdded.equals(hotel_Name)) {
			assertTrue("Monks Palace Hotel is added", true);
			log.info("Successfully added hotel");
		} else
			assertTrue("Monks Palace Hotel is not added", false);
	}

	public void selectRooms() {
		log.info("select Hotels");
		waitHelper.WaitForElement(selectHotels, 60);
		selectHotels.click();
		log.info("select Rooms from dropdown");
		waitHelper.WaitForElement(clickRooms, 60);
		clickRooms.click();
		waitHelper.WaitForElement(clickAdd, 60);
		log.info("click Add button to add the rooms");
		clickAdd.click();
	}

	public void addRoomsFacilities() throws InterruptedException {
		log.info("select RoomType");
		waitHelper.WaitForElement(clickRoomType, 60);
		clickRoomType.click();
		log.info("select Room Type from dropdown");
		waitHelper.WaitForElement(selectRoomType, 60);
		selectRoomType.click();

		log.info("Switch to IFrame");
		waitHelper.WaitForElement(iFrame, 60);
		// switch to Iframe
		driver.switchTo().frame(iFrame);

		log.info("IFrame located");
		WebElement hotelRoomDescr = driver.findElements(By.xpath(hoteldes)).get(0);

		log.info("click on room descrption: ");
		Actions actions = new Actions(driver);
		actions.moveToElement(hotelRoomDescr);
		actions.click();
		actions.sendKeys(descForHotelRoom);
		log.info("Entered hotel Room Description for Monks palace");
		actions.build().perform();
		log.info("Switch to default Content");
		driver.switchTo().defaultContent();

		log.info("Select and Enter Price");
		price.click();
		price.sendKeys(PriceText);
		log.info("Select and Enter quantity");
		quantity.click();
		quantity.sendKeys(minStayText);
		minStay.click();
		minStay.sendKeys(minStayText);
		maxAdults.click();
		maxAdults.sendKeys(minStayText);
		maxChild.click();
		maxChild.sendKeys(minStayText);
		noOfBeds.click();
		noOfBeds.sendKeys(minStayText);
		extraBedCharges.click();
		extraBedCharges.sendKeys(ExtraBedChargesText);
		clickAminities.click();
		waitHelper.WaitForElement(selectPrivateBathRoom, 60);
		log.info("click private bathroom check box ");
		selectPrivateBathRoom.click();
		// submit
		clickSubmit.click();
		
		// Verify
		log.info("Verify DashBoard is displayed");
		waitHelper.WaitForElement(viewAdminDashBoard, 60);
		viewAdminDashBoard.isDisplayed();
		log.info("Verify hotel room is added");
		waitHelper.WaitForElement(getAddedRoom, 60);
		String hotelRoomAdded = getAddedRoom.getText();
		log.info("Get text of hotelName..." + hotelRoomAdded);
		if (hotelRoomAdded.equals(hotel_Name)) {
			assertTrue("Monks Palace Hotel is added", true);
			log.info("Successfully added hotel rooms");
		} else
			assertTrue("Monks Palace Hotel rooms facilities is not added", false);
	}

	public void selectRussiaLanguage() {
		waitHelper = new WaitHelper(driver);
		waitHelper.WaitForElement(hotelDetailss, 60);
		log.info("All the hotels available are displayed");
		hotelDetailss.click();
		log.info("Click on first hotel");
		log.info("select language Russia from dropdown");
		waitHelper.WaitForElement(language, 60);
		language.click();
		waitHelper.WaitForElement(selectRussia, 60);
		selectRussia.click();
	}

	public void verifyLanguageTranslate() throws InterruptedException {
		log.info("Get the text in russia language ");
		waitHelper.WaitForElement(textDesc, 60);
		String russiaLang=textDesc.getText();
		log.info("russiaLang..."+russiaLang);
//		if (russiaLang.equals(descriptionForHotel)) {
//			assertTrue("Language is translate is working", true);
//			log.info("Language Translated to russia for HOTEL Discription");
//		} else
//			assertTrue("Language should translate to russia for HOTEL Discription", false);
	}

}