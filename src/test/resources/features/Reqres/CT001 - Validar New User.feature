Feature: CT001 - Validar New User
  Scenario: Validar criacao de novo usuario
    Given que eu entrei com um "name": "<name>" e "job": "<job>"
    When eu executar a API "<API>" de metodo Post
    Then deve ser retornado <statuscode> created

    Examples: 
      |name  |job |API  	|statuscode|
      |Alex  |QA  |/users |201			 |
