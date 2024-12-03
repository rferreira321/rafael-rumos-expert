Feature: Perform a full purchase

  Scenario: Add a product to the cart and perform a purchase
    Given I have a Selenium using "<browser>"
    And I access the petstore Page
    And I click the Sign In button
    And I enter my purchase credentials
    And I click the log in button
    Then I see the welcome message
    And I click the Dogs page
    And I select an item to buy
    And I click the Add to cart button
    Then I should see the Shopping cart page with the item I selected
    And I click the Proceed to Checkout button
    And I click the continue button
    And I click the confirm button
    And I should see the order confirmation page with the item I purchased

    Examples:
      | browser |
      | chrome  |
      | firefox |
      #| edge    |