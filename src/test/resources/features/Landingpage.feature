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

@LandingPage

Feature: BDD Framework Testcases
 
 @Product_Cat_Validation_test
 Scenario: Category validation test
 Given User open the browser
 When User can display  the product category
 And User close the browser

  @youtube
  Scenario: User validate the youtube page
    Given User open the browser
    When User click on youtube icon
   	Then user nevigate to youtube page "Selenium Framework" 
    And User close the browser
    
	@facebook
	Scenario: User validate the facebook page
	Given User open the browser
  When User click on facebook icon
	Then User nevigte to facebook page "Selenium Framework"
  And User close the browser
  
  @Twitter
  Scenario: User validate the twitter page
	Given User open the browser
  When User click on twitter icon
  Then User nevigte to twitter page "Selenium Framework"
  And User close the browser

#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
