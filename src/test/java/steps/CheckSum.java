package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import iban.Iban;

import static org.junit.Assert.assertEquals;

public class CheckSum {

  private Iban iban;
  int result;

  @Before("@CheckSum")
  public void before() {
    iban = new Iban();
  }

  @When("ibanNumber is <(.+)>")
  public int ibanNumber_is_(String ibanNumber) throws Throwable {
    result = iban.checkSum(ibanNumber);
    return result;
  }

  @Then("checksum should be <(\\d+)>")
  public void checksum_should_be_(String arg1) throws Throwable {
    assertEquals(String.valueOf(result), arg1);
  }
}
