@InvalidLogin
Feature: Customers Invalid Login Validation
 Customers should not be able to login to section that they are not allowed in. Find out if they can log in.

  @Sanity
  Scenario Outline: Checking Invalid Login for Supplier Back-End
   Given Verify the Customer is on Supplier BackEnd homepage
    And Supplier Homepage is loaded
    When Enter Invalid username "<Username>" and password "<Password>"
    Then Click on LogIn button on the page
    And  Invalid logIn message is displayed

    Examples: 
      | Username              | Password     | 
      | user@phptravels.com   | demouser     |
      | admin@phptravels.com  | demoadmin    |
