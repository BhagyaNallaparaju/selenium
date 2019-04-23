package com.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.helper.logger.LoggerHelper;

import helper.wait.WaitHelper;

public class InvalidLoginPage {
	private WebDriver driver;

	WaitHelper waitHelper;
	private final Logger log = LoggerHelper.getLogger(InvalidLoginPage.class);
	
	@FindBy(xpath="/html/body/div/form[1]/div[1]/h2")
	WebElement loginPanel;
	
	@FindBy(xpath="/html/body/div/form[1]/div[1]/input[@name='email']")
	WebElement userName;

	@FindBy(xpath="/html/body/div/form[1]/div[1]/input[@name='password']")
	WebElement password;

	@FindBy(xpath="/html/body/div/form[1]/button/span[1]")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/div/form[1]/div[2]/div[contains(text(),'Invalid Login Credentials')]")
	WebElement errorMessageLogIn;
	
	
	public InvalidLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void LoginPanel(){
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(loginPanel, 20);
		loginPanel.isDisplayed();
		log.info("Supplier Page is loaded");
	}
	
	public void InvalidUserAndPassword(String usernameInvalid,String passwordInvalid){
		userName.sendKeys(usernameInvalid);
		password.sendKeys(passwordInvalid);
		log.info("Enterted Invalid UserName and Password");
	}
	public void LoginClick(){
		loginButton.click();
		log.info("clicked on LogIn");
	}
	
	public void InvalidLoginErrorMessage(){
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(errorMessageLogIn, 20);
		errorMessageLogIn.isDisplayed();
		log.info("Verified Invalid LogIn");
	}
	
}
