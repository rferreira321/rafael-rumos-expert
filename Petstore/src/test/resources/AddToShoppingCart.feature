Feature: Add a product to the shopping cart

  @petstore
  Scenario: Add a product to the shopping cart
    Given I have a Selenium using "<browser>"
    And I access the petstore Page
    And I click the Dogs page
    And I select an item to buy
    And I click the Add to cart button
    Then I should see the Shopping cart page with the item I selected



    Examples:
      | browser | input |
      | chrome  | retriever |
      | firefox | retriever |
      #| edge    | retriever |