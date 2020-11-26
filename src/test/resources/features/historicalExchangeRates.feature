Feature: To validate the historical exchange from Rates API

  As a User
  I want to validate the historical exchange rates API for various test conditions
  So that I can fetch the historical exchange rates from rates API

  @HistoricalExchange
  Scenario Outline: User get successful historical exchange rate with Valid data from rates API
    Given rates API has the historical exchange rates
       | testCase   |
       | <testCase> |
    When user request to get the historical rates with <BaseCurrency>, <currencyCode> and <Date>
    Then user should get successfull response with <httpStatus>
    And user get resonse as <BaseCurrency>, <currencyCode> and <Date>
    And validate the Content Type as "application/json"
    Examples:
      |testCase| BaseCurrency | currencyCode | date       | httpStatus |
      |tc001   | GBP          | USD          | 2019-11-25 | 200        |

  @HistoricalExchange
  Scenario Outline: User request with invaild request and get invaild response
    When user request to get the historical rates with <BaseCurrency>, <currencyCode> and invalid <Date>
    Then user should get response code as <httpStatus>
    Examples:
      | BaseCurrency | currencyCode | date  | httpStatus |
      | GBP          | USD          | 1-1-1 | 400        |