package programowanie_zaawansowane.excercise2.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
  public static void main(String[] args) {
    try {
      Socket server = new Socket("localhost",6565);
      //strumień wyjściowy - wysyłanie do serwera
      PrintWriter output = new PrintWriter(server.getOutputStream(), true);
      //strumień wejściowy - odbieranie do serwera
      Scanner input = new Scanner(server.getInputStream());
      //wątek odbierający dane od serwera
      new Thread(()->{
        while(input.hasNext()){
          System.out.println("Serwer wysłał " + input.nextLine());
        }
      }).start();

      Scanner keyboard = new Scanner(System.in);
      String query;

      //odczyt łańcucha z klawiatury i wysłanie do serwera
      while(!(query = keyboard.next()).equals("Q")){
        output.println(query);
      }

      server.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
