@CheckSum
Feature: Checksum
  As a account number user
  I want a checksum number
  So that I validate an account number

  Scenario: checksum
    #Given a valid iban account number
    When ibanNumber is <NLxx INGB 0001 2345 67>
    Then checksum should be <20>
