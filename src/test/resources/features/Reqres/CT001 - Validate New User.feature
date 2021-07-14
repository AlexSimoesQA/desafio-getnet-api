Feature: CT001 - Validate New User
  Scenario: Validate new user creation
    Given I send "name": "<name>" and "job": "<job>"
    When I run a post method api "<API>"
    Then Should be returned <statuscode> created

    Examples: 
      |name  |job |API   |statuscode|
      |Alex  |QA  |users |201			  |