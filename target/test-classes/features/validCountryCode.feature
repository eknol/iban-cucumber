@ValidateCountryCode
Feature: Iban validation
  As an iban number consumer
  I want to be able to validate an iban number
  So that I know that I can trust a given iban number

  Scenario Outline: a Dutch iban number starts with the country code NL
    When a Dutch <iban number> starts with NL.
    Then it has a <status> country code.

    Examples:
      | iban number              | status  |
      | NL 20 INGB 0001 2345 67  | valid   |
      | Ned 20 INGB 0001 2345 67 | invalid |
      | 20 INGB 0001 2345 67     | invalid |
      | DU 20 INGB 0001 2345 67  | invalid |
