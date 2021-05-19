Feature: WebSite loading
  # 1
  Scenario: load the page
    Given User is connected to the Internet
    When User is on "Main"
    Then Page title is "EPAM | Enterprise Software Development, Design & Consulting"
