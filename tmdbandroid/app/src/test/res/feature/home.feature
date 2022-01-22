Feature: Home Navigation
  Test action on home page
  Scenario Outline: Click on Go To Search
    Given I open Application <AppName>
    When I click on <Button>
    Then Search Fragment open after <Answer> seconds

    Examples:
      | AppName       | Button                | Answer |
      | "TmdbAndroid" | "Go to Search Button" | 42     |