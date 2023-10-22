Feature: Search company on Google


  Scenario Outline: Search Jpmorgan in google search

    Given User is on Google search home page
    When User searched with "<Name>" input
    Then User gets the result items in Google Search page


    Examples:
      | Name         |
      | J. P. Morgan |

  @last_scenario
  Scenario: Verify Logo
    Given User is on JpMorgan HomePage
    When The user verifies the Logo of Jpmorgan
    Then  verify user verify that the J.P. Morgan logo is shown



