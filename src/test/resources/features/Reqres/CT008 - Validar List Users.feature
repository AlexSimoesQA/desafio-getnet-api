Feature: CT008 - Validar List Users
  Scenario: Validar criacao de novo usuario
    When eu executar a API "<API>" de metodo GET
    Then deve ser retornado <statuscode> ok
    And deve validar a lista de usuarios

    Examples: 
      |API  				|statuscode|
      |users?page=2 |200			 |
