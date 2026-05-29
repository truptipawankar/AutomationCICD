@tag
Feature: Error Validations
 I want to use this template for my feature file
 

 
 @tags2
 Scenario Outline: Titel of the scenario outline.
 
 Given I landed on Ecommerce Page
 When Login with the username <username> and password <password> 
 Then "Incorrect email or password." message is displayed
 
 Examples:
|username      |password  |
|sili@gmail.com|qewrt65|