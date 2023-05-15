Feature: Users endpoint CRUD testing

  @API
  Scenario: Create new user
    Given Create new user
    And Verify that user was created
    Then Delete user by id
  @API
  Scenario: Get user by id
    Given Create new user
    And Get user by id
    Then Delete user by id
  @API
  Scenario: Update user by id
    Given Create new user
    And Get user by id
    Then Update user
    And Verify user is updated
    Then Delete user by id
  @API
  Scenario: Delete user
    Given Create new user
    And Verify that user was created
    Then Delete user by id
    And Verify user does not exist
