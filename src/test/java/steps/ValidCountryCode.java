package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import iban.Iban;

import static org.junit.Assert.assertEquals;

public class ValidCountryCode {

  private Iban iban;

  boolean result;
  boolean value;

  @Before("@ValidateCountryCode")
  public void before() {
    iban = new Iban();
  }

  @When("a Dutch (.+) starts with NL")
  public boolean a_Dutch_var_starts_with_NL(String arg1) throws Throwable {
    result = iban.validateCountryCode(arg1);
    return result;
  }

  @Then("it has a (.+) country code")
  public void it_has_a_var_country_code(String arg2) throws Throwable {
    if (arg2.equals("invalid")) {
      value = false;
    } else if (arg2.equals("valid")) {
      value = true;
    }
    assertEquals(value, result);
  }
}
