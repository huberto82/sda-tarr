package programowanie_zaawansowane.c3_net;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      Socket server = new Socket("localhost", 6666);
      PrintWriter output = new PrintWriter(server.getOutputStream(), true);
      Scanner input = new Scanner(new InputStreamReader(server.getInputStream()));
      System.out.println("Wpisz Q, żeby zakończyć program.");
      //Wątek odbierający dane od serwera
      new Thread(()->{
        while(input.hasNext()){
          System.out.println(input.nextLine());
        }
      }).start();
      //
      String query = null;
      while(!(query = scanner.nextLine()).equals("Q")){
        output.println(query);
      }
      output.println("END");
      server.close();
    } catch (IOException e) {
     System.out.println("Połączenie odrzucono. Sprawdz adress i port.");
    }

  }
}
