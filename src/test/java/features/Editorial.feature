Feature: This feature will make the search show the results that are determined by editorial, as well as generic searches.

  Scenario:  Editorial Section
    Given I am on the home page
    When I search "sky" in the search bar
    Then I should see an editorial section "Help articles & guides (view all)"