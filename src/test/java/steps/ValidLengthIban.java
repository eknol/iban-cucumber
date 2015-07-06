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
  public boolean iban_number_is_var(String arg1) throws Throwable {
    //TODO Complete this method, add your code here
    return result;
  }

  @Then("it is a (.+) iban length")
  public void it_is_a_var_iban_length(String arg2) throws Throwable {
    if (arg2.equals("invalid")) {
      value = false;
    } else if (arg2.equals("valid")) {
      value = true;
    }
    assertEquals(value, result);
  }
}
