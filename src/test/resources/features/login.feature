@CartTest
Feature: Verify product is added to cart

	Background:
		Given the user is logged in to the SauceDemo website

  Scenario: User adds a product to the cart
    When the user adds product to the cart
    Then the cart should display number of item