Feature: Search
  # 2
  Scenario Outline: Display the search button
    Given User is on <Page>
    When User scrolls "up"
    Then Search button is visible
    Examples:
      | Page           |
      | "Services"     |
      | "Insights"     |
      | "About"        |
  # 3
  Scenario Outline: Search pages by keyword
    Given User is on <Page>
    When User clicks Search button
    And User enters <Query>
    Then User is on Results page
    Examples:
      |     Page       |  Query    |
      | "Services"     | "Contact" |
      | "Insights"     | "Contact" |
      | "About"        | "Contact" |