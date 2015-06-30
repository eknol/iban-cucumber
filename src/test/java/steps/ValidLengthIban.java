package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import iban.Iban;

public class ValidLengthIban {

  private Iban iban;

  @Before("@ValidLengthIban")
  public void before() {
    iban = new Iban();
  }

  @When("iban number is (.+)")
  public void the_iban_number_is_larger_then_characters_long(String arg1) throws Throwable {
    iban.validateLength(arg1);
  }

  @Then("it is an (.+) iban number")
  public boolean it_is_an_invalid_iban_number() throws Throwable {

    return false;
  }
}
