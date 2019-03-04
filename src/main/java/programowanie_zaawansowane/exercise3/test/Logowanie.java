package programowanie_zaawansowane.exercise3.test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.Scanner;

public class Logowanie {

  private static String bytesToHex(byte[] hash) {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if(hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }
    return hexString.toString();
  }

  public static String skrot(String haslo) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] skrot = digest.digest(haslo.getBytes(StandardCharsets.UTF_8));
    return bytesToHex(skrot);
  }

  public static void main(String[] args) throws NoSuchAlgorithmException {

    Person user = Person.utworz("admin", LocalDate.of(2000,10,10));
    //Ustawienie hasla przez użytkownika
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    String haslo = "1234";
    byte[] skrot = digest.digest(haslo.getBytes(StandardCharsets.UTF_8));
    String skrotString = bytesToHex(skrot);
    user.setHaslo(skrotString);

    //Logowanie użytkownika i testowanie poprawnosci hasło
    Scanner input = new Scanner(System.in);
    haslo = input.nextLine();

    skrot = digest.digest(haslo.getBytes(StandardCharsets.UTF_8));
    skrotString = bytesToHex(skrot);

    if (user.poprawneHaslo(skrotString)){
      System.out.println("Zalogowano");
    } else {
      System.out.println("Błęde haslo");
    }



  }

}
