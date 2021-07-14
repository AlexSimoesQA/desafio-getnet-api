Feature: CT009 - Validate Single User
  Scenario: Validate single user
    When I run a get method api "<API>"
    Then Should be returned <statuscode> not found

    Examples: 
      |API  	  |statuscode|
      |users/23 |404			 |