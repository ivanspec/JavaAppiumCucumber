Feature: Sample Register

  @test
  Scenario: User can register
    Given User open the application
    When User fill username and password
    Then Sucessfull register