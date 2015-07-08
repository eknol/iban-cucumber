package iban;

import java.math.BigInteger;

public class Iban {

  public Boolean validateLength(String iban) {
    return iban.length() < 35;
  }

  public Boolean validateCountryCode(String iban) {
    return iban.startsWith("NL");
  }

  public boolean validateBankCode(String arg1) {
    char arg2[] = arg1.toCharArray();

    if (arg1.equals("RABO") || arg1.equals("INGB") || arg1.equals("ABNA")) {
      return true;
    } else if (arg2.length == 4) {
      for (char c : arg2) {
        if (!Character.isLetter(c)) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  public int validateCheckSum(String countryCode, String bankNumber, String accountNumber) {
    accountNumber = accountNumber.replaceAll("\\s+", "");

    while (accountNumber.length() < 10) {
      accountNumber = "0" + accountNumber;
    }

    AlphabetCalculator result = new AlphabetCalculator();
    StringBuffer sb = new StringBuffer(accountNumber);
    StringBuffer sb2 = new StringBuffer();

    for (char x : bankNumber.toCharArray()) {
      int value = result.calculator(String.valueOf(x));
      sb2.append(value);
    }

    sb.insert(0, String.valueOf(sb2));

    accountNumber = String.valueOf(sb);

    for (char x : countryCode.toCharArray()) {
      int value = result.calculator(String.valueOf(x));
      accountNumber = accountNumber.concat(String.valueOf(value));
    }

    accountNumber = accountNumber.concat("00");

    BigInteger bi1, bi2, bi3;

    Integer i1;

    bi1 = new BigInteger(accountNumber);
    bi2 = new BigInteger(String.valueOf(97));

    bi3 = bi1.mod(bi2);
    i1 = bi3.intValue();

    int checkSum = 98 - i1;

    return checkSum;
  }
}
