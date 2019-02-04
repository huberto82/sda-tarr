package programowanie_zaawansowane.c3_net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpURLConnectionDemo {
  public static void main(String[] args) throws IOException {
    URL host = new URL("http://www.google.com");
    HttpURLConnection httpCon = (HttpURLConnection) host.openConnection();
    System.out.println("Metoda żadania " + httpCon.getRequestMethod());
    System.out.println("Kod odpowiedzi " + httpCon.getResponseCode());
    System.out.println("Odpowiedź " + httpCon.getResponseMessage());
    System.out.println("Pola nagłówka.");
    httpCon.getHeaderFields().forEach((key, value)->{
      System.out.println("Pole: "+key);
      System.out.println("\tWartość: "+value);
    });
  }
}
