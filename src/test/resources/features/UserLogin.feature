Feature: Conduit CRUD Functions

Scenario:  Login into App
Given User is on Login page
#When User provide "username" and "password"
When User enters credentials
|username|password|
|mail2saktivelavan@gmail.com|Demo123|
#|tomsmith|SuperSecretPassword!|
Then User should be on Home Page

