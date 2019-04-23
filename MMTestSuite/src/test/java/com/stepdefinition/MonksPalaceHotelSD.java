package com.stepdefinition;


import java.util.concurrent.TimeUnit;

import com.PageObject.BookAHotelPage;
import com.PageObject.LoginAndUpdatePage;
import com.PageObject.MonksPalaceHotelPage;
import com.TestBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MonksPalaceHotelSD {
	MonksPalaceHotelPage monksPalaceHotelPage = new MonksPalaceHotelPage(TestBase.driver);
	LoginAndUpdatePage loginAndUpdatePage=new LoginAndUpdatePage(TestBase.driver);
	BookAHotelPage bookAHotelPage =new BookAHotelPage(TestBase.driver);
	
	@Given("^Navigate to the Admin url$")
	public void navigate_to_the_Admin_url() throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/admin");
		TestBase.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^Admin logIn with UserName \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void admin_logIn_with_UserName_and_Password(String UserName, String Password) throws Throwable {
		monksPalaceHotelPage.enterUserNameAndPassword(UserName, Password);
		monksPalaceHotelPage.clickLogInButton();
		monksPalaceHotelPage.verifyAdminLogInSuccessful();
	}

	@Then("^Admin click on HOTELS link and select add$")
	public void admin_click_on_HOTELS_link_and_select_add() throws Throwable {
		monksPalaceHotelPage.clickHotelsLinkAndAddHotel();
	}
	
	@Then("^Admin enters all the details,facilities and available languages$")
	public void admin_enters_all_the_details_facilities_and_available_languages() throws Throwable {
		monksPalaceHotelPage.addDetails();
		monksPalaceHotelPage.submitAndVerify();
	}

	@Then("^Admin adds rooms services provided$")
	public void admin_adds_rooms_services_provided() throws Throwable {
		monksPalaceHotelPage.selectRooms();
		monksPalaceHotelPage.addRoomsFacilities();
	}
	
	@Given("^Navigate to the customer url$")
	public void navigate_to_the_customer_url() throws Throwable {
		TestBase.driver.get("https://www.phptravels.net/");
		loginAndUpdatePage.myAccount();
		loginAndUpdatePage.logInClick();
	}

	@When("^Customer LogIn with  UserName \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void customer_LogIn_with_UserName_and_Password(String userName, String password) throws Throwable {
	    loginAndUpdatePage.enteruserName(userName);
	    loginAndUpdatePage.enterPassword(password);
	    loginAndUpdatePage.logInButtonClick();
	    loginAndUpdatePage.loginSuccessful();
	}

	@Then("^User click on HOTELS and search for Monks Palace$")
	public void user_click_on_HOTELS_and_search_for_Monks_Palace() throws Throwable {
		bookAHotelPage.clickOnHotels();
		bookAHotelPage.searchHotels("Hilv");
		bookAHotelPage.selectChecKIn_OutDates();
	}

	@Then("^Select hotel and make a Booking$")
	public void select_hotel_and_make_a_Booking() throws Throwable {
		//bookAHotelPage.bookAHotel();
	}
	
	@Then("^Verify Booking confirmation of Monks Palace$")
	public void verify_Booking_confirmation_of_Monks_Palace() throws Throwable {
		//bookAHotelPage.verifyBookingConfirmation();
	}
	
	@Then("^Select language as Russia$")
	public void select_language_as_Russia() throws Throwable {
	   monksPalaceHotelPage.selectRussiaLanguage();
	 
	}

	@Then("^Hotel Description should be russian language\\.$")
	public void hotel_Description_should_be_russian_language() throws Throwable {
		monksPalaceHotelPage.verifyLanguageTranslate();
	}


}
