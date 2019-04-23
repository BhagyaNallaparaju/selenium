package com.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.helper.logger.LoggerHelper;
import helper.wait.WaitHelper;

public class UpdateCMSPages {
	private WebDriver driver;
	WaitHelper waitHelper;
	String aboutUs="Test by Selenium Automation";
	String faq="FAQQQ";
	private final Logger log = LoggerHelper.getLogger(UpdateCMSPages.class);
	
	@FindBy(xpath = "//*[@id='social-sidebar-menu']/li[6]/a")
	WebElement clickCMS;

	@FindBy(xpath = "//*[@id='CMS']/li/a")
	WebElement clickPages;
	
	@FindBy(xpath = "//*[@id='content']/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr[13]/td[7]/span/a[1]/i")
	WebElement editFAQ;

	@FindBy(xpath = "//*[@id='content']/div/form/div/div[2]/button")
	WebElement submitButton;

	@FindBy(xpath = "//*[@id='GENERAL']/div[1]/div[1]/div/input")
	WebElement pageTitleFAQ;
	
	@FindBy(xpath = "//*[@id='GENERAL']/div[1]/div[2]/div/input")
	WebElement pageLinkFAQ;
	
	@FindBy(xpath = "//*[@id='footer']/div/div[4]/ul/li[1]/a")
	WebElement verifyUpdate;
	
	public UpdateCMSPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectCMSPages() {
		waitHelper = new WaitHelper(driver);
		waitHelper.WaitForElement(clickCMS, 60);
		log.info("Click CMS link");
		clickCMS.click();
		waitHelper.WaitForElement(clickPages, 60);
		clickPages.click();
	}
	
	public void selectFAQ() {
		log.info("Edit FAQ");
		editFAQ.click();
	}
	
	public void updateFAQText() {
		waitHelper.WaitForElement(pageTitleFAQ, 60);
		log.info("Enter pageTitle of FAQ");
		pageTitleFAQ.clear();
		pageTitleFAQ.click();
		pageTitleFAQ.sendKeys(faq);
		log.info("Enter pageLink of FAQ");
		pageLinkFAQ.clear();
		pageLinkFAQ.sendKeys(faq);
		submitButton.click();
	}
	
	public void scrollDown() throws InterruptedException {
		log.info("Scroll down to the page");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void checkUpdate() throws InterruptedException {
		Thread.sleep(5000);
		String updatedText=verifyUpdate.getText();
		log.info("Updated text from browser...."+updatedText);
		log.info("Update text...."+faq);
	}
	
}
