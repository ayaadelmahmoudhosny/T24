Feature: Login to website using username and password

  Scenario Outline: Login using username and password

    Given User login with username <name> and password <password>
    When User taps on Sign Button
    Then User goes to <options>

    Examples:
      |   name     |password|options|
      |AUTOMATION.1|Aa12345&|valid|
      |AUTOMTIION.2|FGs&23UF|invalid|

