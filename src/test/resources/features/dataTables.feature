Feature: Examples of Cucumber data table implementations


  Scenario: List of fruits I like
    Then user should see fruits I Like
      | kiwi        |
      | banana      |
      | cucumber    |
      | orange      |
      | grape       |
      | pomegranate |