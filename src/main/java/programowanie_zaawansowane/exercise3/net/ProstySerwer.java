package programowanie_zaawansowane.exercise3.net;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProstySerwer {
  static final Logger log = Logger.getAnonymousLogger();
  private static int suma = 0;

  static void dodaj(int kwota){
    suma = suma + kwota;
  }

  static int suma(){
    return suma;
  }

  public static void main(String[] args) {
    try {
      log.addHandler(new FileHandler("serwer.log"));
    } catch (IOException e) {
      System.err.println("Nie można utworzyć pliku log. Koniec programu");
      return;
    }
    try {
      ServerSocket gniazdkoSerwera = new ServerSocket(6666);
      while (true) {
        Socket gniazdkoKlienta = gniazdkoSerwera.accept();
        log.log(Level.INFO, "Połączenie z klientem " + gniazdkoKlienta.getInetAddress());
        Scanner daneOdKlienta = new Scanner(new InputStreamReader(gniazdkoKlienta.getInputStream()));
        PrintWriter daneDoKlienta = new PrintWriter(gniazdkoKlienta.getOutputStream(), true);
        daneDoKlienta.println("Połączyłeś się z serwerem!");
        while (daneOdKlienta.hasNext()) {
          if (daneOdKlienta.hasNextInt()) {
            int kwota = daneOdKlienta.nextInt();
            dodaj(kwota);
            daneDoKlienta.println("Dzięki!!!");
          } else {
            daneOdKlienta.nextLine();
            daneDoKlienta.println("Nie rozumiem. Prześlij pieniadze!!!");
          }
        }
        log.log(Level.INFO, "Zakończono połączenie z klientem " + gniazdkoKlienta.getInetAddress());
      }
    } catch (IOException e) {
      log.log(Level.WARNING, "Nie udało się otworzyć gniazda nasłuchującego!!! Koniec programu.");
    }
  }
}
