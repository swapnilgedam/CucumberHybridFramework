Feature: Registration functionality

  Scenario: User creates an account only with mandatory field
    Given User navigates to Register Account Page
    When User enters the details into below fields
      | firstName | Swapnil                     |
      | lastName  | Gedam                       |
      | telephone |                  1234567890 |
      | password  |                      123456 |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates an account with all field
    Given User navigates to Register Account Page
    When User enters the details into below fields
      | firstName | Swapnil                     |
      | lastName  | Gedam                       |
      | telephone |                  1234567890 |
      | password  |                      123456 |
    And selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

    
     Scenario: User creates a duplicate account
    Given User navigates to Register Account Page
    When User enters the details into below fields with duplicate email
      | firstName | Swapnil                     |
      | lastName  | Gedam                       |
      | email     | swapnilgedam358@gmail.com |
      | telephone |                  1234567890 |
      | password  |                      123456 |
    And selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User should get a proper warning about duplicate email
    
    
   Scenario: User creates an account without filling any details
    Given User navigates to Register Account Page
    When User dont enter any details into fields
     And User clicks on Continue button
    Then User should get proper warning message for every mandatory field
    
    