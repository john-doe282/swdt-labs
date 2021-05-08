Feature: Language change
  # 7
  Scenario Outline: Change language from English to Russian
    Given User is on <Page>
    When User clicks language button
    And User chooses Russian language
    Then <Page> language is set to Russian
    Examples:
      | Page           |
      | "Services"     |
      | "Insights"     |
      | "About"        |