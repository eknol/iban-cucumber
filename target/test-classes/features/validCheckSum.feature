@ValidCheckSum
Feature: Iban validation
  As an iban number consumer
  I want to be able to validate an iban number
  So that I know that I can trust a given iban number

  Scenario: checkSum iban number
    When the country code is NL, bank number is INGB and account number is 0001 2345 67
    Then the checkSum should be 20
