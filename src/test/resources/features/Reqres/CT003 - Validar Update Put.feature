Feature: CT003 - Validar Update Put
  Scenario: Validar atualizacao do nome e trabalho
    Given que eu entre com um "<name>" e "<job>"
    When eu executar a "<API>" de metodo Put
    Then deve ser retornado <statuscode> update

    Examples: 
      |name  				|job 				|API  	  	|statuscode|
      |Alex Simoes  |Automator  |/users/2 	|200			 |
