Feature: Login Webdriverio
  @test
  Scenario: User can login in app webdriverio
    Given User open the app
    When User fill username and password existing
    Then User successful login