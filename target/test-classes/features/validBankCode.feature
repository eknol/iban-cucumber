@ValidateBankCode
Feature: Iban validation
  As an iban number consumer
  I want to be able to validate an iban number
  So that I know that I can trust a given iban number

  Scenario Outline: a dutch bank code always consists of four letters
    When the bank code is <bank code>
    Then this bank code is <status>

    Examples:
      | bank code | status  |
      | RABO      | valid   |
      | INGB      | valid   |
      | ABNA      | valid   |
      | Rabobank  | invalid |
      | ING       | invalid |
      | ABNAM     | invalid |
      | 123       | invalid |
      | !2B       | invalid |
      | ABC1      | invalid |
