Feature: CT009 - Validate Single User
  Scenario Outline: Validate single user
    When I run a get method api "<API>"
    Then Should be returned <statuscode> ok
    And must validade a single user

    Examples: 
      |API  	 |statuscode|
      |users/2 |200			  |