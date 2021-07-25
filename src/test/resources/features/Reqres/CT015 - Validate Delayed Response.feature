Feature: CT015 - Validate Delayed Response
  Scenario Outline: Validate delayed response
    When I run a get method api "<API>"
    Then Should be returned <statuscode> ok
    And must validate list after delayed response

    Examples: 
      |API  				 |statuscode|
      |users?delay=3 |200			  |
