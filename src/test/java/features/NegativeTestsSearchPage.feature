Feature: Search company on Google with empty and misspelled text

  Scenario Outline: Search empty string in google search

    Given User is on Google search home page negative
    When User searched with empty "<Name>" input
    Then User gets the incorrect result items in Google Search page


    Examples:
      | Name         |
      |    |






