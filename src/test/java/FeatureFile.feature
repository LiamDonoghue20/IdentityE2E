@selenium
Feature: DVLA Feature file

  Scenario: Verify that the database holds the same record as the website
    Given I am on the webpage https://www.gov.uk/get-vehicle-information-from-dvla
    When I am on the vehicle details page
    And I can call the service bean
    Then the data on display should match the records on the csv file