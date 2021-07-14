Feature: CT002 - Validate Register Unsuccessful
  Scenario: Validate that it is not possible to register by sending only the email
    Given I send email: "<email>"
    When I run a post method api "<API>"
    Then Should be returned <statuscode> bad request

    Examples: 
      |email  						 |API  		  |statuscode|
      |eve.holt@reqres.in  |register  |400			 |