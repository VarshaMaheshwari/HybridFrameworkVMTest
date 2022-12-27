@MyFeature
Feature: My test feature

  Scenario: Just a normal test
    Given I have api payload
    When I do get api call
    Then I get valid api response code and responsebody

  Scenario: Just one more datatable test
    Given I have user and password for login
    |user|pwd|
    |varsha|test123|
    |naresh|test12  |
    When I do get api call
    Then I get valid api response code and responsebody