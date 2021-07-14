Feature: CT005 - Validate Register Successful
  Scenario: Validate register successful
    Given I send "email": "<email>" and "password": "<password>"
    When I run a post method api "<API>"
    Then Should be returned <statuscode> ok

    Examples: 
      |email  						 |password  |API  		|statuscode|
      |eve.holt@reqres.in  |pistol   	|register |200			 |