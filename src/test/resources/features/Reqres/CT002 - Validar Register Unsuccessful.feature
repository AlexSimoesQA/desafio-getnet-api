Feature: CT002 - Validar Register Unsuccessful
  Scenario: Validar que nao e possivel fazer registro passando apenas o email
    Given que eu entrei com um email: "<email>"
    When eu executar a API "<API>" de metodo Post
    Then deve ser retornado <statuscode> Bad Request

    Examples: 
      |email  						 |API  		  |statuscode|
      |eve.holt@reqres.in  |/register |400			 |
