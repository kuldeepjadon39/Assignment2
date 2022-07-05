#open amazon.com
#Verify amazon.com opened up
#Click on menu icon
#Click on best seller
#Verify Header amazon best seller

Feature: Amazon website
Scenario: To verify amazon best seller page

Given Launch Amazon.in
When Verify that sign in btn is displayed
And click on menu icon
And click on Best sellers
Then verify best seller header
