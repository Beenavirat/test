Feature: This feature will make sure that the shop page is navigable and usable.

  Scenario Outline: User sees tiles on the shop page
    Given I am on the home page
    When I try to sign in with invalid credentials email or username "<email or username>"
    Then I should see a box with the text "Create your My Sky password"

    Examples:
      | email or username |
      | xxx@yyy.com       |