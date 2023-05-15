Feature: Create new account feature

  Background:
    Given Verify user is on a home page
    When User clicks on account
    And User clicks on create account
    Then verify user is on email verification page

  @UI @Smoke @Regression
  Scenario: Verify user can create a new account
    When User enters a "registration.email" address and clicks a continue button
    Then Verify user is on a create account page
    And User sends request to create user with following fields:
      | firstName | lastName | password  |
      | John      | Smith    | Test12345 |
    Then verify user is on a dashboard page

  @UI @Smoke @Regression
  Scenario: Verify user is not able to create new account, if an email already used in existing account
    When User enters a "existing.email" address and clicks a continue button
    Then Verify account already exists error message is displayed

  @UI @Regression
  Scenario: Verify user can't register using invalid email
    When User enters invalid email and clicks continue
    Then Verify invalid email error message is displayed

  @UI @Regression
  Scenario Outline: When user enters wrong format password, verify error message is displayed
    When User enters a "registration.email" address and clicks a continue button
    Then Verify user is on a create account page
    When User enters"<firstName>" and "<lastName>" and wrong format "<password>"
    Then Verify wrong format password error message is displayed
    Examples:
      | firstName | lastName | password  |
      | John      | Smith    | Test123   |
      | John      | Smith    | test12345 |
      | John      | Smith    | Test      |