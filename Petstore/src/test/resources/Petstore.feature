Feature: Google Maps Test

  @petstore
  Scenario Outline: Register User
    Given I have a Selenium using "<browser>"
    And I access the petstore Page
    And I click the Sign In button
    And I click the register button
    And I fill all the necessary fields
    When I click the save button
    Then I see the actions page
    And I click the Sign In button
    And I enter my credentials
    And I click the log in button
    Then I see the welcome message


    Examples:
      | browser |
      | chrome  |
      #| firefox |
      #| edge    |
