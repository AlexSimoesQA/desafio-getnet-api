Feature: CT014 - Validate Delete
  Scenario: Validate delete
    When I run a delete method api "<API>"
    Then Should be returned <statuscode> delete

    Examples: 
      |API  	 |statuscode|
      |users/2 |204			  |