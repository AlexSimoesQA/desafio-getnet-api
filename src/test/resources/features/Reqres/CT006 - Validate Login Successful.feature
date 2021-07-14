Feature: CT006 - Validate Login Successful
  Scenario: Validate Login Successful
    Given I send "email": "<email>" and "password": "<password>"
    When I run a post method api "<API>"
    Then Should be returned <statuscode> ok

    Examples: 
      |email  						 |password   |API  		  |statuscode|
      |eve.holt@reqres.in  |cityslicka |login 		|200			 |