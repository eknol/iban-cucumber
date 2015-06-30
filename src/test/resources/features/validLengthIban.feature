@ValidLengthIban
Feature: Valid length iban number
  As an
  I want the max length of an iban number to be 34 alpha-numeric characters long
  So that I can

  Scenario:
    #Given an invalid iban number larger then 34 characters long
    When iban number is 12345678901234567890123456789012345
    Then it is an invalid iban number


