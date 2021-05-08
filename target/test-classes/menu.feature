Feature: Menu
  # 5
  Scenario Outline: Display menu
    Given User is on <Page>
    When User scrolls "up"
    Then Menu is visible
    Examples:
      | Page           |
      | "Services"     |
      | "Insights"     |
      | "About"        |

  # 6
  Scenario Outline: Highlight current page
    Given User is on <Page>
    Then <Page> is highlighted in Menu bar
    Examples:
      | Page           |
      | "Services"     |
      | "Insights"     |
      | "About"        |
