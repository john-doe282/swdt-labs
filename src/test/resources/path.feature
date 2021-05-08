Feature: Displaying path to current page
  # 4
  Scenario Outline: Display path
    Given User is on <Page>
    When User scrolls "up"
    Then <Page> path is visible
    Examples:
      | Page           |
      | "Services"     |
      | "Insights"     |
      | "About"        |