Feature: CT005 - Validar Register Unsuccessful
  Scenario: Validar que nao e possivel fazer registro passando apenas o email
    Given que eu entrei com um "email": "<email>" e "password": "<password>"
    When eu executar a API "<API>" de metodo Post
    Then deve ser retornado <statuscode> ok

    Examples: 
      |email  						 |password  |API  		 |statuscode|
      |eve.holt@reqres.in  |pistol   	|/register |200			  |