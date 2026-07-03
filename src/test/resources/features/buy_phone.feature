Feature: Buy phone from T-mobile store

  Scenario: Select phone from offer list
    Given user opens T-Mobile website
    And user accepts cookies
    When user opens Sklep menu
    And user selects Bez abonamentu from Smartfony section
    When user selects "Apple" brand
    And user selects phone "Apple iPhone 16"
    And user selects color "Ultramaryna"
    And user adds phone to cart
    Then user verifies that cart price matches product price
    When user goes back to T-Mobile home page
    And user clicks on header cart icon
    Then cart contains added phone "Apple iPhone 16"