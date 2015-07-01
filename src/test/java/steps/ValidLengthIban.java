package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import iban.Iban;

import static org.junit.Assert.assertEquals;

public class ValidLengthIban {

  private Iban iban;

  boolean result;
  boolean value;

  @Before("@ValidLengthIban")
  public void before() {
    iban = new Iban();
  }

  @When("iban number is (.+)")
  public boolean the_iban_number_is_larger_then_characters_long(String arg1) throws Throwable {
    result = iban.validateLength(arg1);
    return result;
  }

  @Then("it is an (.+) iban number")
  public void it_is_an_invalid_iban_number(String arg2) throws Throwable {
    if (arg2.equals("invalid")) {
      value = false;
    } else if (arg2.equals("valid")) {
      value = true;
    }
    assertEquals(value, result);
  }
}
