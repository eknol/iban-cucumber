package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import iban.Iban;

import static org.junit.Assert.assertEquals;

public class ValidCheckSum {

  private Iban iban;
  int result;

  @Before("@ValidCheckSum")
  public void before() {
    iban = new Iban();
  }

  @When("the country code is (.+), bank number is (.+) and account number is (.+)")
  public int the_country_code_is_var_bank_number_is_var_and_account_number_is_var (String arg1, String arg2, String arg3) throws Throwable {
    result = iban.validateCheckSum(arg1, arg2, arg3);
    return result;
  }

  @Then("the checkSum should be (.+)")
  public void the_checkSum_should_be_var(String arg4) throws Throwable {
    assertEquals(String.valueOf(result), arg4);
  }
}
