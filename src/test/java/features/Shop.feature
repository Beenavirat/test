Feature: This feature will make sure that the shop page is navigable and usable.

  Background:
    Given I am on the home page
    When I navigate to ‘Deals’

  Scenario: User navigates to shop page
    Then the user should be on the deals "Latest Sky TV deals for new customers | Sky.com" page


  Scenario: User sees a list of deals on the deals page
    Then the user should be on the deals "Latest Sky TV deals for new customers | Sky.com" page
    And I see a list of deals with a price1 price2 price3 to it
      | price1 | price2 | price3 |
      | £26    | £41    | £37    |
