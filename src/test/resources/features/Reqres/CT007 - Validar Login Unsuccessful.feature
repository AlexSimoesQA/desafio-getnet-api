Feature: CT007 - Validar Login Unsuccessful
  Scenario: Validar que nao e possivel fazer login passando apenas o email
    Given que eu entrei com um email: "<email>"
    When eu executar a API "<API>" de metodo Post
    Then deve ser retornado <statuscode> Bad Request

    Examples: 
      |email  			|API  	|statuscode|
      |peter@klaven |login  |400			 |
