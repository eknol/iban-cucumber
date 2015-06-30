@ValidLengthIban
Feature: Valid length iban number
  As an
  I want the max length of an iban number to be 34 alpha-numeric characters long
  So that I can

  Scenario:
    #Given an invalid iban number
    When the iban number is larger then 34 characters long
    Then it is an invalid iban number


