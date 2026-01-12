# Automation for https://automationexercise.com/

Feature: Open website

  Scenario: Open homepage successfully
    Given I open the demo website
    Then the page title should contain "Demo"