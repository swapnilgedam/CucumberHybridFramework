Feature: Login Funcionality

  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address <username> into email field
    And User enters valid password <password> into password field
    And User clicks on Login button
    Then User should get successfuly logged in
    
    Examples: 
    |username          |password|
    |swapnil1@gmail.com|123456  | 
    |swapnil2@gmail.com|123456  |
    |swapnil3@gmail.com|123456  |

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with valid email and invalid password
    Given User navigates to login page
    When User enters valid email address "swapnilgedam358@gmail.com" into email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters valid password "123456" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login without providing any credentials
    Given User navigates to login page
    When User dont enter email address into email field
    And User dont enter password into password field
     And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
    
