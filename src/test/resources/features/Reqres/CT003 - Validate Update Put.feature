Feature: CT003 - Validate Update Put
  Scenario Outline: Validate name and job update using put method
    Given I send "name": "<name>" and "job": "<job>"
    When I run a put method api "<API>"
    Then Should be returned <statuscode> update

    Examples: 
      |name  				|job 				|API  	  |statuscode|
      |Alex Simoes  |Automator  |users/2 	|200			 |
