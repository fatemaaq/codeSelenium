#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template



Feature: Accounts Feature
  

  Scenario: Create Account
    Given User launches the application
    When User enters username and password
    And User clicks on login button
    And User clicks on accounts link
    And User clicks on new button to craete new account
    Then I validate the outcomes
   
  
  Scenario: Create New View
    Given User launches the application
    When User enters username and password
    And User clicks on accounts link
    And User clicks on new button to new view link
    Then I validate the outcomes

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
