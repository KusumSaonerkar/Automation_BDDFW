#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@ProductPageTest
Feature: Product page Validattion
 

  @Send_a_Friend_featue
  Scenario Outline: Validate the product link
    Given open the browser
    When User login username "22kusumsaonerkar@gmail.con" and password "Nehu@1234"
    Then User clicked on T-shirts catgory
    And User clicked on more
    And User clicked on Send a friend
    Then User fill the details " <Friend_Name>" and "<Email_id>" and clicked on send button
    And close the browser
   
    
    Examples:
    				|Friend_Name|Email_id             |
    				|Sujit Ghule |ghulesujit1@gmail.com|
   
  @ValidateCart
  Scenario: Validate cart product value
	Given open the browser
	When user add three product in cart 
	Then user validate the cart product value  
	And close the browser
	
	@RemoveProducts
	Scenario: Validate remove product
	Given open the browser
	When user add three product in cart 
	Then user validate the remove cart product value  
	And close the browser

