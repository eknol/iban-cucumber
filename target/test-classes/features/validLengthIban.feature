@ValidLengthIban
Feature: Iban validation
  As an iban number consumer
  I want to be able to validate an iban number
  So that I know that I can trust a given iban number

  Scenario Outline: Maximum length of an iban number is 34 characters
    When iban number is <iban>
    Then it is a <status> iban length

    Examples:
      | iban                                | status  |
      | 1234567890123456789012345678901234  | valid   |
      | 123456789012345678901234567890123   | valid   |
      | 12345678901234567890123456789012345 | invalid |



