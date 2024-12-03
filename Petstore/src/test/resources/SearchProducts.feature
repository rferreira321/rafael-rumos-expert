Feature: Search and view products

  @petstore
  Scenario: Search and view products
    Given I have a Selenium using "<browser>"
    And I access the petstore Page
    And I search for a valid "<input>"
    Then I should see results with the keyword I searched for

    Examples:
      | browser | input |
      | chrome  | retriever |
      | firefox | retriever |
      #| edge    | retriever |