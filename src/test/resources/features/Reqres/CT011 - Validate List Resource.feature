Feature: CT011 - Validate List Resource
  Scenario: Validate list of resource
    When I run a get method api "<API>"
    Then Should be returned <statuscode> ok
    And must validade a list of resource

    Examples: 
      |API  	 |statuscode|
      |unknown |200			  |
