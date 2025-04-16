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
 |Sakti Article-10|test article|This is a Test Article|BDD,POM,article,test|
Then Article must be created


Scenario: View Article
Given User should be on Global Feed page
When User select an article "Article title"
Then Article detail page must be displayed
