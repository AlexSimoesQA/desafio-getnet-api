Feature: CT002 - Validar Register Unsuccessful
  Scenario: Validar que nao e possivel fazer registro passando apenas o email
    Given que eu entre com um "<email>"
    When eu executar a "<API>" de metodo Post
    Then deve ser retornado <statuscode> Bad Request

    Examples: 
      |email  						   |API  		  |statuscode|
      |alex.teste@gmail.com  |/register |400			 |
