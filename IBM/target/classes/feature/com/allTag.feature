@Functional
Feature: Google Search

	@Sanity
  Scenario: To type text in search bar
    
    Given To launch google website
    When The search bar is visible
    Then Enter the text KJ
    
    @Sanity @Regression
  	Scenario: To type text in search bar
    
    Given To launch google website
    When The search bar is visible
    Then Enter the text TJ
    
    @Regression
  	Scenario: To type text in search bar
    
    Given To launch google website
    When The search bar is visible
    Then Enter the text AJ