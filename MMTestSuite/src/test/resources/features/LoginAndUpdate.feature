@ProfileLogInAndUpdate
Feature:  Customers login and profile update of the website
	Customers should be able to login to the website. 
	the logged in the should be able to access there profile. 
	They should be able to update there profile and see the changes. 

Background: Customer login to the website
    Given Verify the Customer is on home page
    And Home page is loaded
    When Customer Navigate to LogIn Page
    Then Customer enters UserName "user@phptravels.com" and Password "demouser"
    Then Click on LogIn button
    And LogIn is successful

@Sanity
  Scenario: Customer should be able to access the profile
    Given Customer is able to view the profile
    When User should be able to click on MyProfile 
    Then User details are displayed

@Sanity
  Scenario: Customer should be able to update the profile
    Given Navigate to MyProfile pesonal detials page
    When Update Phone number "234" 
    Then Click on Sumbit button
    And Verify the phoneNumber to be Updated  
