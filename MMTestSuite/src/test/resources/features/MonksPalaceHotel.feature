@MonksPalaceHotel
Feature: Book a Hotel and view in profile Bookings
  We just opened a hotel in Hilversum called “Monks palace” it is an absolute dream.
  Add it to the website and make sure the correct but not all facilities are set. 
  Monks are clean people so they don’t need laundry service. 
  and book a night in the palace. 
  Since monks come from across the world make sure it is also available in some other languages.

  @Sanity
  Scenario: Admin add hotel to the website
    Given Navigate to the Admin url
    When Admin logIn with UserName "admin@phptravels.com" and Password "demoadmin"
    Then Admin click on HOTELS link and select add
    And Admin enters all the details,facilities and available languages
    Then Admin adds rooms services provided

  @Sanity
  Scenario: Customer books Monks Palace
    Given Navigate to the customer url
    When Customer LogIn with  UserName "user@phptravels.com" and Password "demouser"
    Then User click on HOTELS and search for Monks Palace
    And Select hotel and make a Booking
    And Verify Booking confirmation of Monks Palace

  @Sanity
  Scenario: Hotel description should be available in Russian language
    Given Navigate to the customer url
    When Customer LogIn with  UserName "user@phptravels.com" and Password "demouser"
    Then User click on HOTELS and search for Monks Palace
    And Select language as Russia
    And Hotel Description should be russian language.
