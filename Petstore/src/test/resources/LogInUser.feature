Feature: Log in with a user

  @petstore
  Scenario: Log in with an existing user
    Given I have a Selenium using "<browser>"
    And I access the petstore Page
    And I click the Sign In button
    And I enter my standard credentials
    And I click the log in button
    Then I see the welcome message

    Examples:
      | browser |
      | chrome  |
      | firefox |
      #| edge    |