Feature: User should be able to login using correct credentials


  Scenario: Positive login scenario
    Given user is on the login page of web table app
    When users enters username "Test"
    And users enters password "Tester"
    And users clicks to login button
    Then user should see url contains orders
  @wip
  Scenario: Positive login scenario
    Given user is on the login page of web table app
    When users enters username "Test" password "Tester" and logins
    Then user should see url contains orders

    #1- implement this new step
    #2- create login method in WebTableLoginPage
    # this login method should have multiple different overloaded version