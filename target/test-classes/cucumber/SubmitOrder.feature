@tag
Feature: Purchase the order from Ecommerce websites
 I want to use this template for my feature file
 
 Background:
Given I landed on Ecommerce Page
 
 @Regression
 Scenario Outline: Positive test of submitting the order.
 
 Given Login with the username <username> and password <password> 
 When I add product <productName>  to cart
 And Checkout <productName> and submit the order
 Then "Thankyou for the order." message is displayed on the confirmatioPage  
 
 Examples:
|username      |password  |productName|
|sili@gmail.com|Sili@12345|ZARA COAT 3|

