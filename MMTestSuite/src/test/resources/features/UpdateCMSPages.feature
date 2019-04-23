@UpdateCMSPages
Feature: Update CMS pages and view in SEO

  @Sanity
  Scenario: Update About Us in CMS Pages and search
    Given Navigate to the Admin url
    When Admin logIn with UserName "admin@phptravels.com" and Password "demoadmin"
    Then click CMS dropdown and select pages
    And click checkbox About Us and update

  @Sanity
  Scenario: Verify FAQ'S is Updated
    Given Verify the Customer is on home page
    When scroll down to page
    Then Check for update
    