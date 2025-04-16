Feature: Conduit CRUD Functions

Scenario:  Login into App
Given User is on Login page
#When User provide "username" and "password"
When User enters credentials
|username|password|
|mail2saktivelavan@gmail.com|Demo123|
#|tomsmith|SuperSecretPassword!|
Then User should be on Home Page

Scenario: Create new Article
Given User should be on New Article Page
When User enters Article details
 | title | Desc | Content | tag |
 |Sakti Article-20|test article|This is a Test Article|BDD,POM,article,test|
Then Article must be created


Scenario: View Article
Given User should be on Global Feed page
When User select an article "Article title"
Then Article detail page must be displayed


Scenario: Update an Article
Given Article detail page must be displayed
When User update article detail
Then Article detail must be updated


Scenario: Delete an Article
Given Article detail page must be displayed
When User delete article 
Then Article must be deleted
