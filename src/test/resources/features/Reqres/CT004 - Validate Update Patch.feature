Feature: CT004 - Validate Update Patch
  Scenario Outline: Validate name and job update using patch method
    Given I send "name": "<name>" and "job": "<job>"
    When I run a patch method api "<API>"
    Then Should be returned <statuscode> update

    Examples: 
      |name  	|job  |API  	  |statuscode|
      |Yanne  |Dev  |users/2 	|200			 |
