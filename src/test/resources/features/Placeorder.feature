Feature: Article Creation,Updation and Deletion

Scenario: User Login
Given User is on Login Page
When User enters "sample@gmail.com" and "sample"
Then User in Home Page

Scenario: Create Article
Given User in Home Page
When User create new article "<title>" "<description>" "<content>" "<tag>"
Then Article is Created "<title>"

Scenario: Update an Article
Given Article is Created "<title>"
When User updates article 
Then Article is Updated

Scenario: Delete an Article
Given Article is Created "<title>"
When User Deletes article
Then Article is Deleted "<title>"