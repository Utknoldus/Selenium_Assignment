Feature: Login Functionality


  Scenario: Login Successful for Chrome
    Given I am in the login page of the DemoQa site
    When Take data from excel sheet
    Then Browser close automatically

  Scenario: Login Successful for Firefox
    Given I am in the login page of the DemoQa site for firefox
    When Take data from excel sheet for firefox
    Then Browser close automatically for firefox

  Scenario: Login Successful for headless
    Given I am in the login page of the DemoQa site for headless
    When Take data from excel sheet for headless for headless
    Then Browser close automatically for headless for headless
