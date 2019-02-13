@Login
Feature: Login Feature
  As an employee of the company
  I want to login my employee profile using my credentials
  In order to collaborate with my colleagues

  Background: User navigates to login page
    Given I am on the Login page

  Scenario: Successful login one time
    When I fill in username with "mngr145007"
    And I fill in password with "batYmar"
    And I click on the login button
    Then I should login successfully

  Scenario: Data table