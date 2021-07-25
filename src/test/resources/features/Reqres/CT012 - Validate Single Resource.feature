Feature: CT012 - Validate Single Resource
  Scenario Outline: Validate single resource
    When I run a get method api "<API>"
    Then Should be returned <statuscode> ok
    And must validade a single resource

    Examples: 
      |API  	   |statuscode|
      |unknown/2 |200			  |