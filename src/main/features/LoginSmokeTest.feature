@login
Feature: Login

@Loginuser
Scenario: Login With User Crdentials

Given User is able to access TalentScreen HomePage and Click Login button
When User Click enters credentials.
|name|password|
|a@a.com|test123|
|b@b.com|test456|
And User Click Submit button
Then User should be navigated to Login Success Home page.

@loginsocial
Scenario Outline: Login With SocialNetworking

Given User is able to access TalentScreen HomePage and Click Login button
When User Click on  "<socialNetButton>"  button
Then User should see a new "<socailNetWindow>" window.

Examples:
|socialNetButton|socailNetWindow|
|Facebook| fbwindow|
|Google| gmailwindow|
