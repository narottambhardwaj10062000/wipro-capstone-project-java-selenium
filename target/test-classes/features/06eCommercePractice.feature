@EcommercePracticeTests
Feature: Shopping Cart
   Users should be able to add items to the cart, remove them, and proceed to checkout.
   
   Scenario: Add an item to the cart
      Given the eCommerce page is open
      When the user adds the item "<itemName>" to the cart
      When the user clicks on go to cart button
      Then the item "<itemName>" should be displayed in the cart
      When the user proceeds to checkout
      Then the checkout page should be displayed
      When the user clicks the checkout button 
      Then the order confirmation page should be displayed
      
      
