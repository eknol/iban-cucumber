package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import iban.Iban;

import static org.junit.Assert.assertEquals;

public class ValidBankCode {

  private Iban iban;

  boolean result;
  boolean value;

  @Before("@ValidateBankCode")
  public void before() {
    iban = new Iban();
  }

  @When("the bank code is (.+)")
  public boolean the_bank_code_is_var(String arg1) throws Throwable {
    result = iban.validateBankCode(arg1);
    return result;
  }

  @Then("this bank code is (.+)")
  public void this_bank_code_is_var(String arg2) throws Throwable {
    if (arg2.equals("invalid")) {
      value = false;
    } else if (arg2.equals("valid")) {
      value = true;
    }
    assertEquals(value, result);
  }
}
