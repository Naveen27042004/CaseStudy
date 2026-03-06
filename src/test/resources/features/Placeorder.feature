Feature: Article Place Order

Scenario: User Login
Given User is on Login Page
When User enters "sample@gmail.com" and "sample"
Then User in Home Page

Scenario: Create Article
Given User in Home Page
When User create new article "<title>" "<description>" "<content>" "<tag>"
Then Article is created "<title>"
Examples:
|title|description|content|tag|
|Selenium|Selenium using Java|Selenium webdriver using java|Java|

Scenario: Update an Article
Given Article is Created "Selenium"
When User updates article 
|Selenium WebDriver|
Then Article is Updated "Selenium WebDriver"

Scenario: Delete an Article
Given Article is Created "Selenium WebDriver"
When User Deletes article
|title|
|Selenium WebDriver|
Then Article is Deleted "Selenium WebDriver"