@CheckSum
Feature: CheckSum
  As an iban account number user
  I want a checksum number
  So that I can check the validity of an iban account number

  Scenario: checksum
    #Given a valid iban account number
    When ibanNumber is NL20 INGB 0001 2345 67
    Then checksum should be 20
