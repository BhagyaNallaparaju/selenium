package com.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.helper.logger.LoggerHelper;

import helper.wait.WaitHelper;


public class LoginAndUpdatePage {
	private WebDriver driver;

	WaitHelper waitHelper;
	String expectedPhoneNumber=null;
	private final Logger log = LoggerHelper.getLogger(LoginAndUpdatePage.class);

	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//b[@class='lightcaret mt-2 go-left']")
	WebElement myAccount;

	@FindBy(xpath="//nav[@class='navbar navbar-default']//ul[@class='dropdown-menu']//li[1]//a[1]")
	WebElement LogIn;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement userName;

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath="//form[@id='loginfrm']//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\'body-section\']/div[1]/div/div/div[1]/h3")
	WebElement loginPage;
	
	@FindBy(xpath="//*[@id=\'body-section\']/div[2]/div[2]/div/div[1]/ul/li[2]/a")
	WebElement myProfile;
	
	@FindBy(xpath="//*[@id=\'profilefrm\']/div/div[1]/div[1]/h3[contains(text(),'Personal Details')]")
	WebElement viewMyProfileDetails;
	
	@FindBy(xpath="//*[@id=\'profilefrm\']/div/div[1]/div[2]/div[3]/div[2]/input[@name='phone']")
	WebElement phone;
	
	@FindBy(xpath="//*[@id=\'profilefrm\']/div/div[3]/div[3]/button[contains(text(),'Submit')]")
	WebElement submit;
	
	@FindBy(xpath="//*[@id=\'profile\']/div[2]/div[2]/div[contains(text(),'Profile Updated Successfully.')]")
	WebElement updateSuccessMessage;
	
	
	public LoginAndUpdatePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void myAccount(){
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(myAccount, 20);
		myAccount.isDisplayed();
		log.info("click on myAccount");
		myAccount.click();
	}
	
	public void logInClick(){
		log.info("click on LogIn");
		LogIn.click();
	}
	public void enteruserName(String userName){
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(this.userName, 60);
		log.info("entering username...."+userName);
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		log.info("entering password...."+password);
		this.password.sendKeys(password);
	}
	
	public void logInButtonClick(){
		log.info("click on myAccount");
		loginButton.click();
	}

	public void loginSuccessful() {
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(loginPage, 10);
		loginPage.isDisplayed();
		log.info("LogIn is successful");
	}
	
	public void viewMyProfile() {
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(loginPage, 30);
		myProfile.isDisplayed();
		log.info("myProfile is Displayed");
	}
	
	public void clickMyProfile() {
		myProfile.click();
		log.info("Click on myProfile is successful");
	}
	
	public void viewMyDetails() {
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(loginPage, 60);
		viewMyProfileDetails.isDisplayed();
		log.info("user personal details are displayed");
	}
	
	public void updatePhoneNumber(String phoneNumber) {
		expectedPhoneNumber=phoneNumber;
		phone.clear();
		phone.sendKeys(phoneNumber);
		log.info("Entered the phoneNumber provided");
	}
	
	public void clickOnSubmit() throws InterruptedException {
		submit.click();
		Thread.sleep(100);
		log.info("submitted the phoneNumber");
	}
	
//	public void profileUpdateMessage() {
//		updateSuccessMessage.isDisplayed();
//		log.info("Profile Updated Successfully. message is displayed");
//		
//	}
	
	public void confirmPhoneNumberUpdate() {
		String ActualPhoneNumber=phone.getAttribute("value");
		log.info("ActualPhoneNumber String"+ActualPhoneNumber);
		System.out.println("Actual "+ActualPhoneNumber+"  issss");
		System.out.println("Expected "+expectedPhoneNumber+"  issss");
		if(ActualPhoneNumber.equals(expectedPhoneNumber))
		{
			org.testng.Assert.assertTrue(true);
		}
		else
			org.testng.Assert.assertTrue(false);
		
	}
}
