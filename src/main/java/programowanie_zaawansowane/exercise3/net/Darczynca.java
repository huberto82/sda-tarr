package programowanie_zaawansowane.exercise3.net;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Darczynca {
  public static void main(String[] args) {
    try {
      Socket klient = new Socket("localhost", 6666);
      Scanner daneOdSerwera = new Scanner(new InputStreamReader(klient.getInputStream()));
      PrintWriter daneDoSerwera = new PrintWriter(klient.getOutputStream(), true);
      //Osobny wątek na odbiór danych od serwera
      new Thread(() -> {
        while (daneOdSerwera.hasNext()) {
          System.out.println("SERWER: "+daneOdSerwera.nextLine());
        }
      }).start();
      //W głównym wątku pobieramy łancuchy z klawiatury i wysyłamy do serwera
      Scanner klawiatura = new Scanner(System.in);
      while (klawiatura.hasNextLine()) {
        if (klawiatura.hasNextInt()) {        // czy wpisano liczbę
          String str = klawiatura.nextLine();
          daneDoSerwera.println(str);         //przesłanie liczby do serwera
        } else {
          if (klawiatura.nextLine().equals("Q")) {   //czy koniec programu?
            klient.close();                          //zamknięcie połączenia z serwerem
            return;
          } else {
            klawiatura.nextLine();             //usunięcie z bufora klawiatury lancuchów
            System.out.println("Wpisz liczbę!!!");
          }
        }
      }
    } catch (IOException e) {
      System.err.println("Nie udało połączyć się z serwerem!!!");
    }
  }
}
