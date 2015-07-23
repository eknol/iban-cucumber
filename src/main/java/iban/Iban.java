package iban;

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
    CheckSum checkSum = new CheckSum();
    return checkSum.returnCheckSum(countryCode,bankNumber, accountNumber);
  }

}
