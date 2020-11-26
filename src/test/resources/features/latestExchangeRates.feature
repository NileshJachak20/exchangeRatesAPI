Feature: To validate the latest exchange from Rates API

  As a User
  I want to validate the latest exchange rates API for various test conditions
  So that I can fetch the latest exchange rates from rates API

  @latestExchange
  Scenario Outline: User get successful latest exchange rate with Valid data from rates API
    Given rates API has the latest exchange rates
    When user request to get the latest rates with <BaseCurrency> and <currencyCode>
    Then user should get successfull response with <httpStatus>
    And user get resonse as <BaseCurrency> and <currencyCode>
    And validate the Content Type as "application/json"
    Examples:
      | BaseCurrency | currencyCode | httpStatus |
      | GBP          | USD          | 200        |

   @latestExchange
  Scenario Outline: User request with invaild request and get invaild response
    When user request to get the latest rates with <BaseCurrency> and <currencyCode>
    Then user should get response code as <httpStatus>
    Examples:
      | BaseCurrency | currencyCode | date  | httpStatus |
      | GBP          | BgS          | 1-1-1 | 400        |