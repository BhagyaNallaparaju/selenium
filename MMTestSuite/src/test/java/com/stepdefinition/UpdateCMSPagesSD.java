package com.stepdefinition;

import com.PageObject.UpdateCMSPages;
import com.TestBase.TestBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UpdateCMSPagesSD {
	
	UpdateCMSPages updateCMSPages=new UpdateCMSPages(TestBase.driver);
	
	@Then("^click CMS dropdown and select pages$")
	public void click_CMS_dropdown_and_select_pages() throws Throwable {
		updateCMSPages.selectCMSPages();
		updateCMSPages.selectFAQ();
	}

	@Then("^click checkbox About Us and update$")
	public void click_checkbox_About_Us_and_update() throws Throwable {
		updateCMSPages.updateFAQText();
	}

	@When("^scroll down to page$")
	public void scroll_down_to_page() throws Throwable {
		updateCMSPages.scrollDown();
	}

	@Then("^Check for update$")
	public void check_for_update() throws Throwable {
		updateCMSPages.checkUpdate();
	}



}
