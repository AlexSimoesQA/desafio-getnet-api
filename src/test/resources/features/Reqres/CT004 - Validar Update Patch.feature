Feature: CT004 - Validar Update Patch
  Scenario: Validar atualizacao do nome e trabalho
    Given que eu entre com um "<name>" e "<job>"
    When eu executar a "<API>" de metodo Patch
    Then deve ser retornado <statuscode> update

    Examples: 
      |name  	|job  |API  	  	|statuscode|
      |Yanne  |Dev  |/users/2 	|200			 |
