package iban;

import java.math.BigInteger;

public class CheckSum {

  public int returnCheckSum(String countryCode, String bankNumber, String accountNumber) {
    String var3 = accountNumber.replaceAll("\\s+", "");

    var3 = addZeros(var3);
    var3 = convertLettersToNumbers(countryCode, bankNumber, var3);
    var3 = addMoreZeros(var3);
    return modulo(var3);
  }

  private String addZeros(String accountNumber) {
    while (accountNumber.length() < 10) {
      accountNumber = "0" + accountNumber;
    }
    return accountNumber;
  }

  private String convertLettersToNumbers(String countryCode, String bankNumber, String accountNumber) {
    StringBuffer sb = new StringBuffer(accountNumber);
    StringBuffer sb2 = new StringBuffer();

    for (char x : bankNumber.toCharArray()) {
      int value = alphaCalc(String.valueOf(x));
      sb2.append(value);
    }

    sb.insert(0, String.valueOf(sb2));

    accountNumber = String.valueOf(sb);

    for (char x : countryCode.toCharArray()) {
      int value = alphaCalc(String.valueOf(x));
      accountNumber = accountNumber.concat(String.valueOf(value));
    }
    return accountNumber;
  }

  private int alphaCalc(String chara) {
    String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    return allChars.indexOf(chara) + 10;
  }

  private String addMoreZeros(String accountNumber) {
    accountNumber = accountNumber.concat("00");
    return accountNumber;
  }

  private int modulo(String accountNumber) {
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
