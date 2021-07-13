Feature: CT003 - Validar Update Put
  Scenario: Validar atualizacao do nome e trabalho com o metodo PUT
    Given que eu entrei com um "name": "<name>" e "job": "<job>"
    When eu executar a API "<API>" de metodo Put
    Then deve ser retornado <statuscode> update

    Examples: 
      |name  				|job 				|API  	  |statuscode|
      |Alex Simoes  |Automator  |users/2 	|200			 |
