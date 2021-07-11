Feature: CT001 - Validar New User
  Scenario: Validar criacao de novo usuario
    Given que eu entre com um "<name>" e "<job>"
    When eu executar a "<API>" de metodo Post
    Then deve ser retornado <statuscode> created

    Examples: 
      |name  |job |API  	|statuscode|
      |Alex  |QA  |/users |201			 |
