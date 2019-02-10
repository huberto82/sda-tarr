package programowanie_zaawansowane.c8_sha256;

import sun.plugin2.applet.Plugin2ClassLoader;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHADemo {

  private static String bytesToHex(byte[] hash) {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if(hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }
    return hexString.toString();
  }

  public static void main(String[] args) throws NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    String originalString = "hasło1234";
    byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
    String encodedPass = bytesToHex(encodedhash);
    System.out.println(encodedPass);
    Scanner scan = new Scanner(System.in);
    System.out.println("Wpisz hasło");
    String password = scan.nextLine();
    String encodedNewPass = bytesToHex(digest.digest(password.getBytes(StandardCharsets.UTF_8)));
    if (encodedNewPass.equals(encodedPass)){
      System.out.println("Poprawne hasło");
    } else {
      System.out.println("Hacker?");
    }

  }
}
