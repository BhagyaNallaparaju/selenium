package com.stepdefinition;

import com.PageObject.ReloginPage;
import com.TestBase.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helper.wait.WaitHelper;

public class ReloginSD {

	ReloginPage reloginPage= new ReloginPage(TestBase.driver);	
	WaitHelper waitHelper;
	
	@Given("^User should see his first name in the navigation bar$")
	public void user_should_see_his_first_name_in_the_navigation_bar() throws Throwable {
		reloginPage.FirstNameInNavigationBar();
	}

	@When("^User should be able to log-out$")
	public void user_should_be_able_to_log_out_again() throws Throwable {
		reloginPage.logOutUser();
	}

}
