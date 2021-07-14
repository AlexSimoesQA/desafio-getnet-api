Feature: CT013 - Validate Single Resource Not Found
  Scenario: Validate single resource not found
    When I run a get method api "<API>"
    Then Should be returned <statuscode> not found

    Examples: 
      |API  	    |statuscode|
      |unknown/23 |404			 |