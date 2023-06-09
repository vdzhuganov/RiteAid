Feature: Users post endpoint CRUD testing

  Background:
    Given Create new user
    Then Verify that user was created
  @API
  Scenario: Create new post
    Given Create a new post
    Then Verify post was created
    Then Delete post by using post id
    And Delete user by id
  @API
  Scenario: Get post by id
    Given Create a new post
    And Get post by id
    Then Delete post by using post id
    And Delete user by id
  @API
  Scenario: Update post by id
    Given Create a new post
    And Get post by id
    Then Update post
    And Verify post is updated
    Then Delete post by using post id
    And Delete user by id
  @API
  Scenario: Delete post
    Given Create a new post
    And Verify post was created
    Then Delete post by using post id
    And Verify post no longer exists
    And Delete user by id