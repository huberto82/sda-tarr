package programowanie_zaawansowane.excercise2.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//TODO aplikacja graficzna do pobierania kodu HTML dowolnej strony
//TODO pole TextField - adres strony
//TODO pole TextArea - kod strony
//TODO przycisk Button - pobranie strony
public class HttpDemo {
  public static void main(String[] args) throws IOException {
    URL adresSerwera = new URL("http://www.google.com");
    HttpURLConnection http = (HttpURLConnection) adresSerwera.openConnection();
    System.out.println(http.getRequestMethod());
    System.out.println(http.getContent());
    Scanner in = new Scanner(http.getInputStream());
    Pattern pat = Pattern.compile("meta([^>]*)");
    Pattern imgpat = Pattern.compile("img([^>]*)\"");
    Matcher matcher;
    Matcher imgMatcher;
    //wyświetlić tylko zawartość znaczników meta - <meta ######## >
    while(in.hasNext()){
      String line = in.nextLine();
      matcher = pat.matcher(line);
      imgMatcher = imgpat.matcher(line);
      while(matcher.find()){
        System.out.println(matcher.group(1));
      }
      while(imgMatcher.find()){
        System.out.println(imgMatcher.group(1));
      }

    }
  }
}
