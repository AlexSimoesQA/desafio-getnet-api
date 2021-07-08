
Feature: CT001 - New User
  Scenario: Validar criacao de novo usuario
    Given que eu entre com um "<name>" e "<job>"
    When eu executar a "<API>"
    Then deve ser retornado <statuscode>

    Examples: 
      |name  |job |API  	|statuscode|
      |Alex  |QA  |/users |201			 |
