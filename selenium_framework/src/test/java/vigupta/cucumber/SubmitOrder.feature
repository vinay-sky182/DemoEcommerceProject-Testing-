  @tag
  Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background: 
  Given I landed on Ecommerce Page

  @Order
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name                 | password    | productName |
      | vigupta.kws@gmail.com| P@ssw0rd@94 | ZARA COAT 3 |



# This is a featureFile written in 'Gherkin' language.
# Scenario:- It is the thing which we need to test.
# Scenario Outline:- It is used when Data parametirazation is required and we give the data in form of 
#     Examples: 
#       | name                 | password    | productName |
#       | vigupta.kws@gmail.com| P@ssw0rd@94 | ZARA COAT 3 |

# Background: This will execute before each and every Scenario it is kind of similar to '@BeforeMethod' of TestNG
# Given I landed on Ecommerce Page
