Feature: CT007 - Validate Login Unsuccessful
  Scenario: Validate that it is not possible to login by sending only the email
    Given I send email: "<email>"
    When I run a post method api "<API>"
    Then Should be returned <statuscode> bad request

    Examples: 
      |email  			|API  	|statuscode|
      |peter@klaven |login  |400			 |
