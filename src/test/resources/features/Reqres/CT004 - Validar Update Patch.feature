Feature: CT004 - Validar Update Patch
  Scenario: Validar atualizacao do nome e trabalho com o metodo PATCH
    Given que eu entrei com um "name": "<name>" e "job": "<job>"
    When eu executar a API "<API>" de metodo Patch
    Then deve ser retornado <statuscode> update

    Examples: 
      |name  	|job  |API  	  |statuscode|
      |Yanne  |Dev  |users/2 	|200			 |
