@Relogin
Feature: Verify Re-Login
  user is logged in 
  and he should see his first name in the navigation bar 
  and should be able to log-out again 
  and re-login.

  Background: Customer login to the website
    Given Verify the Customer is on home page
    And Home page is loaded
    When Customer Navigate to LogIn Page
    Then Customer enters UserName "user@phptravels.com" and Password "demouser"
    Then Click on LogIn button
    And LogIn is successful

  @Sanity
  Scenario: Verify successful Re-LogIn
    Given User should see his first name in the navigation bar 
    When User should be able to log-out 
		Then Customer enters UserName "user@phptravels.com" and Password "demouser"
    Then Click on LogIn button
    And LogIn is successful