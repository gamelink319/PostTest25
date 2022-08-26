Feature: Checkout shop

Scenario: Navigate to shop
	Given User go to web shop
	And User click dismiss

Scenario: User Add item
   When User click Search first item
   And User add first item to cart
   Then User click Search second cart
   And User add Second item to cart
   Then User click view cart
   And User click view Checkout

Scenario: User checkout
    When User input data
    And User click checkout
    Then User Your order has been received
        
        