Feature: Basic Syntax

  @sample_tag
  Scenario: This is scenario 1
    Given user is on the TS homepage
    When user clicks on About Us button
    Then user is redirected to About Us page
    And the About Us page title is verified
