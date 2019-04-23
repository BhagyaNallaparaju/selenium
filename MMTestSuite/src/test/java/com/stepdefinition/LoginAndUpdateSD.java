package com.stepdefinition;

import java.util.concurrent.TimeUnit;
import com.PageObject.LoginAndUpdatePage;
import com.TestBase.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.wait.WaitHelper;

public class LoginAndUpdateSD extends TestBase{

	LoginAndUpdatePage loginAndUpdatePage= new LoginAndUpdatePage(driver);
	WaitHelper waitHelper;
	
	
	@Given("^Verify the Customer is on home page$")
	public void verify_the_Customer_is_on_home_page() throws Exception {
		TestBase.driver.get("https://www.phptravels.net/");
		TestBase.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("^Home page is loaded$")
	public void home_page_is_loaded() throws Exception {
		loginAndUpdatePage.myAccount();
	}

	@When("^Customer Navigate to LogIn Page$")
	public void customer_Navigate_to_LogIn_Page() throws Exception {
		loginAndUpdatePage.logInClick();
	}

	@Then("^Customer enters UserName \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void customer_enters_UserName_and_Password(String arg1, String arg2) throws Exception {
		loginAndUpdatePage.enteruserName(arg1);
		loginAndUpdatePage.enterPassword(arg2);
	}

	@Then("^Click on LogIn button$")
	public void click_on_LogIn_button() throws Exception {
		loginAndUpdatePage.logInButtonClick();
	}

	@Then("^LogIn is successful$")
	public void login_is_successful() throws Exception {
		loginAndUpdatePage.loginSuccessful();
	}
	
	@Given("^Customer is able to view the profile$")
	public void customer_is_able_to_view_the_profile() throws Exception {
	    loginAndUpdatePage.viewMyProfile();
	}

	@When("^User should be able to click on MyProfile$")
	public void user_should_be_able_to_click_on_MyProfile() throws Exception {
		loginAndUpdatePage.clickMyProfile();
	}

	@Then("^User details are displayed$")
	public void user_details_are_displayed() throws Exception {
		loginAndUpdatePage.viewMyDetails();
	}
	
	@Given("^Navigate to MyProfile pesonal detials page$")
	public void navigate_to_MyProfile_pesonal_detials_page() throws Exception {
		 loginAndUpdatePage.viewMyProfile();
		 loginAndUpdatePage.clickMyProfile();
		 loginAndUpdatePage.viewMyDetails();
	}

	@When("^Update Phone number \"([^\"]*)\"$")
	public void update_Phone_number(String phone) throws Exception {
	   loginAndUpdatePage.updatePhoneNumber(phone);
	}

	@Then("^Click on Sumbit button$")
	public void click_on_Sumbit_button() throws Exception {
	   loginAndUpdatePage.clickOnSubmit();
//	   loginAndUpdatePage.profileUpdateMessage();
	}

	@Then("^Verify the phoneNumber to be Updated$")
	public void verify_the_phoneNumber_to_be_Updated() throws Exception {
		loginAndUpdatePage.confirmPhoneNumberUpdate();
	}
}
