Feature: CT010 - Validate Single User Not Found
  Scenario Outline: Validate single user not found
    When I run a get method api "<API>"
    Then Should be returned <statuscode> not found

    Examples: 
      |API  	  |statuscode|
      |users/23 |404			 |