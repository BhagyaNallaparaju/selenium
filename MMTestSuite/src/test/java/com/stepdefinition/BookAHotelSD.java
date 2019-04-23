package com.stepdefinition;

import com.PageObject.BookAHotelPage;
import com.TestBase.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookAHotelSD {

	BookAHotelPage bookAHotelPage= new BookAHotelPage(TestBase.driver);
	String block="Block";
	@Given("^User click on HOTELS in navigation bar$")
	public void user_click_on_HOTELS_in_navigation_bar() throws Throwable {
		bookAHotelPage.clickOnHotels();
	}

	@When("^User search for the hotel in desired region$")
	public void user_search_for_the_hotel_in_desired_region() throws Throwable {
	    bookAHotelPage.searchHotels(block);
	    bookAHotelPage.selectChecKIn_OutDates();
	}

	@Then("^User apply filters for hotels$")
	public void user_apply_filters_for_hotels() throws Throwable {
		//Commented because element is not getting checked in the given website.
		//bookAHotelPage.applyFilters();
	}

	@Then("^Book hotel based on availability$")
	public void book_hotel_based_on_availability() throws Throwable {
		bookAHotelPage.bookAHotel();
	}

	@Then("^Verify Booking confirmation$")
	public void verify_Booking_confirmation() throws Throwable {
		bookAHotelPage.verifyBookingConfirmation();
	}
	
	@Given("^Click on Bookings$")
	public void click_on_Bookings() throws Throwable {
		bookAHotelPage.clickBookings();
	}

	@When("^User searchs for the hotel$")
	public void user_searchs_for_the_hotel() throws Throwable {
		bookAHotelPage.verifyBookingUpdate();
	}

	@Then("^Hotel should be found$")
	public void hotel_should_be_found() throws Throwable {
		bookAHotelPage.profileUptodate();
	}
}
