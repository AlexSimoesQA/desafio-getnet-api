Feature: CT006 - Validar Register Unsuccessful
  Scenario: Validar login com sucesso
    Given que eu entrei com um "email": "<email>" e "password": "<password>"
    When eu executar a API "<API>" de metodo Post
    Then deve ser retornado <statuscode> ok

    Examples: 
      |email  						 |password   |API  		  |statuscode|
      |eve.holt@reqres.in  |cityslicka |login 		|200			 |