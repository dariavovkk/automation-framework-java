Feature: Buy phone from T-mobile store
  Scenario: Select phone from offer list
    Given user opens T-Mobile website
    When user opens Sklep menu
    And user selects "Bez abonamentu" from Smartfony section
    And user selects phone "Apple iPhone 16"
    And user adds phone to cart
    Then cart page should be displayed
    And product price should be correct
    When user returns to T-Mobile homepage
    And user opens cart
    Then cart should contain "Apple iPhone 16"