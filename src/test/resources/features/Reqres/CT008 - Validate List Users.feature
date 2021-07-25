Feature: CT008 - Validate List Users
  Scenario Outline: Validate list users
    When I run a get method api "<API>"
    Then Should be returned <statuscode> ok
    And must validade a list of users

    Examples: 
      |API  				|statuscode|
      |users?page=2 |200			 |
