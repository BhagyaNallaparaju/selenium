@ProfileLogInAndUpdate
Feature: Book a Hotel and view in profile Bookings
  So searching for hotels 
  and working with the filters is an absolute must to ensure customers find there deal quickly.
  Find a good deal and purchase the hotel of your choice. 
  Check in your profile you really see your booking.

  Background: Customer login to the website
    Given Verify the Customer is on home page
    And Home page is loaded
    When Customer Navigate to LogIn Page
    Then Customer enters UserName "user@phptravels.com" and Password "demouser"
    Then Click on LogIn button
    And LogIn is successful
	@Sanity
  Scenario: Customer books a hotel using filters
    Given User click on HOTELS in navigation bar
    When User search for the hotel in desired region
    Then User apply filters for hotels
    And Book hotel based on availability
    And Verify Booking confirmation
    
  @Sanity
  Scenario: Customer verify booked hotel
    Given Click on Bookings
    When User searchs for the hotel
    Then Hotel should be found

  
