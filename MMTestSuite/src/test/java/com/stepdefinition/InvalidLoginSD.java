package com.stepdefinition;

import java.util.concurrent.TimeUnit;

import com.PageObject.InvalidLoginPage;
import com.TestBase.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvalidLoginSD {
	
	InvalidLoginPage invalidLoginPage = new InvalidLoginPage(TestBase.driver);
	
	@Given("^Verify the Customer is on Supplier BackEnd homepage$")
	public void verify_the_Customer_is_on_Supplier_BackEnd_homepage() throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/supplier");
		TestBase.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("^Supplier Homepage is loaded$")
	public void supplier_Homepage_is_loaded() throws Throwable {
		invalidLoginPage.LoginPanel();
	}

	@When("^Enter Invalid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_Invalid_username_and_password(String username, String password) throws Throwable {
		invalidLoginPage.InvalidUserAndPassword(username,password);
	}

	@Then("^Click on LogIn button on the page$")
	public void click_on_LogIn_button_on_the_page() throws Throwable {
		invalidLoginPage.LoginClick();
	}

	@Then("^Invalid logIn message is displayed$")
	public void invalid_logIn_message_is_displayed() throws Throwable {
		invalidLoginPage.InvalidLoginErrorMessage();
	}
}
