Feature: Login functionality

  Scenario: Successful login
    Given the user is on the login page
    When the user enters "user" as username and "pass" as password
    And clicks the login button
    Then the user should see "Login successful!"

  Scenario: Failed login
    Given the user is on the login page
    When the user enters "wronguser" as username and "wrongpass" as password
    And clicks the login button
    Then the user should see "Invalid credentials."