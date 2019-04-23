package com.PageObject;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.helper.logger.LoggerHelper;

import helper.wait.WaitHelper;

public class ReloginPage {
	private WebDriver driver;

	WaitHelper waitHelper;
	private final Logger log = LoggerHelper.getLogger(ReloginPage.class);

	@FindBy(xpath="//body[@onload='startTime()']/nav[@class='navbar navbar-default']/div[@class='container']/div[@class='collapse navbar-collapse']/ul[@class='nav navbar-nav navbar-right hidden-sm go-left']/ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']/li[1]/a[1]")
	WebElement firstName;

	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//b[@class='lightcaret mt-2 go-left']")
	WebElement navigationBar;

	@FindBy(xpath="//nav[@class='navbar navbar-default']//ul[@class='dropdown-menu']//li[2]//a[1]")
	WebElement logOut;
	
	@FindBy(xpath="//div[@class='panel-heading go-text-right']")
	WebElement loginPage;
	
	public ReloginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void FirstNameInNavigationBar(){
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(firstName, 20);
		firstName.isDisplayed();
		String actualFirstName=firstName.getText();
		log.info("Customer FirstName: "+actualFirstName);
		if(actualFirstName.equals("JOHNY"))
		{
			assertTrue("FirstName should be displayed", true);
		}
		else
		{
			assertTrue("FirstName is not displayed ", false);
		}
	}
	
	public void logOutUser(){
		navigationBar.click();
		waitHelper=new WaitHelper(driver);
		waitHelper.WaitForElement(logOut, 40);
		logOut.click();
		loginPage.isDisplayed();
		log.info("User Logged Out");
	}
}
