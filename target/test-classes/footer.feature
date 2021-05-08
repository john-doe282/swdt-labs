Feature: Footer
  # 8
  Scenario Outline: Display footer
    Given User is on <Page>
    When User scrolls "down"
    Then Footer is visible
    Examples:
      | Page           |
      | "Services"     |
      | "Insights"     |
      | "About"        |